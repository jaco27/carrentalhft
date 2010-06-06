package de.hft.carrental.ui.main.bookings;

import java.util.Date;

import de.hft.carrental.domain.Booking;
import de.hft.carrental.domain.BranchAddress;
import de.hft.carrental.ui.main.TableSection;

/**
 * This section belongs to the {@link CurrentBookingsPage}. It shows a table
 * with all the information relevant to the user's current bookings.
 * 
 * @author Alexander Weickmann
 */
public final class CurrentBookingsTableSection extends TableSection {

	private static final long serialVersionUID = 6099129396844699288L;

	private static final int[] COLUMN_WIDTHS = new int[] { 55, 65, 65, 80, 90,
			90, 160 };

	private static final String[] COLUMN_NAMES = new String[] { "Booking Nr.",
			"Booking Date", "Return Date", "Car Type", "Registration Number",
			"Agency", "Location" };

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
		fillTableWithData();
	}

	private void fillTableWithData() {
		for (Booking booking : getLoggedInUser().getBookings()) {
			Object[] rowData = new Object[7];
			rowData[0] = booking.getBookingNumber();

			Date bookingDate = booking.getBookingDate();
			String bookingDateString = bookingDate.toString();
			rowData[1] = bookingDateString.substring(0, bookingDateString
					.indexOf(" "));

			Date returnDate = booking.getReturnDate();
			String returnDateString = returnDate.toString();
			rowData[2] = returnDateString.substring(0, returnDateString
					.indexOf(" "));
			rowData[3] = booking.getCar().getCarType().getName();
			rowData[4] = booking.getCar().getRegistrationNumber();
			rowData[5] = booking.getAgency().getName();

			BranchAddress branchAddress = booking.getCar().getBranch()
					.getBranchAddress();
			rowData[6] = branchAddress.getPostalCode() + " "
					+ branchAddress.getCityName() + ", "
					+ branchAddress.getStreetName() + " "
					+ branchAddress.getStreetNumber();

			addDataRow(rowData);
		}
	}

}
