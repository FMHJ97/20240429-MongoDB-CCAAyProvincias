package ccaaProvincias.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import ccaaProvincias.controladores.ControladorCCAAMongoDB;
import ccaaProvincias.controladores.ControladorProvinciaMongoDB;
import ccaaProvincias.entities.CCAA;
import ccaaProvincias.entities.Provincia;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class PanelGestionProvincia extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;
	JComboBox<CCAA> jcbCCAA;
	private PanelTabla panelTabla;
	
	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}

	/**
	 * Create the panel.
	 */
	public PanelGestionProvincia() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeProvincia = new JLabel("Gestión de Provincia");
		lblGestinDeProvincia.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblGestinDeProvincia = new GridBagConstraints();
		gbc_lblGestinDeProvincia.insets = new Insets(20, 0, 20, 0);
		gbc_lblGestinDeProvincia.gridwidth = 3;
		gbc_lblGestinDeProvincia.gridx = 0;
		gbc_lblGestinDeProvincia.gridy = 0;
		add(lblGestinDeProvincia, gbc_lblGestinDeProvincia);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 1;
		add(lblCode, gbc_lblCode);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setEnabled(false);
		jtfCodigo.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 1;
		add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 2;
		add(lblDescripcin, gbc_lblDescripcin);
		
		jtfDescripcion = new JTextField();
		jtfDescripcion.setFont(new Font("Dialog", Font.PLAIN, 15));
		jtfDescripcion.setColumns(10);
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		add(jtfDescripcion, gbc_jtfDescripcion);
		
		JLabel lblCcaa = new JLabel("CCAA:");
		lblCcaa.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblCcaa = new GridBagConstraints();
		gbc_lblCcaa.anchor = GridBagConstraints.EAST;
		gbc_lblCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCcaa.gridx = 0;
		gbc_lblCcaa.gridy = 3;
		add(lblCcaa, gbc_lblCcaa);
		
		jcbCCAA = new JComboBox<CCAA>();
		jcbCCAA.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_jcbCCAA = new GridBagConstraints();
		gbc_jcbCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCCAA.gridx = 1;
		gbc_jcbCCAA.gridy = 3;
		add(jcbCCAA, gbc_jcbCCAA);
		
		JButton btnVerCCAA = new JButton("Ver CCAA");
		btnVerCCAA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showJDialog();
			}
		});
		btnVerCCAA.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnVerCCAA = new GridBagConstraints();
		gbc_btnVerCCAA.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerCCAA.gridx = 2;
		gbc_btnVerCCAA.gridy = 3;
		add(btnVerCCAA, gbc_btnVerCCAA);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, 
							"No se ha realizado la actualización");
					ex.printStackTrace();
				}
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(20, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 4;
		add(btnGuardar, gbc_btnGuardar);

		loadAllCCAA();
		
	}
	
	/**
	 * 
	 */
	private void showJDialog() {
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		dialogo.setTitle("Gestión de usuario");
		dialogo.setContentPane(new PanelCCAA(this, panelTabla));
		dialogo.pack();
		dialogo.setModal(true);
		dialogo.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		dialogo.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void guardar() {
		Provincia p = new Provincia();
		
		// Guardamos todos los datos de Provincia del panel.
		p.setCode(this.jtfCodigo.getText());
		
		if (!this.jtfDescripcion.getText().isEmpty()) {
			p.setLabel(this.jtfDescripcion.getText());
		}else {
			JOptionPane.showMessageDialog(null,
					"La descripción no puede estar vacía");;
			return;
		}
		
		p.setParent_code(((CCAA)this.jcbCCAA.getSelectedItem()).getCode());
		
		// Guardamos los datos nuevos.
		ControladorProvinciaMongoDB.getInstance()
			.updateProvincia(p);
		
		// Actualizamos los datos de la tabla.
		// A continuación, seleccionamos en la tabla dicho registro.
		this.panelTabla.updateTable();
		this.panelTabla.selectRowByCode(this.jtfCodigo.getText());
		
		JOptionPane.showMessageDialog(null, 
				"Se ha actualizado la provincia con éxito");
	}
	
	/**
	 * 
	 * @param p
	 */
	public void muestraEnPantalla(Provincia p) {
		if (p != null) {
			this.jtfCodigo.setText(p.getCode());
			
			if (p.getLabel() != null) {
				this.jtfDescripcion.setText(p.getLabel());
			} else {
				this.jtfDescripcion.setText("");
			}
			
			for (int i = 0; i < this.jcbCCAA.getItemCount(); i++) {
				if (this.jcbCCAA.getItemAt(i).getCode()
						.equals(p.getParent_code())) {
					this.jcbCCAA.setSelectedIndex(i);
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public void loadAllCCAA() {
		this.jcbCCAA.removeAllItems();
		
		List<CCAA> ccaaList = ControladorCCAAMongoDB
				.getInstance().getAllCCAA();
		for (CCAA ccaa : ccaaList) {
			this.jcbCCAA.addItem(ccaa);
		}
	}

	public JTextField getJtfCodigo() {
		return jtfCodigo;
	}

	public void setJtfCodigo(JTextField jtfCodigo) {
		this.jtfCodigo = jtfCodigo;
	}

}
