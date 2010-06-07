package de.hft.carrental.ui.main.personal;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import de.hft.carrental.domain.Customer;
import de.hft.carrental.domain.CustomerAddress;

public class AddAddressDialog extends BaseAddressDialog {

	private static final long serialVersionUID = 1L;

	private JButton add = new JButton("Add");
	private JButton close = new JButton("Close");

	private boolean addressAdded = false;

	private KeyListener cl = new ChangeListener();

	private Customer customer;

	public AddAddressDialog(Customer customer) {
		this.customer = customer;

		setTitle("Add new address:");
		addButtons();
		addButtonActions();
		addListeners();

		pack();
		int posX = Toolkit.getDefaultToolkit().getScreenSize().width / 2
				- getWidth() / 2;
		int posY = Toolkit.getDefaultToolkit().getScreenSize().height / 2
				- getHeight() / 2;
		setLocation(posX, posY);

		add.setEnabled(false);
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
		add(add, "align left");
		add(close, "align right");
	}

	private void addButtonActions() {
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addressAdded = true;
				setVisible(false);
			}
		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private void addListeners() {
		streetField.addKeyListener(cl);
		numberField.addKeyListener(cl);
		postalField.addKeyListener(cl);
		cityField.addKeyListener(cl);
		countryField.addKeyListener(cl);
		phoneField.addKeyListener(cl);
	}

	class ChangeListener implements KeyListener {

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
				add.setEnabled(true);
			} else {
				add.setEnabled(false);
			}
		}
	}
}
