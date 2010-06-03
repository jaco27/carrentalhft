package de.hft.carrental.ui;

import javax.swing.JFrame;

public abstract class Window extends JFrame {

	private static final long serialVersionUID = 5050185403888769434L;

	private WindowPage currentPage;

	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Car Rental System");
	}

	protected final void switchPageTo(WindowPage page) {
		if (currentPage != null) {
			remove(currentPage);
		}
		add(page);
		currentPage = page;
	}

}
