package ccaaProvincias.entities;

public class CCAA {
	
	private String code;
	private String label;
	private String parent_code;
	
	/**
	 * 
	 */
	public CCAA() {
		super();
	}
	
	@Override
	public String toString() {
		return label;
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
