package de.hft.carrental.ui.main.cars;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.hft.carrental.ui.main.MainWindowPageSection;

//TODO RM, PS: Class yet to be implemented.
public final class SearchCarsSection extends MainWindowPageSection {

	private static final long serialVersionUID = -860724473744347648L;

	// Labels for search page
	private final JLabel CarName = new JLabel("Car Name:");
	private final JLabel Pickup = new JLabel("Pick up Location:");
	private final JLabel FromDate = new JLabel("From:");
	private final JLabel ToDate = new JLabel("To:");

	// Textfields for search page
	private final JTextField CarNameField = new JTextField();
	private final JTextField PickupField = new JTextField();
	private final JTextField FromDateField = new JTextField();
	private final JTextField ToDateField = new JTextField();

	// Button for search
	private final JButton searchButton = new JButton("Search");

	protected SearchCarsSection(CarsPage carsPage) {
		super(carsPage, "Search Cars");
	}

	@Override
	protected void refresh() {
		// CarNameField.setText(user.getCarName());
		// PickupField.setText(user.getPickup());
		// FromDateField.setText(user.getFromDate());
		// ToDateField.setText(user.getToDate());
		//
		// DateFormat df = DateFormat.getInstance();
		// FromDateField.setText(df.format(user.getFromDate()));
		// ToDateField.setText(df.format(user.getToDate()));
		// searchButton.setEnabled(false);
	}

	private void addListeners() {
		// searchButton.addActionListener(this);
	}

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// searchButton.setEnabled(True);
	// CarsTableSection();
	// }
}
