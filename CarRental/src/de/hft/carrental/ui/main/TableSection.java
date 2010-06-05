package de.hft.carrental.ui.main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.hft.carrental.ui.WindowPage;
import de.hft.carrental.ui.WindowPageSection;

public abstract class TableSection extends WindowPageSection {

	private static final long serialVersionUID = 8789403383980546612L;

	private JTable table;

	private DefaultTableModel tableModel;

	protected TableSection(WindowPage page, String title, String[] columnNames,
			int[] columnWidths) {

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

	protected final void clearTable() {
		tableModel.getDataVector().clear();
	}

	protected final void addDataRow(Object[] rowData) {
		tableModel.addRow(rowData);
	}

}
