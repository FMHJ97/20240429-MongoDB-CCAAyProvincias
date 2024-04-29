package ccaaProvincias.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		

	}

}
