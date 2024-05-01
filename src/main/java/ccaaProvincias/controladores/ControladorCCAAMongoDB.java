package ccaaProvincias.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import ccaaProvincias.entities.CCAA;
import ccaaProvincias.entities.Provincia;

public class ControladorCCAAMongoDB {
	
	private MongoCollection<Document> mc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones";
	private String collectionName = "ccaa";
	private int port = 27017;
	private static ControladorCCAAMongoDB instance = null;
	
	/**
	 * Constructor.
	 */
	public ControladorCCAAMongoDB() {
		super();
	}
	
	public static ControladorCCAAMongoDB getInstance() {
		if (instance == null) {
			instance = new ControladorCCAAMongoDB();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void updateCCAA(CCAA ccaa) {
		try {
			Document query = new Document()
					.append("code", ccaa.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", ccaa.getLabel()),
					Updates.set("parent_code", ccaa.getParent_code())
			);
			
			getCollection().updateOne(query, update);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene una colección de una BD en MongoDB.
	 * @return Colección.
	 */
	private MongoCollection<Document> getCollection() {
		if (mc == null) {
			// Mongodb creando la cadena de conexión.
	        String client_url = "mongodb://" + hostName + ":" + port + "/" + dBName;
	        MongoClientURI uri = new MongoClientURI(client_url);
	 
	        // Conectando y obteniendo un cliente.
	        MongoClient mongo_client = new MongoClient(uri);
	 
	        // Obteniendo un enlace a la base de datos.
	        MongoDatabase db = mongo_client.getDatabase(dBName);
	 
	        // Obteniendo la colección de la base de datos
	        return mc = db.getCollection(collectionName);
		}
		return mc;
	}

    /**
     * Obtiene todos los elementos de la colección ccaa.
     * @return Lista parametrizada.
     */
    public List<CCAA> getAllCCAA() {
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();

        List<CCAA> allEntities = new ArrayList<CCAA>();
        try {
            while(cursor.hasNext()) {
            	allEntities.add(documentToCCAA(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allEntities;
    }
    
    /**
     * 
     * @param doc
     * @return
     */
    private CCAA documentToCCAA(Document doc) {
    	CCAA c = new CCAA();
    	c.setParent_code(doc.getString("parent_code"));
    	c.setCode(doc.getString("code"));
    	c.setLabel(doc.getString("label"));
    	return c;
    }
	
}