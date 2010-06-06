package de.hft.carrental.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class represents an application window. In addition to a normal
 * {@link JFrame} it uses the native look and feel of the used OS. The window
 * will also be positioned in the center of the screen by default. The title of
 * the window as well as the default close operation will be already set.
 * <p>
 * Furthermore, a grid layout is assigned to the window. A convenience method is
 * offered to subclasses that enables rapid creation of
 * {@link GridBagConstraints}.
 * <p>
 * Also, the concept of a current {@link WindowPage} is introduced. Using the
 * method {@link #switchPageTo(WindowPage)} subclasses can switch to another
 * window page at any time.
 * 
 * @author Alexander Weickmann
 */
public abstract class Window extends JFrame {

	private static final String WINDOW_TITLE = "Car Rental System";

	private static final long serialVersionUID = 5050185403888769434L;

	/**
	 * The {@link WindowPage} that is currently displayed.
	 */
	private WindowPage currentPage;

	protected Window() {
		setNativeLookAndFeel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(WINDOW_TITLE);

		centerOnScreen();

		createLayout();
	}

	private void centerOnScreen() {
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		int x = (screenWidth / 2) - (getMinWidth() / 2);
		int y = (screenHeight / 2) - (getMinHeight() / 2);
		setMinimumSize(new Dimension(getMinWidth(), getMinHeight()));
		setLocation(x, y);
	}

	private void createLayout() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
	}

	/**
	 * Convenience method provided to subclasses allowing for rapid
	 * {@link GridBagConstraints} creation.
	 * 
	 * @param gridx
	 *            The zero-based x-position of the component inside the grid.
	 * @param gridy
	 *            The zero-based y-position of the component inside the grid.
	 * @param weightx
	 *            Value between 0.0 and 1.0 indicating how much priority the
	 *            component has when it comes to filling up empty horizontal
	 *            space.
	 * @param weighty
	 *            Value between 0.0 and 1.0 indicating how much priority the
	 *            component has when it comes to filling up empty vertical
	 *            space.
	 * @param fill
	 *            Indicates whether additional space should be used by the
	 *            component (both, horizontal, vertical or none).
	 * @param insets
	 *            Specifies the external padding of the component.
	 * @param anchor
	 *            Specifies where to anchor the component.
	 * @param ipadx
	 *            Specifies the internal padding in x direction.
	 * @param ipady
	 *            Specifies the internal padding in y direction.
	 */
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

	/**
	 * Switches to the provided {@link WindowPage}. Causes the window to be
	 * repainted so the contents of the new page are shown immediately.
	 * 
	 * @param page
	 *            The {@link WindowPage} to switch to.
	 */
	protected final void switchPageTo(WindowPage page) {
		if (currentPage != null) {
			remove(currentPage);
		}

		add(page, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.BOTH,
				new Insets(10, 0, 0, 0), GridBagConstraints.FIRST_LINE_START,
				0, 0));

		currentPage = page;
		currentPage.refresh();
		validate();
		repaint();
	}

	/**
	 * Must return the minimum width this window shall have.
	 */
	protected abstract int getMinWidth();

	/**
	 * Must return the minimum height this window shall have.
	 */
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
