package de.hft.carrental.ui.main.bookings;

import de.hft.carrental.ui.WindowPage;
import de.hft.carrental.ui.main.TableSection;

public final class BookingsTableSection extends TableSection {

	private static final long serialVersionUID = 6099129396844699288L;

	private static final int[] COLUMN_WIDTHS = new int[] { 110, 100, 100, 130,
			140, 180 };

	private static final String[] COLUMN_NAMES = new String[] {
			"Booking Number", "Booking Date", "Return Date",
			"Registration Number", "Car Type", "Agency" };

	protected BookingsTableSection(WindowPage page) {
		super(page, "Current bookings", COLUMN_NAMES, COLUMN_WIDTHS);
	}

	@Override
	protected void refresh() {
		clearTable();

	}

}
