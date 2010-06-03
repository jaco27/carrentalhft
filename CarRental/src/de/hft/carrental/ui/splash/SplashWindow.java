package de.hft.carrental.ui.splash;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.splash.login.LoginPage;

public final class SplashWindow extends Window {

	private static final long serialVersionUID = -5210789835246067684L;

	private LoginPage loginPage;

	public SplashWindow() {
		super();

		loginPage = new LoginPage(this);

		showLoginPage();
		setVisible(true);
	}

	public void showLoginPage() {
		switchPageTo(loginPage);
	}

	@Override
	protected int getMinHeight() {
		return 100;
	}

	@Override
	protected int getMinWidth() {
		return 300;
	}

}
