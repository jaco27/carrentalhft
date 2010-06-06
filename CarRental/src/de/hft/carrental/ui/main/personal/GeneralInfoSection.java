package de.hft.carrental.ui.main.personal;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
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
	private JTextField flastNameField = new JTextField();
	private JTextField surNameField = new JTextField();
	private JTextField birthDateField = new JTextField();
	private JTextField companyNameField = new JTextField();

	protected GeneralInfoSection(MainWindowPage page) {
		super(page, "Personal details");
		setLayout(new MigLayout());
		createContents();
	}

	private void createContents() {
		add(loginLabel);
		add(loginField, "wrap");
	}

	@Override
	protected void refresh() {
		// TODO AW: Method yet to be implemented
	}

}
