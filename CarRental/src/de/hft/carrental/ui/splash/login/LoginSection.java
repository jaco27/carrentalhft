package de.hft.carrental.ui.splash.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import de.hft.carrental.ui.WindowPageSection;
import de.hft.carrental.ui.main.MainWindow;

/**
 * This section contains a text field allowing the user to type in his login
 * name. It also shows a button that allows the user to eventually perform the
 * login.
 * 
 * @author Alexander Weickmann
 */
public final class LoginSection extends WindowPageSection implements
		ActionListener {

	private static final long serialVersionUID = 1064521119735654437L;

	private static final String TITLE = "Login";

	/** Action command that is triggered upon activation of the login button. */
	private static final String AC_LOGIN = "login";

	/**
	 * @param loginPage
	 *            The {@link LoginPage} this section belongs to.
	 */
	public LoginSection(LoginPage loginPage) {
		super(loginPage, TITLE);
		createContents();
	}

	private void createContents() {
		JTextField loginTextField = new JTextField(15);
		loginTextField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Nothing to do.
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					performLogin();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// Nothing to do.
			}
		});
		add(loginTextField);

		JButton loginButton = new JButton("Login!");
		loginButton.setActionCommand(AC_LOGIN);
		loginButton.addActionListener(this);
		add(loginButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(AC_LOGIN)) {
			boolean loginSuccess = performLogin();
			if (loginSuccess) {
				getWindowPage().getWindow().setVisible(false);
				new MainWindow();
			} else {
				// TODO AW: Display error message somewhere.
			}
		}
	}

	/**
	 * Performs the login. Returns <tt>true</tt> if the user is valid,
	 * <tt>false</tt> otherwise.
	 */
	private boolean performLogin() {
		// TODO MR: Finish login.
		return true;
	}

	@Override
	protected void refresh() {
		// Nothing to do.
	}

}
