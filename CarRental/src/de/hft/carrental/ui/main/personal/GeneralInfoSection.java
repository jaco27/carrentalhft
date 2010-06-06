package de.hft.carrental.ui.main.personal;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import de.hft.carrental.domain.Customer;
import de.hft.carrental.ui.main.MainWindowPage;
import de.hft.carrental.ui.main.MainWindowPageSection;

//TODO AW: Class yet to be implemented.
public final class GeneralInfoSection extends MainWindowPageSection {

	private static final long serialVersionUID = 2921841683848149881L;

	private JLabel loginLabel = new JLabel("Login name:");
	private JLabel registerDateLabel = new JLabel("Register date:");
	private JLabel emailLabel = new JLabel("Email:");
	private JLabel firstNameLabel = new JLabel("First name:");
	private JLabel lastNameLabel = new JLabel("Last name:");
	private JLabel surNameLabel = new JLabel("Surname:");
	private JLabel birthDateLabel = new JLabel("Date of birth:");
	private JLabel companyNameLabel = new JLabel("Company name: ");

	private JTextField loginField = new JTextField();
	private JTextField registerField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField firstNameField = new JTextField();
	private JTextField lastNameField = new JTextField();
	private JTextField surNameField = new JTextField();
	private JTextField birthDateField = new JTextField();
	private JTextField companyNameField = new JTextField();

	private Customer user;

	protected GeneralInfoSection(MainWindowPage page) {
		super(page, "Personal details");
		setLayout(new MigLayout());
		user = getLoggedInUser();
		createContents();
	}

	private void createContents() {
		add(loginLabel);
		add(loginField, "wrap");
		loginField.setEditable(false);

		add(registerDateLabel);
		add(registerField, "wrap");

		if (user.getCustomerAddresses().equals(Customer.CUSTOMER_TYPE_PRIVATE)) {
			add(firstNameLabel);
			add(firstNameField, "wrap");
			add(surNameLabel);
			add(surNameField, "wrap");
			add(lastNameLabel);
			add(lastNameField, "wrap");
			add(birthDateLabel);
			add(birthDateField, "wrap");
		} else {
			add(companyNameLabel);
			add(companyNameField, "wrap");
		}

		add(emailLabel);
		add(emailField, "wrap");

		refresh();
	}

	@Override
	protected void refresh() {
		loginField.setText(user.getLoginName());
		firstNameField.setText(user.getFirstName());
		surNameField.setText(user.getSurname());
		lastNameField.setText(user.getLoginName());
	}

}
