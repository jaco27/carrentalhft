package de.hft.carrental.ui.main.personal;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				AddressDialog ad = new AddressDialog(getLoggedInUser()
						.getCustomerAddresses());
				ad.setVisible(true);
				saveChanges(ad.getData());
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

	private void saveChanges(Set<CustomerAddress> addresses) {
		getLoggedInUser().setCustomerAddresses(addresses);
		refresh();
	}
}

class AddressDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public static final int HINT_RUD = 0;
	public static final int HINT_CREATE = 1;

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
	private JButton delete = new JButton("Delete");
	private JButton create = new JButton("Create");

	private List<CustomerAddress> data = new ArrayList<CustomerAddress>();
	private int addressCount;
	private int pos = 0;

	private KeyListener cl = new ChangeListenerOld();

	public AddressDialog(Set<CustomerAddress> data) {
		super();

		this.data.addAll(data);
		addressCount = data.size();

		fillFields(pos);

		setModalityType(ModalityType.APPLICATION_MODAL);

		buildLayout();
		addButtonActions();
		addListeners();

		pack();
		int posX = Toolkit.getDefaultToolkit().getScreenSize().width / 2
				- getWidth() / 2;
		int posY = Toolkit.getDefaultToolkit().getScreenSize().height / 2
				- getHeight() / 2;
		setLocation(posX, posY);

		save.setEnabled(false);
	}

	public Set<CustomerAddress> getData() {
		Set<CustomerAddress> tmp = new HashSet<CustomerAddress>();
		tmp.addAll(data);
		return tmp;
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

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				data.get(pos).setStreetName(streetField.getText());
				data.get(pos).setStreetNumber(numberField.getText());
				data.get(pos).setPostalCode(postalField.getText());
				data.get(pos).setCityName(cityField.getText());
				data.get(pos).setCountry(countryField.getText());
				data.get(pos).setPhoneNumber(phoneField.getText());

				save.setEnabled(false);
			}
		});
	}

	private void checkPreviousNext() {
		if (pos + 1 == addressCount) {
			next.setEnabled(false);
		} else {
			next.setEnabled(true);
		}

		if (pos - 1 < 0) {
			previous.setEnabled(false);
		} else {
			previous.setEnabled(true);
		}
	}

	private void fillFields(int pos) {
		streetField.setText(data.get(pos).getStreetName());
		numberField.setText(data.get(pos).getStreetNumber());
		postalField.setText(data.get(pos).getPostalCode());
		cityField.setText(data.get(pos).getCityName());
		countryField.setText(data.get(pos).getCountry());
		phoneField.setText(data.get(pos).getPhoneNumber());

		checkPreviousNext();
	}

	private void addListeners() {
		streetField.addKeyListener(cl);
		numberField.addKeyListener(cl);
		postalField.addKeyListener(cl);
		cityField.addKeyListener(cl);
		countryField.addKeyListener(cl);
		phoneField.addKeyListener(cl);
	}

	private boolean allFieldsFilled() {
		if ((streetField.getText().length() == 0)
				|| (numberField.getText().length() == 0)
				|| (postalField.getText().length() == 0)
				|| (cityField.getText().length() == 0)
				|| (countryField.getText().length() == 0)
				|| (phoneField.getText().length() == 0)) {
			return false;
		}

		return true;
	}

	class ChangeListenerOld implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			/* nothing to do */
		}

		@Override
		public void keyReleased(KeyEvent e) {
			/* nothing to do */
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if (allFieldsFilled()) {
				save.setEnabled(true);
			} else {
				save.setEnabled(false);
			}
		}
	}
}