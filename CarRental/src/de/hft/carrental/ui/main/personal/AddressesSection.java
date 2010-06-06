package de.hft.carrental.ui.main.personal;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
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

		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddressDialog().setVisible(true);
			}
		});
		add(edit);
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

	private void saveChanges() {
		// TODO implement
	}
}

class AddressDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final Object[] content = new Object[6];

	private JLabel streetLabel = new JLabel("Street:");
	private JLabel numberLabel = new JLabel("Street Number:");
	private JLabel postalLabel = new JLabel("Postal code:");
	private JLabel cityLabel = new JLabel("City:");
	private JLabel countryLabel = new JLabel("Country:");
	private JLabel phoneLabel = new JLabel("Phone number");

	private JTextField streetField = new JTextField(45);
	private JTextField numberField = new JTextField(5);
	private JTextField postalField = new JTextField(10);
	private JTextField cityField = new JTextField(45);
	private JTextField countryField = new JTextField(45);
	private JTextField phoneField = new JTextField(45);

	private JButton cancel = new JButton("Cancel");
	private JButton previous = new JButton("Previous");
	private JButton next = new JButton("Next");
	private JButton save = new JButton("Save");

	public AddressDialog() {
		super();

		setModalityType(ModalityType.APPLICATION_MODAL);

		buildLayout();
		addButtonActions();

		pack();
		int posX = Toolkit.getDefaultToolkit().getScreenSize().width / 2
				- getWidth() / 2;
		int posY = Toolkit.getDefaultToolkit().getScreenSize().height / 2
				- getHeight() / 2;
		setLocation(posX, posY);
	}

	private void buildLayout() {
		setLayout(new MigLayout("", "[][grow]"));

		add(streetLabel);
		add(streetField, "growx, wrap");

		add(numberLabel);
		add(numberField, "growx, wrap");

		add(postalLabel);
		add(postalField, "growx, wrap");

		add(cityLabel);
		add(cityField, "growx, wrap");

		add(countryLabel);
		add(countryField, "growx, wrap");

		add(phoneLabel);
		add(phoneField, "growx, wrap");

		add(previous, "split 2, align left");
		add(next);
		add(save, "split 2, align right");
		add(cancel);

	}

	private void addButtonActions() {
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}