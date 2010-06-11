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

import de.hft.carrental.domain.CustomerAddress;

public class EditAddressDialog extends BaseAddressDialog implements
		ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JButton close = new JButton("Close");

	private JButton previous = new JButton("Previous");

	private JButton next = new JButton("Next");

	private JButton save = new JButton("Save");

	private JButton delete = new JButton("Delete");

	private static final String AC_CLOSE_DIALOG = "close_dialog";

	private static final String AC_PREVIOUS_ADDRESS = "previous_address";

	private static final String AC_NEXT_ADDRESS = "next_address";

	private static final String AC_SAVE_CHANGES = "save_changes";

	private static final String AC_DELETE_ADDRESS = "delete_address";

	private List<CustomerAddress> addressList = new ArrayList<CustomerAddress>();

	private int pos = 0;

	public EditAddressDialog(Set<CustomerAddress> addresses) {
		addressList.addAll(addresses);

		setTitle("Edit address details:");
		addButtons();
		addListeners();
		fillFields(pos);

		if (addressList.size() == 1) {
			delete.setEnabled(false);
		}

		pack();
		int posX = Toolkit.getDefaultToolkit().getScreenSize().width / 2
				- getWidth() / 2;
		int posY = Toolkit.getDefaultToolkit().getScreenSize().height / 2
				- getHeight() / 2;
		setLocation(posX, posY);

		save.setEnabled(false);
		setVisible(true);
	}

	public Set<CustomerAddress> getAddresses() {
		Set<CustomerAddress> tmp = new HashSet<CustomerAddress>();
		tmp.addAll(addressList);
		return tmp;
	}

	private void addButtons() {
		add(previous, "split 2, align left");
		add(next);
		add(save, "split 3, align right");
		add(delete);
		add(close);
	}

	private void fillFields(int pos) {
		streetField.setText(addressList.get(pos).getStreetName());
		numberField.setText(addressList.get(pos).getStreetNumber());
		postalField.setText(addressList.get(pos).getPostalCode());
		cityField.setText(addressList.get(pos).getCityName());
		countryField.setText(addressList.get(pos).getCountry());
		phoneField.setText(addressList.get(pos).getPhoneNumber());

		checkPreviousNext();
	}

	private void checkPreviousNext() {
		if (pos - 1 < 0) {
			previous.setEnabled(false);
		} else {
			previous.setEnabled(true);
		}

		if (pos + 1 == addressList.size()) {
			next.setEnabled(false);
		} else {
			next.setEnabled(true);
		}
	}

	private void addListeners() {
		close.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);

		streetField.addKeyListener(this);
		numberField.addKeyListener(this);
		postalField.addKeyListener(this);
		cityField.addKeyListener(this);
		countryField.addKeyListener(this);
		phoneField.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals(AC_CLOSE_DIALOG)) {
			setVisible(false);
		} else if (actionCommand.equals(AC_DELETE_ADDRESS)) {
			addressList.remove(pos);
			setVisible(false);
		} else if (actionCommand.equals(AC_NEXT_ADDRESS)) {
			fillFields(++pos);
		} else if (actionCommand.equals(AC_PREVIOUS_ADDRESS)) {
			fillFields(--pos);
		} else if (actionCommand.equals(AC_SAVE_CHANGES)) {
			addressList.get(pos).setStreetName(streetField.getText());
			addressList.get(pos).setStreetNumber(numberField.getText());
			addressList.get(pos).setPostalCode(postalField.getText());
			addressList.get(pos).setCityName(cityField.getText());
			addressList.get(pos).setCountry(countryField.getText());
			addressList.get(pos).setPhoneNumber(phoneField.getText());

			save.setEnabled(false);
		}

	}

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
