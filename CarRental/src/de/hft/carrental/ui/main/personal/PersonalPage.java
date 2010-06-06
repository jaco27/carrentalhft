package de.hft.carrental.ui.main.personal;

import de.hft.carrental.ui.main.MainWindow;
import de.hft.carrental.ui.main.MainWindowPage;

//TODO AW: Class yet to be implemented.
public final class PersonalPage extends MainWindowPage {

	private static final long serialVersionUID = -5215876430603142614L;

	public PersonalPage(MainWindow mainWindow) {
		super(mainWindow, 2, 1);
	}

	@Override
	protected void addSections() {
		addSection(new GeneralInfoSection(this));
		addSection(new AddressesSection(this));
	}

}
