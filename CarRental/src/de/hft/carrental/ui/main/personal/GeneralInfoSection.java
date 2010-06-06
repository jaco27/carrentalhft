package de.hft.carrental.ui.main.personal;

import java.text.DateFormat;

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
	private JLabel surNameLabel = new JLabel("Surname:");
	private JLabel birthDateLabel = new JLabel("Date of birth:");
	private JLabel companyNameLabel = new JLabel("Company name: ");

	private JTextField loginField = new JTextField();
	private JTextField registerField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField firstNameField = new JTextField();
	private JTextField surNameField = new JTextField();
	private JTextField birthDateField = new JTextField();
	private JTextField companyNameField = new JTextField();

	private Customer user;

	protected GeneralInfoSection(MainWindowPage page) {
		super(page, "Personal details");
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", ""));
		user = getLoggedInUser();
		createContents();
	}

	private void createContents() {

		if (user.getCustomerType().equals(Customer.CUSTOMER_TYPE_PRIVATE)) {
			add(loginLabel);
			add(loginField);
			loginField.setEditable(false);
			add(firstNameLabel);
			add(firstNameField, "wrap");

			add(registerDateLabel);
			add(registerField);
			add(surNameLabel);
			add(surNameField, "wrap");

			add(emailLabel);
			add(emailField);
			add(birthDateLabel);
			add(birthDateField);
		} else {
			add(loginLabel);
			add(loginField);
			loginField.setEditable(false);

			add(registerDateLabel);
			add(registerField);
			registerField.setEditable(false);

			add(companyNameLabel);
			add(companyNameField);
		}

		refresh();
	}

	@Override
	protected void refresh() {
		loginField.setText(user.getLoginName());
		firstNameField.setText(user.getFirstName());
		surNameField.setText(user.getSurname());
		companyNameField.setText(user.getCompanyName());
		emailField.setText(user.getEmail());

		DateFormat df = DateFormat.getInstance();
		registerField.setText(df.format(user.getRegisterDate()));
		birthDateField.setText(df.format(user.getDateOfBirth()));
	}
}
