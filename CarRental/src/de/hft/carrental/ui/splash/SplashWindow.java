package de.hft.carrental.ui.splash;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.splash.login.LoginPage;

/**
 * The splash window is the application window that is shown right after the
 * program starts. Basically it allows the user to login.
 * 
 * @author Alexander Weickmann
 */
public final class SplashWindow extends Window {

	private static final long serialVersionUID = -5210789835246067684L;

	private static final int MINIMUM_WIDTH = 300;

	private static final int MINIMUM_HEIGHT = 100;

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
		return MINIMUM_HEIGHT;
	}

	@Override
	protected int getMinWidth() {
		return MINIMUM_WIDTH;
	}

}
