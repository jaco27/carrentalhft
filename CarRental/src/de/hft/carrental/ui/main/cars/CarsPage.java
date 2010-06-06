package de.hft.carrental.ui.main.cars;

import de.hft.carrental.ui.main.MainWindow;
import de.hft.carrental.ui.main.MainWindowPage;

// TODO RM, PS: Class yet to be implemented.
public final class CarsPage extends MainWindowPage {

	private static final long serialVersionUID = 8416397855771759503L;

	public CarsPage(MainWindow mainWindow) {
		super(mainWindow, 2, 1);
	}

	@Override
	protected void addSections() {
		addSection(new SearchCarsSection(this));
		addSection(new CarsTableSection(this));
	}

}
