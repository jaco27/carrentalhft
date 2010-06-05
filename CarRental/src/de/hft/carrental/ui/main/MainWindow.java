package de.hft.carrental.ui.main;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.hft.carrental.domain.Customer;
import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.main.bookings.CurrentBookingsPage;
import de.hft.carrental.ui.main.cars.CarsPage;
import de.hft.carrental.ui.main.personal.PersonalPage;

/**
 * The main window is the application's window that appears after the login was
 * successful. It provides a menu at the top of the window which allows
 * navigating to the different use cases. In addition, it provides a huge area
 * of space below that menu, where the contents of the current window page are
 * displayed.
 * 
 * @author Alexander Weickmann
 */
public final class MainWindow extends Window implements ActionListener {

	private static final long serialVersionUID = -1064259514784128805L;

	private static final int MINIMUM_WIDTH = 800;

	private static final int MINIMUM_HEIGHT = 600;

	/** This action command triggers the 'Current Bookings' use case. */
	private static final String AC_CURRENT_BOOKINGS = "current_bookings";

	/** This action command triggers the 'Search Cars' use case. */
	private static final String AC_SEARCH_CARS = "search_cars";

	/** This action command triggers the 'Edit Personal Data' use case. */
	private static final String AC_EDIT_PERSONAL_DATA = "edit_personal_data";

	/** This action command triggers the logout. */
	private static final String AC_LOGOUT = "logout";

	private CurrentBookingsPage currentBookingsPage;

	private CarsPage searchCarsPage;

	private PersonalPage editPersonalDataPage;

	private Customer user;

	public MainWindow(Customer user) {
		super();

		this.user = user;

		currentBookingsPage = new CurrentBookingsPage(this);
		searchCarsPage = new CarsPage(this);
		editPersonalDataPage = new PersonalPage(this);

		createMenu();

		showCurrentBookingsPage();
		setVisible(true);
	}

	/**
	 * Creates the menu that is shown at the top of the window.
	 */
	private void createMenu() {
		JPanel menuPanel = new JPanel();

		JButton bookingsButton = new JButton("Current Bookings");
		bookingsButton.setActionCommand(AC_CURRENT_BOOKINGS);
		bookingsButton.addActionListener(this);
		menuPanel.add(bookingsButton);

		JButton carsButton = new JButton("Search Cars");
		carsButton.setActionCommand(AC_SEARCH_CARS);
		carsButton.addActionListener(this);
		menuPanel.add(carsButton);

		JButton personalButton = new JButton("Edit Personal Data");
		personalButton.setActionCommand(AC_EDIT_PERSONAL_DATA);
		personalButton.addActionListener(this);
		menuPanel.add(personalButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setActionCommand(AC_LOGOUT);
		logoutButton.addActionListener(this);
		menuPanel.add(logoutButton);

		add(menuPanel, createGridBagConstraints(0, 0, 1, 0,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
				GridBagConstraints.FIRST_LINE_START, 0, 0));
	}

	public void showCurrentBookingsPage() {
		switchPageTo(currentBookingsPage);
	}

	public void showSearchCarsPage() {
		switchPageTo(searchCarsPage);
	}

	public void showEditPersonalDataPage() {
		switchPageTo(editPersonalDataPage);
	}

	@Override
	protected int getMinHeight() {
		return MINIMUM_HEIGHT;
	}

	@Override
	protected int getMinWidth() {
		return MINIMUM_WIDTH;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(AC_CURRENT_BOOKINGS)) {
			showCurrentBookingsPage();
		} else if (command.equals(AC_SEARCH_CARS)) {
			showSearchCarsPage();
		} else if (command.equals(AC_EDIT_PERSONAL_DATA)) {
			showEditPersonalDataPage();
		} else if (command.equals(AC_LOGOUT)) {
			logout();
		}
	}

	/**
	 * Logs the current user out and shows the login screen yet again.
	 */
	private void logout() {
		// TODO MR: Should logout the user and show login screen instead.
		System.exit(0);
	}

}
