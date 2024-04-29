package ccaaProvincias.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCCAA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;

	/**
	 * Create the panel.
	 */
	public PanelCCAA() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Comunidades Autónomas");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(20, 0, 20, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Dialog", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
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
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(15, 0, 0, 75);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		add(btnGuardar, gbc_btnGuardar);

	}

}
