package de.hft.carrental.ui.splash.login;

import de.hft.carrental.ui.WindowPage;

public final class LoginPage extends WindowPage {

	public LoginPage() {
		super(1, 1);
	}

	private static final long serialVersionUID = -2590619285921957633L;

	@Override
	protected void addSections() {
		addSection(new LoginSection());
	}

}
