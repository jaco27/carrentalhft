package de.hft.carrental.ui.main.bookings;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.WindowPage;

public final class BookingsPage extends WindowPage {

	private static final long serialVersionUID = 5392467214213264243L;

	public BookingsPage(Window window) {
		super(window, 1, 1);
	}

	@Override
	protected void addSections() {
		addSection(new BookingsTableSection(this));
	}

}
