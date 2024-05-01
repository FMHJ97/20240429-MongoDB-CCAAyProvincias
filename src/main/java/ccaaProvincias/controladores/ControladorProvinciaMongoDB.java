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
import com.mongodb.client.result.UpdateResult;

import ccaaProvincias.entities.Provincia;

public class ControladorProvinciaMongoDB {
	
	private MongoCollection<Document> mc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones";
	private String collectionName = "provincias";
	private int port = 27017;
	private static ControladorProvinciaMongoDB instance = null;
	
	/**
	 * Constructor.
	 */
	public ControladorProvinciaMongoDB() {
		super();
	}
	
	public static ControladorProvinciaMongoDB getInstance() {
		if (instance == null) {
			instance = new ControladorProvinciaMongoDB();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void updateProvincia(Provincia p) {
		try {
			Document query = new Document()
					.append("code", p.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", p.getLabel()),
					Updates.set("parent_code", p.getParent_code())
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
     * Obtiene todos los elementos de la colección provincias.
     * @return Lista parametrizada.
     */
    public List<Provincia> getAllProvincias() {
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Provincia> allEntities = new ArrayList<Provincia>();
        try {
            while(cursor.hasNext()) {
            	allEntities.add(documentToProvincia(cursor.next()));
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
    private Provincia documentToProvincia(Document doc) {
    	Provincia p = new Provincia();
    	p.setParent_code(doc.getString("parent_code"));
    	p.setCode(doc.getString("code"));
    	p.setLabel(doc.getString("label"));
    	return p;
    }
	
}