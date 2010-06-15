package de.hft.carrental.ui.main.bookings;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.hft.carrental.database.SessionManager;
import de.hft.carrental.domain.Booking;
import de.hft.carrental.domain.BranchAddress;
import de.hft.carrental.ui.main.TableSection;
import de.hft.carrental.ui.util.GridBagUtil;

/**
 * This section belongs to the {@link CurrentBookingsPage}. It shows a table
 * with all the information relevant to the user's current bookings.
 * 
 * @author Alexander Weickmann
 */
public final class CurrentBookingsTableSection extends TableSection implements
		ActionListener {

	private static final long serialVersionUID = 6099129396844699288L;

	private static final String AC_CANCEL = "Cancel";

	private static final int[] COLUMN_WIDTHS = new int[] { 55, 65, 65, 80, 90,
			90, 160 };

	private static final String[] COLUMN_NAMES = new String[] { "Booking Nr.",
			"Booking Date", "Return Date", "Car Type", "Registration Number",
			"Agency", "Location" };

	private JTextField cancelField;

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

	@Override
	protected void beforeCreateTable() {
		JPanel cancelPanel = new JPanel();
		cancelPanel.setLayout(new FlowLayout());

		JLabel cancelLabel = new JLabel("Cancel Booking: ");
		cancelLabel.setFont(new Font("Arial", Font.BOLD, 11));
		cancelPanel.add(cancelLabel);

		cancelField = new JTextField(10);
		cancelField.setText("Booking Nr.");
		cancelField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				cancelField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (cancelField.getText().length() == 0) {
					cancelField.setText("Booking Nr.");
				}
			}
		});
		cancelField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Nothing to do.
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cancelBooking();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// Nothing to do.
			}
		});
		cancelPanel.add(cancelField);

		JButton cancelButton = new JButton("Cancel!");
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand(AC_CANCEL);
		cancelPanel.add(cancelButton);

		add(cancelPanel, GridBagUtil.createGridBagConstraints(0, 0, 1, 0,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
				GridBagConstraints.FIRST_LINE_START, 0, 0));
	}

	private void fillTableWithData() {
		Iterator<Booking> it = getLoggedInUser().getBookings().iterator();
		for (int i = 0; it.hasNext(); i++) {
			Object[] rowData = new Object[7];
			Booking booking = it.next();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(AC_CANCEL)) {
			cancelBooking();
		}
	}

	private void cancelBooking() {
		String nrToCancel = cancelField.getText();
		for (Character c : nrToCancel.toCharArray()) {
			if (!(Character.isDigit(c))) {
				return;
			}
		}
		Integer bookingNumber = Integer.valueOf(nrToCancel);
		Booking toDelete = null;
		Set<Booking> bookings = getLoggedInUser().getBookings();
		for (Booking booking : bookings) {
			if (booking.getBookingNumber().equals(bookingNumber)) {
				toDelete = booking;
				break;
			}
		}
		if (toDelete == null) {
			return;
		}
		bookings.remove(toDelete);
		Session session = SessionManager.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(toDelete);
		transaction.commit();
		refresh();
	}
}
