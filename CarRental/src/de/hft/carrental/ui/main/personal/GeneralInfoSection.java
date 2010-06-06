package de.hft.carrental.ui.main.personal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JButton;
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

	private JButton saveChangesButton = new JButton("Save changes");

	private Customer user;

	protected GeneralInfoSection(MainWindowPage page) {
		super(page, "Personal details");
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", ""));
		user = getLoggedInUser();

		if (user.getCustomerType().equals(Customer.CUSTOMER_TYPE_PRIVATE)) {
			createPrivateUserContents();
		} else {
			createCompanyUserContents();
		}

		refresh();

		saveChangesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveChanges();
			}
		});
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

	private void saveChanges() {
		user.setEmail(emailField.getText());
	}

	private void createPrivateUserContents() {
		add(loginLabel);
		add(loginField, "growx");
		loginField.setEditable(false);
		add(firstNameLabel);
		add(firstNameField, "growx, wrap");
		firstNameField.setEditable(false);

		add(registerDateLabel);
		add(registerField, "growx");
		registerField.setEditable(false);
		add(surNameLabel);
		add(surNameField, "growx, wrap");
		surNameField.setEditable(false);

		add(emailLabel);
		add(emailField, "growx");
		add(birthDateLabel);
		add(birthDateField, "growx, wrap");
		birthDateField.setEditable(false);

		add(saveChangesButton, "span 4, align right");
	}

	private void createCompanyUserContents() {
		add(loginLabel, "span 1 3, growx");
		add(loginField);
		loginField.setEditable(false);

		add(registerDateLabel);
		add(registerField, "growx");
		registerField.setEditable(false);

		add(emailLabel);
		add(emailField, "growx, wrap");

		add(companyNameLabel);
		add(companyNameField, "growx");
		companyNameField.setEditable(false);
	}
}
