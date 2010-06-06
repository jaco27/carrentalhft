package de.hft.carrental.ui.main;

import de.hft.carrental.domain.Customer;
import de.hft.carrental.ui.WindowPage;

/**
 * A page belonging to the {@link MainWindow}. In addition to a normal window
 * page, this class provides a method to retrieve the currently logged in user.
 * 
 * @author Alexander Weickmann
 */
public abstract class MainWindowPage extends WindowPage {

	private static final long serialVersionUID = 2652629706275110110L;

	protected MainWindowPage(MainWindow mainWindow, int layoutRows,
			int layoutColumns) {
		super(mainWindow, layoutRows, layoutColumns);
	}

	protected final Customer getLoggedInUser() {
		return ((MainWindow) getWindow()).getLoggedInUser();
	}

}
