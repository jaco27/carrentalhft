package de.hft.carrental.ui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * This class is like a {@link JPanel}. In addition, it has a title and a
 * border. The title is displayed at the top left of the border. A window page
 * section always belongs to a specific {@link WindowPage}. The contents of the
 * section can be refreshed using the method {@link #refresh()}.
 * 
 * @author Alexander Weickmann
 */
public abstract class WindowPageSection extends JPanel {

	private static final long serialVersionUID = 7237705902963031893L;

	/**
	 * The {@link WindowPage} this window page section belongs to.
	 */
	private final WindowPage windowPage;

	/**
	 * @param windowPage
	 *            The {@link WindowPage} this window page sections belongs to.
	 * @param title
	 *            The title of this window page section that will be displayed
	 *            at the top left of the section's border.
	 */
	protected WindowPageSection(WindowPage windowPage, String title) {
		this.windowPage = windowPage;
		createBorder(title);
	}

	private void createBorder(String title) {
		TitledBorder border = BorderFactory.createTitledBorder(title + ":");
		border.setTitleFont(new Font("Arial", Font.BOLD, 11));
		setBorder(border);
	}

	/**
	 * Returns the {@link WindowPage} this window page section belongs to.
	 */
	public final WindowPage getWindowPage() {
		return windowPage;
	}

	/**
	 * Refreshes the contents of this window page section.
	 */
	protected abstract void refresh();

}
