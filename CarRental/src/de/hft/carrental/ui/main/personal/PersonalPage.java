package de.hft.carrental.ui.main.personal;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.WindowPage;

//TODO AW: Class yet to be implemented.
public final class PersonalPage extends WindowPage {

	private static final long serialVersionUID = -5215876430603142614L;

	public PersonalPage(Window window) {
		super(window, 2, 1);
	}

	@Override
	protected void addSections() {
		addSection(new GeneralInfoSection(this));
		addSection(new AddressesSection(this));
	}

}
