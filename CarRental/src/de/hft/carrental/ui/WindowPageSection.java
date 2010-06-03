package de.hft.carrental.ui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public abstract class WindowPageSection extends JPanel {

	private static final long serialVersionUID = 7237705902963031893L;

	private final WindowPage windowPage;

	protected WindowPageSection(WindowPage windowPage, String title) {
		this.windowPage = windowPage;
		createBorder(title);
	}

	protected void createBorder(String title) {
		TitledBorder border = BorderFactory.createTitledBorder(title + ":");
		setBorder(border);
	}

	public final WindowPage getWindowPage() {
		return windowPage;
	}

}
