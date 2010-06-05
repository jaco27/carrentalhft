package de.hft.carrental.ui.main.bookings;

import de.hft.carrental.ui.main.TableSection;

/**
 * This section belongs to the {@link CurrentBookingsPage}. It shows a table
 * with all the information relevant to the user's current bookings.
 * 
 * @author Alexander Weickmann
 */
public final class CurrentBookingsTableSection extends TableSection {

	private static final long serialVersionUID = 6099129396844699288L;

	private static final int[] COLUMN_WIDTHS = new int[] { 110, 100, 100, 130,
			140, 150, 170 };

	private static final String[] COLUMN_NAMES = new String[] {
			"Booking Number", "Booking Date", "Return Date", "Car Type",
			"Registration Number", "Agency", "Location" };

	/**
	 * @param currentBookingsPage
	 *            The {@link CurrentBookingsPage} this section belongs to.
	 */
	protected CurrentBookingsTableSection(
			CurrentBookingsPage currentBookingsPage) {

		super(currentBookingsPage, "Current Bookings", COLUMN_NAMES,
				COLUMN_WIDTHS);
	}

	@Override
	protected void refresh() {
		clearTable();
		// TODO AW: Obtain data from database as necessary.
	}

}
