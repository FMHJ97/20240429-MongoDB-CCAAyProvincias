package ccaaProvincias.entities;

public class Provincia {
	
	private String code;
	private String label;
	private String parent_code;
	
	/**
	 * 
	 */
	public Provincia() {
		super();
	}

	/// GETTERS & SETTERS ///
	
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

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	
}
