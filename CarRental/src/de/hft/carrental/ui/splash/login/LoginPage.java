package de.hft.carrental.ui.splash.login;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.WindowPage;

public final class LoginPage extends WindowPage {

	private static final long serialVersionUID = -2590619285921957633L;

	public LoginPage(Window window) {
		super(window, 1, 1);
	}

	@Override
	protected void addSections() {
		addSection(new LoginSection(this));
	}

}
