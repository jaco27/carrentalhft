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

public class EditAddressDialog extends BaseAddressDialog {

	private static final long serialVersionUID = 1L;

	private JButton close = new JButton("Close");
	private JButton previous = new JButton("Previous");
	private JButton next = new JButton("Next");
	private JButton save = new JButton("Save");
	private JButton delete = new JButton("Delete");

	private List<CustomerAddress> addressList = new ArrayList<CustomerAddress>();
	private int pos = 0;

	private KeyListener cl = new ChangeListener();

	public EditAddressDialog(Set<CustomerAddress> addresses) {
		addressList.addAll(addresses);

		setTitle("Edit address details:");
		addButtons();
		addButtonActions();
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

	private void addButtonActions() {
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fillFields(++pos);
			}
		});

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fillFields(--pos);
			}
		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addressList.get(pos).setStreetName(streetField.getText());
				addressList.get(pos).setStreetNumber(numberField.getText());
				addressList.get(pos).setPostalCode(postalField.getText());
				addressList.get(pos).setCityName(cityField.getText());
				addressList.get(pos).setCountry(countryField.getText());
				addressList.get(pos).setPhoneNumber(phoneField.getText());

				save.setEnabled(false);
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addressList.remove(pos);
				setVisible(false);
			}
		});
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
				save.setEnabled(true);
			} else {
				save.setEnabled(false);
			}
		}
	}
}
