package de.hft.carrental.ui.main.personal;

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

	protected AddressesSection(MainWindowPage page) {
		super(page, "Address(es)", COLUMN_NAMES, COLUMN_WIDTHS);
	}

	@Override
	protected void refresh() {
		clearTable();
		fillTable();
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
