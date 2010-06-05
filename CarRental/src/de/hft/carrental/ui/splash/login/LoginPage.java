package de.hft.carrental.ui.splash.login;

import de.hft.carrental.ui.WindowPage;
import de.hft.carrental.ui.splash.SplashWindow;

/**
 * This page is used by the {@link SplashWindow} to enable the user to login.
 * 
 * @author Alexander Weickmann
 */
public final class LoginPage extends WindowPage {

	private static final long serialVersionUID = -2590619285921957633L;

	/**
	 * @param splashWindow
	 *            The {@link SplashWindow} this page belongs to.
	 */
	public LoginPage(SplashWindow splashWindow) {
		super(splashWindow, 1, 1);
	}

	@Override
	protected void addSections() {
		addSection(new LoginSection(this));
	}

}
