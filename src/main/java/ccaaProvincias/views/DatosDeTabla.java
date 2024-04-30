package ccaaProvincias.views;

import java.util.List;

import ccaaProvincias.controladores.ControladorCCAAMongoDB;
import ccaaProvincias.controladores.ControladorProvinciaMongoDB;
import ccaaProvincias.entities.CCAA;
import ccaaProvincias.entities.Provincia;

public class DatosDeTabla {

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
		// Obtengo todos las provincias.
		List<Provincia> provincias = (List<Provincia>) ControladorProvinciaMongoDB
				.getInstance().getAllEntities();
		
		// Obtengo todas los usuarios.
		List<CCAA> ccaaList = (List<CCAA>) ControladorCCAAMongoDB
				.getInstance().getAllEntities();
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[provincias.size()][4];
		// Cargo los datos de la lista de las provincias en la matriz de los datos.
		for (int i = 0; i < provincias.size(); i++) {
			Provincia p = provincias.get(i);
			datos[i][0] = c.getId();
			
			for (TipoContrato tipoCont : tiposContratos) {
				if (tipoCont.getId() == c.getIdTipoContrato()) {
					datos[i][1] = tipoCont.getDescripcion();
				}
			}
			
			datos[i][2] = c.getDescripcion();
			
			for (Usuario usuario : usuarios) {
				if (usuario.getId() == c.getIdUsuario()) {
					datos[i][3] = usuario.getNombreUsuario();
				}
			}
			
			datos[i][4] = c.getSaldo();
			datos[i][5] = c.getLimite();
			datos[i][6] = c.getFechaFirma();
			
		}
		
		return datos;
	}
	
	
}
