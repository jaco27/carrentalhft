package de.hft.carrental.ui.splash.register;

import de.hft.carrental.ui.WindowPage;

public final class RegisterPage extends WindowPage {

	public RegisterPage() {
		super(1, 1);
	}

	private static final long serialVersionUID = 2317242989423848379L;

	@Override
	protected void addSections() {
		addSection(new RegisterSection());
	}

}
