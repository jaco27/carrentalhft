package de.hft.carrental.ui;

import java.awt.Container;
import java.awt.GridLayout;

/**
 * Window pages are used by the class {@link Window}. One window page bundles
 * together a number of {@link WindowPageSection}s. For example, there could
 * exist a window page with two window page sections. One section shows a search
 * formula, while the second section shows a table with the search results.
 * 
 * @see Window
 * 
 * @author Alexander Weickmann
 */
public abstract class WindowPage extends Container {

	private static final long serialVersionUID = -7371192976582192750L;

	/** The {@link Window} this window page belongs to. */
	private final Window window;

	/**
	 * @param window
	 *            The {@link Window} this window page will belong to.
	 * @param layoutRows
	 *            Specifies the number of how many rows the page's grid layout
	 *            consists of.
	 * @param layoutColumns
	 *            Specifies the number of how many columns the page's grid
	 *            layout consists of.
	 */
	protected WindowPage(Window window, int layoutRows, int layoutColumns) {
		super();

		this.window = window;

		createLayout(layoutRows, layoutColumns);
		addSections();
	}

	private void createLayout(int rows, int columns) {
		GridLayout layout = new GridLayout(rows, columns);
		setLayout(layout);
	}

	/**
	 * Responsible for adding the necessary {@link WindowPageSection}s to this
	 * page.
	 */
	protected abstract void addSections();

	/**
	 * Adds the given {@link WindowPageSection} to this window page.
	 * 
	 * @param section
	 *            The window page section to add.
	 */
	protected final void addSection(WindowPageSection section) {
		add(section);
	}

	/**
	 * Returns the {@link Window} this window page belongs to.
	 */
	public final Window getWindow() {
		return window;
	}

}
