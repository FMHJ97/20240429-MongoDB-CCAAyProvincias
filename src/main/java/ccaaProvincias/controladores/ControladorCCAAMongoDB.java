package ccaaProvincias.controladores;

public class ControladorCCAAMongoDB extends SuperControladorMongoDB {

	private static ControladorCCAAMongoDB instance = null;
	
	/**
	 * Constructor.
	 */
	public ControladorCCAAMongoDB() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "ccaa");
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorCCAAMongoDB getInstance() {
		if (instance == null) {
			instance = new ControladorCCAAMongoDB();
		}
		return instance;
	}

}
