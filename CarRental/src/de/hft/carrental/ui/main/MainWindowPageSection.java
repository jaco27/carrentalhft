package de.hft.carrental.ui.main;

import de.hft.carrental.domain.Customer;
import de.hft.carrental.ui.WindowPageSection;

/**
 * A window page section that belongs to a {@link MainWindowPage}. In addition
 * to a normal page it offers a method that enables subclasses to retrieve the
 * currently logged in user.
 * 
 * @author Alexander Weickmann
 */
public abstract class MainWindowPageSection extends WindowPageSection {

	private static final long serialVersionUID = -1204182559964263048L;

	protected MainWindowPageSection(MainWindowPage mainWindowPage, String title) {
		super(mainWindowPage, title);
	}

	protected final Customer getLoggedInUser() {
		return ((MainWindowPage) getWindowPage()).getLoggedInUser();
	}

}
