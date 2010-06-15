package de.hft.carrental.ui.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import de.hft.carrental.ui.util.GridBagUtil;

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
	private JTable table;

	/** The table model that manages the data of the table. */
	private DefaultTableModel tableModel;

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

		createLayout();
		beforeCreateTable();
		createTable(columnNames, columnWidths);
	}

	protected void beforeCreateTable() {
		// Empty default implementation.
	}

	private void createTable(String[] columnNames, int[] columnWidths) {
		tableModel = new DefaultTableModel();
		for (String columnName : columnNames) {
			tableModel.addColumn(columnName);
		}
		table = new JTable(tableModel);
		int columnMargin = 5;
		table.getColumnModel().setColumnMargin(columnMargin);
		for (int i = 0; i < columnWidths.length; i++) {
			table.getColumn(columnNames[i]).setPreferredWidth(columnWidths[i]);
		}
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.getColumnModel().setColumnMargin(columnMargin);
		add(tableHeader, GridBagUtil.createGridBagConstraints(0, 1, 1, 0,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
				GridBagConstraints.FIRST_LINE_START, 0, 0));
		add(table, GridBagUtil.createGridBagConstraints(0, 2, 1, 1,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
				GridBagConstraints.FIRST_LINE_START, 0, 0));
	}

	protected void createLayout() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
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
