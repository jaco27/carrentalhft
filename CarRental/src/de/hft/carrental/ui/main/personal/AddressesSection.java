package de.hft.carrental.ui.main.personal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
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
				AddAddressDialog ad = new AddAddressDialog(getLoggedInUser());

				if (ad.addressAdded()) {
					getLoggedInUser().getCustomerAddresses().add(
							ad.getNewCustomerAddress());
					refresh();
				}
			}
		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditAddressDialog ed = new EditAddressDialog(getLoggedInUser()
						.getCustomerAddresses());
				// getLoggedInUser().setCustomerAddresses(ed.getAddresses());
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
}
