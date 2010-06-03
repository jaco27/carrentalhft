package de.hft.carrental.ui.main.cars;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.WindowPage;

public final class CarsPage extends WindowPage {

	private static final long serialVersionUID = 8416397855771759503L;

	public CarsPage(Window window) {
		super(window, 1, 2);
	}

	@Override
	protected void addSections() {
		addSection(new SearchCarsSection(this));
		addSection(new CarsTableSection(this));
	}

}
