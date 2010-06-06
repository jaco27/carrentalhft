package de.hft.carrental.ui.main.bookings;

import de.hft.carrental.ui.main.MainWindow;
import de.hft.carrental.ui.main.MainWindowPage;

/**
 * This page belongs to the {@link MainWindow} and enables the user to review
 * his current bookings.
 * 
 * @author Alexander Weickmann
 */
public final class CurrentBookingsPage extends MainWindowPage {

	private static final long serialVersionUID = 5392467214213264243L;

	public CurrentBookingsPage(MainWindow mainWindow) {
		super(mainWindow, 1, 1);
	}

	@Override
	protected void addSections() {
		addSection(new CurrentBookingsTableSection(this));
	}

}
