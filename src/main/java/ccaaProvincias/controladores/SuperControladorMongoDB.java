package ccaaProvincias.controladores;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	 * 
	 * @return
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

	
	
}