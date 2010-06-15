package de.hft.carrental.ui.main.personal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.hft.carrental.database.SessionManager;
import de.hft.carrental.domain.CustomerAddress;
import de.hft.carrental.ui.main.MainWindowPage;
import de.hft.carrental.ui.main.TableSection;

public final class AddressesSection extends TableSection implements
		ActionListener {

	private static final String AC_ADD_ADDRESS = "add_address";

	private static final String AC_EDIT_ADDRESS = "edit_address";

	private static final long serialVersionUID = -1627894704897348854L;

	private static final String[] COLUMN_NAMES = { "Street", "Number",
			"Postal code", "City", "Country", "Phone number"

	};

	private static final int[] COLUMN_WIDTHS = new int[] { 110, 100, 100, 130,
			140, 150 };

	private JButton add = new JButton("Add");

	private JButton edit = new JButton("Edit");

	protected AddressesSection(MainWindowPage page) {
		super(page, "Address(es)", COLUMN_NAMES, COLUMN_WIDTHS);

		add(add);
		add(edit);
		addListeners();
	}

	@Override
	protected void refresh() {
		clearTable();
		fillTable();
	}

	private void addListeners() {
		add.setActionCommand(AC_ADD_ADDRESS);
		add.addActionListener(this);
		edit.setActionCommand(AC_EDIT_ADDRESS);
		edit.addActionListener(this);
	}

	private void fillTable() {
		for (CustomerAddress address : getLoggedInUser().getCustomerAddresses()) {
			Object[] row = new Object[6];
			row[0] = address.getStreetName();
			row[1] = address.getStreetNumber();
			row[2] = address.getPostalCode();
			row[3] = address.getCityName();
			row[4] = address.getCountry();
			row[5] = address.getPhoneNumber();

			addDataRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals(AC_ADD_ADDRESS)) {
			AddAddressDialog ad = new AddAddressDialog(getLoggedInUser());

			if (ad.addressAdded()) {
				Session session = SessionManager.getInstance().openSession();
				Transaction transaction = session.beginTransaction();
				getLoggedInUser().getCustomerAddresses().add(
						ad.getNewCustomerAddress());
				session.save(getLoggedInUser());
				transaction.commit();
				refresh();
			}
		} else if (actionCommand.equals(AC_EDIT_ADDRESS)) {
			EditAddressDialog ed = new EditAddressDialog(getLoggedInUser()
					.getCustomerAddresses());

			if (ed.getAddresses().size() == getLoggedInUser()
					.getCustomerAddresses().size()) {
				getLoggedInUser().setCustomerAddresses(ed.getAddresses());
			} else {
				Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>(
						getLoggedInUser().getCustomerAddresses());
				customerAddresses.removeAll(ed.getAddresses());
				CustomerAddress[] array = customerAddresses
						.toArray(new CustomerAddress[1]);
				CustomerAddress address = array[0];
				getLoggedInUser().getCustomerAddresses().remove(address);
			}
			refresh();
		}
	}
}
