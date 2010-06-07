package de.hft.carrental.ui.main.personal;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public abstract class BaseAddressDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JLabel streetLabel = new JLabel("Street:");
	private JLabel numberLabel = new JLabel("Street Number:");
	private JLabel postalLabel = new JLabel("Postal code:");
	private JLabel cityLabel = new JLabel("City:");
	private JLabel countryLabel = new JLabel("Country:");
	private JLabel phoneLabel = new JLabel("Phone number");

	protected JTextField streetField = new JTextField(45);
	protected JTextField numberField = new JTextField(5);
	protected JTextField postalField = new JTextField(10);
	protected JTextField cityField = new JTextField(45);
	protected JTextField countryField = new JTextField(45);
	protected JTextField phoneField = new JTextField(45);

	protected BaseAddressDialog() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		buildLayout();
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
	}

	protected boolean allFieldsFilled() {
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
}