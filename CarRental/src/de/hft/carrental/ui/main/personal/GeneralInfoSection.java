package de.hft.carrental.ui.main.personal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;

import javax.swing.ImageIcon;
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

	private final JLabel loginLabel = new JLabel("Login name:");
	private final JLabel registerDateLabel = new JLabel("Register date:");
	private final JLabel emailLabel = new JLabel("Email:");
	private final JLabel firstNameLabel = new JLabel("First name:");
	private final JLabel surNameLabel = new JLabel("Surname:");
	private final JLabel birthDateLabel = new JLabel("Date of birth:");
	private final JLabel companyNameLabel = new JLabel("Company name: ");

	private final JTextField loginField = new JTextField();
	private final JTextField registerField = new JTextField();
	private final JTextField emailField = new JTextField();
	private final JTextField firstNameField = new JTextField();
	private final JTextField surNameField = new JTextField();
	private final JTextField birthDateField = new JTextField();
	private final JTextField companyNameField = new JTextField();

	private final JButton saveChangesButton = new JButton("Save changes");

	private final KeyListener kl = new FieldEditedListener();

	private final Customer user;

	protected GeneralInfoSection(MainWindowPage page) {
		super(page, "Personal details");
		setLayout(new MigLayout("", "[][grow][][grow]", ""));
		user = getLoggedInUser();

		if (user.getCustomerType().equals(Customer.CUSTOMER_TYPE_PRIVATE)) {
			createPrivateUserContents();
		} else {
			createCompanyUserContents();
		}

		addListeners();

		Image image = new ImageIcon("images/save.png").getImage();
		image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		saveChangesButton.setIcon(new ImageIcon(image));
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

		saveChangesButton.setEnabled(false);
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

	private void addListeners() {
		emailField.addKeyListener(kl);

		saveChangesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveChanges();
				saveChangesButton.setEnabled(false);
			}
		});
	}

	class FieldEditedListener implements KeyListener {

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
			saveChangesButton.setEnabled(true);
		}

	}
}
