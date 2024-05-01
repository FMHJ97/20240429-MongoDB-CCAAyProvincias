package ccaaProvincias.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ccaaProvincias.controladores.ControladorProvinciaMongoDB;
import ccaaProvincias.entities.Provincia;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosTabla[] = DatosDeTabla.getTitulosColumnas();

	private PanelGestionProvincia panelGP;
	
	/**
	 * Create the panel.
	 */
	public PanelTabla(PanelGestionProvincia panelGP) {
		setLayout(new BorderLayout(0, 0));
		
		this.panelGP = panelGP;
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		this.table = new JTable(dtm);
		// Limitamos el modo selección de filas a una única selección.
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				showSelectedRow();
			}
		});
		
		showFirstRow();
		
	}
	
	/**
	 * Seleccionamos el registro según el code del elemento (Provincia).
	 * @param code
	 */
	public void selectRowByCode(String code) {
		for (int i = 0; i < this.dtm.getRowCount(); i++) {
			String codeTable = (String) this.dtm.getValueAt(i, 0);
			if (codeTable.equalsIgnoreCase(code)) {
				this.table.setRowSelectionInterval(i, i);
				showSelectedRow();
			}
		}
	}
	
	/**
	 * 
	 */
	private void showFirstRow() {
		if (this.dtm.getRowCount() > 0) {
			this.table.setRowSelectionInterval(0, 0);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * 
	 */
	public void updateTable() {
		// Obtenemos los datos actualizados de la BBDD.
		this.datosTabla = DatosDeTabla.getDatosDeTabla();
		this.dtm.setDataVector(datosTabla, titulosTabla);
		// Se notifican los posibles cambios de las celdas de la tabla.
		this.dtm.fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	public void showSelectedRow() {
		try {
			int indexRow = table.getSelectedRow();
			List<Provincia> provincias = ControladorProvinciaMongoDB
					.getInstance().getAllProvincias();
			Provincia p = provincias.get(indexRow);
			this.panelGP.muestraEnPantalla(p);
		} catch (Exception e) {
			this.panelGP.muestraEnPantalla(null);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModel() {
		DefaultTableModel dtm = 
				new DefaultTableModel(datosTabla, titulosTabla) {
			/**
			 * La sobreescritura de este método nos permite controlar 
			 * qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return dtm;
	}

}
