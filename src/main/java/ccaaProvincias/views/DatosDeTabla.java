package ccaaProvincias.views;

import java.util.List;

import ccaaProvincias.controladores.ControladorCCAAMongoDB;
import ccaaProvincias.controladores.ControladorProvinciaMongoDB;
import ccaaProvincias.entities.CCAA;
import ccaaProvincias.entities.Provincia;

public class DatosDeTabla {
	
	private static List<Provincia> provincias = null;

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Code", "Nombre Provincia", "Parent_Code", "Nombre CCAA"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		
		List<Provincia> provincias = ControladorProvinciaMongoDB
				.getInstance().getAllProvincias();
		
		List<CCAA> ccaaList = ControladorCCAAMongoDB
				.getInstance().getAllCCAA();		
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[provincias.size()][4];
		// Cargo los datos de la lista de las provincias en la matriz de los datos.
		for (int i = 0; i < provincias.size(); i++) {
			Provincia p = provincias.get(i);
			datos[i][0] = p.getCode();
			datos[i][1] = p.getLabel();
			datos[i][2] = p.getParent_code();
			
			for (CCAA ccaa : ccaaList) {
				if (ccaa.getCode().equalsIgnoreCase(p.getParent_code())) {
					datos[i][3] = ccaa.getLabel();
				}
			}
		}		
		return datos;
	}
	
	
}
