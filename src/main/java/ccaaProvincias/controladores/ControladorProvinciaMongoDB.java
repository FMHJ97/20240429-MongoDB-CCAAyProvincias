package ccaaProvincias.controladores;

public class ControladorProvinciaMongoDB extends SuperControladorMongoDB {

	private static ControladorProvinciaMongoDB instance = null;
	
	/**
	 * Constructor.
	 */
	public ControladorProvinciaMongoDB() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "provincia");
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorProvinciaMongoDB getInstance() {
		if (instance == null) {
			instance = new ControladorProvinciaMongoDB();
		}
		return instance;
	}

}
