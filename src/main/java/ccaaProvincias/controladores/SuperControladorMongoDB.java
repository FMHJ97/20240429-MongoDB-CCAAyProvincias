package ccaaProvincias.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ccaaProvincias.entities.Entidad;

public class SuperControladorMongoDB {
	
	private static MongoCollection<Document> mc = null;
	private String hostName = "";
	private String dBName = "";
	private String collectionName = "";
	private int port = 27017;
	
	/**
	 * Constructor.
	 * @param hostName Nombre Equipo
	 * @param dBName Nombre BBDD
	 * @param collectionName Nombre Colección
	 */
	public SuperControladorMongoDB(
			String hostName, String dBName, String collectionName) {
		this.hostName = hostName;
		this.dBName = dBName;
		this.collectionName = collectionName;
	}

	/**
	 * Obtiene una colección de una BD en MongoDB.
	 * @return Colección.
	 */
	protected MongoCollection<Document> getCollection() {
        
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
     * Obtiene todos los elementos de una colección.
     * @return Lista parametrizada.
     */
    public List<? extends Entidad> getAllEntities() {
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Entidad> allEntities = new ArrayList<Entidad>();
        try {
            while(cursor.hasNext()) {
            	allEntities.add(documentToEntity(cursor.next()));
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
    protected Entidad documentToEntity(Document doc) {
    	Entidad e = new Entidad();
    	e.setParent_code(doc.getString("parent_code"));
    	e.setCode(doc.getString("code"));
    	e.setLabel(doc.getString("label"));
    	return e;
    }
	
}