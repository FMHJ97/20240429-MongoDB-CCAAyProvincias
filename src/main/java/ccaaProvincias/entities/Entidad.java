package ccaaProvincias.entities;

public class Entidad {

	protected String parent_code;
	protected String code;
	protected String label;
	
	/**
	 * Constructor.
	 */
	public Entidad() {
		super();
	}
	
	/// GETTERS & SETTERS ///

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
