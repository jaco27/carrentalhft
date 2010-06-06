package de.hft.carrental.ui.main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This abstract class provides a section that contains a table. This table can
 * be configured as necessary by subclasses, for example which columns the table
 * has.
 * 
 * @author Alexander Weickmann
 */
public abstract class TableSection extends MainWindowPageSection {

	private static final long serialVersionUID = 8789403383980546612L;

	/** The Swing table UI widget. */
	private final JTable table;

	/** The table model that manages the data of the table. */
	private final DefaultTableModel tableModel;

	/**
	 * @param page
	 *            The window page this section belongs to.
	 * @param title
	 *            The title for this section that will be shown in the title
	 *            area of the section.
	 * @param columnNames
	 *            The names of the columns this table shall have.
	 * @param columnWidths
	 *            The width of each column.
	 */
	protected TableSection(MainWindowPage page, String title,
			String[] columnNames, int[] columnWidths) {

		super(page, title);

		tableModel = new DefaultTableModel();
		for (String columnName : columnNames) {
			tableModel.addColumn(columnName);
		}
		table = new JTable(tableModel);
		for (int i = 0; i < columnWidths.length; i++) {
			table.getColumn(columnNames[i]).setPreferredWidth(columnWidths[i]);
		}
		add(table.getTableHeader());
		add(table);
	}

	/**
	 * Clears the table by removing all data from the table so that it is empty
	 * after a call to this operation.
	 */
	protected final void clearTable() {
		tableModel.getDataVector().clear();
	}

	/**
	 * Adds one row of data to the table.
	 * 
	 * @param rowData
	 *            The array containing the row data.
	 */
	protected final void addDataRow(Object[] rowData) {
		tableModel.addRow(rowData);
	}

}
