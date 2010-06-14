package de.hft.carrental.ui.main.personal;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import de.hft.carrental.domain.Customer;
import de.hft.carrental.domain.CustomerAddress;

public class AddAddressDialog extends BaseAddressDialog implements KeyListener,
		ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton addButton = new JButton("Add");

	private JButton closeButton = new JButton("Close");

	private boolean addressAdded = false;

	private Customer customer;

	private static final String AC_ADD_ADDRESS = "add_address";

	private static final String AC_CLOSE_DIALOG = "close_dialog";

	public AddAddressDialog(Customer customer) {
		this.customer = customer;

		setTitle("Add new address:");

		addButtons();
		addListeners();

		pack();
		int posX = Toolkit.getDefaultToolkit().getScreenSize().width / 2
				- getWidth() / 2;
		int posY = Toolkit.getDefaultToolkit().getScreenSize().height / 2
				- getHeight() / 2;
		setLocation(posX, posY);

		addButton.setEnabled(false);
		setVisible(true);
	}

	public CustomerAddress getNewCustomerAddress() {
		CustomerAddress newAddress = new CustomerAddress();
		newAddress.setStreetName(streetField.getText());
		newAddress.setStreetNumber(numberField.getText());
		newAddress.setPostalCode(postalField.getText());
		newAddress.setCityName(cityField.getText());
		newAddress.setCountry(countryField.getText());
		newAddress.setPhoneNumber(phoneField.getText());
		newAddress.setCustomer(customer);

		return newAddress;
	}

	public boolean addressAdded() {
		return addressAdded;
	}

	private void addButtons() {
		add(addButton, "align left");
		add(closeButton, "align right");
	}

	private void addListeners() {
		addButton.setActionCommand(AC_ADD_ADDRESS);
		addButton.addActionListener(this);
		closeButton.setActionCommand(AC_CLOSE_DIALOG);
		closeButton.addActionListener(this);

		streetField.addKeyListener(this);
		numberField.addKeyListener(this);
		postalField.addKeyListener(this);
		cityField.addKeyListener(this);
		countryField.addKeyListener(this);
		phoneField.addKeyListener(this);
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
			addButton.setEnabled(true);
		} else {
			addButton.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals(AC_ADD_ADDRESS)) {
			addressAdded = true;
			setVisible(false);
		} else if (actionCommand.equals(AC_CLOSE_DIALOG)) {
			setVisible(false);
		}
	}
}
