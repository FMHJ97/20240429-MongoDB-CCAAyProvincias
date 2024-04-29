package ccaaProvincias.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelGestionProvincia extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;

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
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 1;
		add(lblCdigo, gbc_lblCdigo);
		
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
		
		JComboBox jcbCCAA = new JComboBox();
		jcbCCAA.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_jcbCCAA = new GridBagConstraints();
		gbc_jcbCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCCAA.gridx = 1;
		gbc_jcbCCAA.gridy = 3;
		add(jcbCCAA, gbc_jcbCCAA);
		
		JButton btnVerCCAA = new JButton("Ver CCAA");
		btnVerCCAA.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnVerCCAA = new GridBagConstraints();
		gbc_btnVerCCAA.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerCCAA.gridx = 2;
		gbc_btnVerCCAA.gridy = 3;
		add(btnVerCCAA, gbc_btnVerCCAA);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(20, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 4;
		add(btnGuardar, gbc_btnGuardar);

	}

}
