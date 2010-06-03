package de.hft.carrental.ui.main;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.hft.carrental.ui.Window;
import de.hft.carrental.ui.main.bookings.BookingsPage;
import de.hft.carrental.ui.main.cars.CarsPage;
import de.hft.carrental.ui.main.personal.PersonalPage;

public final class MainWindow extends Window {

	private static final long serialVersionUID = -1064259514784128805L;

	private BookingsPage bookingsPage;

	private CarsPage carsPage;

	private PersonalPage personalPage;

	public MainWindow() {
		super();

		bookingsPage = new BookingsPage(this);
		carsPage = new CarsPage(this);
		personalPage = new PersonalPage(this);

		createMenu();

		showBookingsPage();
		setVisible(true);
	}

	private void createMenu() {
		JPanel menuPanel = new JPanel();
		JButton bookingsButton = new JButton("Bookings");
		menuPanel.add(bookingsButton);
		JButton carsButton = new JButton("Search cars");
		menuPanel.add(carsButton);
		JButton personalButton = new JButton("Edit personal data");
		menuPanel.add(personalButton);
		add(menuPanel, createGridBagConstraints(0, 0, 1, 0,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
				GridBagConstraints.FIRST_LINE_START, 0, 0));
	}

	public void showBookingsPage() {
		switchPageTo(bookingsPage);
	}

	public void showCarsPage() {
		switchPageTo(carsPage);
	}

	public void showPersonalPage() {
		switchPageTo(personalPage);
	}

	@Override
	protected int getMinHeight() {
		return 480;
	}

	@Override
	protected int getMinWidth() {
		return 640;
	}

}
