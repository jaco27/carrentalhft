package de.hft.carrental.ui;

import java.awt.Container;
import java.awt.GridLayout;

public abstract class WindowPage extends Container {

	private static final long serialVersionUID = -7371192976582192750L;

	private final Window window;

	protected WindowPage(Window window, int rows, int columns) {
		super();

		this.window = window;

		createLayout(rows, columns);
		addSections();
	}

	private void createLayout(int rows, int columns) {
		GridLayout layout = new GridLayout(rows, columns);
		setLayout(layout);
	}

	protected abstract void addSections();

	protected final void addSection(WindowPageSection section) {
		add(section);
	}

	public final Window getWindow() {
		return window;
	}

}
