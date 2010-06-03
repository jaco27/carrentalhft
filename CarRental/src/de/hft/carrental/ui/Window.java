package de.hft.carrental.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class Window extends JFrame {

	private static final long serialVersionUID = 5050185403888769434L;

	private WindowPage currentPage;

	protected Window() {
		setNativeLookAndFeel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Car Rental System");

		// Center position on screen.
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		int x = (screenWidth / 2) - (getMinWidth() / 2);
		int y = (screenHeight / 2) - (getMinHeight() / 2);
		setMinimumSize(new Dimension(getMinWidth(), getMinHeight()));
		setLocation(x, y);

		createLayout();
	}

	private void createLayout() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}

	protected final GridBagConstraints createGridBagConstraints(int gridx,
			int gridy, int weightx, int weighty, int fill, Insets insets,
			int anchor, int ipadx, int ipady) {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.insets = insets;
		constraints.anchor = anchor;
		constraints.ipadx = ipadx;
		constraints.ipady = ipady;
		return constraints;
	}

	protected final void switchPageTo(WindowPage page) {
		if (currentPage != null) {
			remove(currentPage);
		}
		add(page, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.BOTH,
				new Insets(10, 0, 0, 0), GridBagConstraints.FIRST_LINE_START,
				0, 0));
		currentPage = page;
	}

	protected abstract int getMinWidth();

	protected abstract int getMinHeight();

	private void setNativeLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
