package de.hft.carrental.ui.splash;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.splash.login.LoginPage;
import de.hft.carrental.ui.splash.register.RegisterPage;

public final class SplashWindow extends Window {

	private static final long serialVersionUID = -5210789835246067684L;

	private LoginPage loginPage;

	private RegisterPage registerPage;

	public SplashWindow() {
		super();

		loginPage = new LoginPage();
		registerPage = new RegisterPage();

		showLoginPage();

		pack();
		setVisible(true);
	}

	public void showLoginPage() {
		switchPageTo(loginPage);
	}

	public void showRegisterPage() {
		switchPageTo(registerPage);
	}

}
