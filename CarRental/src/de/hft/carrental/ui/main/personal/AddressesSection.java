package de.hft.carrental.ui.main.personal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;

import de.hft.carrental.domain.CustomerAddress;
import de.hft.carrental.ui.main.MainWindowPage;
import de.hft.carrental.ui.main.TableSection;

// TODO AW: Class yet to be implemented.
public final class AddressesSection extends TableSection {

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
		addButtonActions();
	}

	@Override
	protected void refresh() {
		clearTable();
		fillTable();
	}

	private void addButtonActions() {
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddAddressDialog ad = new AddAddressDialog();

				if (ad.addressAdded()) {
					CustomerAddress newAddress = ad.getNewCustomerAddress();
					newAddress.setCustomer(getLoggedInUser());

					Set<CustomerAddress> addresses = getLoggedInUser()
							.getCustomerAddresses();
					addresses.add(newAddress);
					saveChanges(addresses);
				}
			}
		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditAddressDialog ad = new EditAddressDialog(getLoggedInUser()
						.getCustomerAddresses());
				saveChanges(ad.getData());
			}
		});
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

	private void saveChanges(Set<CustomerAddress> addresses) {
		getLoggedInUser().setCustomerAddresses(addresses);
		refresh();
	}
}
