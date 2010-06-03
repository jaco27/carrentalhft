package de.hft.carrental.ui.splash;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.splash.login.LoginPage;

public final class SplashWindow extends Window {

	private static final long serialVersionUID = -5210789835246067684L;

	private LoginPage loginPage;

	public SplashWindow() {
		super();

		loginPage = new LoginPage();

		showLoginPage();

		pack();
		setVisible(true);
	}

	public void showLoginPage() {
		switchPageTo(loginPage);
	}

}
