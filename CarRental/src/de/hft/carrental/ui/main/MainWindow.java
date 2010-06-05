package de.hft.carrental.ui.main;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.main.bookings.BookingsPage;
import de.hft.carrental.ui.main.cars.CarsPage;
import de.hft.carrental.ui.main.personal.PersonalPage;

public final class MainWindow extends Window implements ActionListener {

	private static final long serialVersionUID = -1064259514784128805L;

	private static final String AC_CURRENT_BOOKINGS = "current_bookings";

	private static final String AC_SEARCH_CARS = "search_cars";

	private static final String AC_EDIT_PERSONAL_DATA = "edit_personal_data";

	private BookingsPage currentBookingsPage;

	private CarsPage searchCarsPage;

	private PersonalPage editPersonalDataPage;

	public MainWindow() {
		super();

		currentBookingsPage = new BookingsPage(this);
		searchCarsPage = new CarsPage(this);
		editPersonalDataPage = new PersonalPage(this);

		createMenu();

		showCurrentBookingsPage();
		setVisible(true);
	}

	private void createMenu() {
		JPanel menuPanel = new JPanel();

		JButton bookingsButton = new JButton("Current bookings");
		bookingsButton.setActionCommand(AC_CURRENT_BOOKINGS);
		bookingsButton.addActionListener(this);
		menuPanel.add(bookingsButton);

		JButton carsButton = new JButton("Search cars");
		carsButton.setActionCommand(AC_SEARCH_CARS);
		carsButton.addActionListener(this);
		menuPanel.add(carsButton);

		JButton personalButton = new JButton("Edit personal data");
		personalButton.setActionCommand(AC_EDIT_PERSONAL_DATA);
		personalButton.addActionListener(this);
		menuPanel.add(personalButton);

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
		return 600;
	}

	@Override
	protected int getMinWidth() {
		return 800;
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
		}
	}

}
