package de.hft.carrental.ui.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 * 
 * @author Alexander Weickmann
 */
public final class GridBagUtil {

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
	public static GridBagConstraints createGridBagConstraints(int gridx,
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

}
