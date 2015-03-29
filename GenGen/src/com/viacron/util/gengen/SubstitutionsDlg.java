/*
 * File: SubstitutionsDlg.java
 * 
 * Copyright (C) 2015  Scott Ritchie
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.viacron.util.gengen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * This class builds a dialog for entering substitutions.
 * 
 * @author Scott Ritchie
 *
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class SubstitutionsDlg extends JDialog implements ActionListener,
		TableModelListener {
	private static final long serialVersionUID = -7825714415329034125L;

	// Static labels
	private static final String DLG_TITLE = "Substitutions";
	private static final String ADD_LABEL = "Add...";
	private static final String EDIT_LABEL = "Edit...";
	private static final String DELETE_LABEL = "Delete";
	private static final String CLOSE_LABEL = "Close";
	private static final String KEY_COL_LABEL = "SEARCH STRING";
	private static final String VALUE_COL_LABEL = "REPLACEMENT STRING";
	private static final String INSTRUCTIONS_LABEL = "Instructions: Enter a search string and the value by which it should be replaced.";

	// Tooltips
	private static final String ADD_TOOLTIP = "Add a new search/replace pair";
	private static final String EDIT_TOOLTIP = "Edit a search/replace pair";
	private static final String DELETE_TOOLTIP = "Delete a search/replace pair";
	private static final String CLOSE_TOOLTIP = "Close the dialog";
	
	// GUI Layout parameters
	private static final int LEFT_OFFSET = 10;
	private static final int TOP_OFFSET = 5;
	private static final int BOTTOM_OFFSET = -10;
	private static final int VERTICAL_SPACING = 15;
	private static final int BTTN_HEIGHT = 26;
	private static final int BTTN_WIDTH = 70;
	private static final int BTTN_OFFSET = -10;
	private static final int DLG_HEIGHT = 275;
	private static final int DLG_WIDTH = 600;

	private static Container theContentPane;
	private static SpringLayout theLayout;
	private static JTable theTable;
	private JButton theEditButton;
	private JButton theDeleteButton;
	private static Substitutions theSubstitutions;

	public SubstitutionsDlg(Point parentLocation, Dimension parentSize,
			Substitutions substitutions) {
		setTitle(DLG_TITLE);
		theContentPane = getContentPane();
		theLayout = new SpringLayout();
		theContentPane.setLayout(theLayout);

		theSubstitutions = substitutions;

		// Instructions label
		JLabel instructionsLabel = new JLabel(INSTRUCTIONS_LABEL);

		theLayout.putConstraint(SpringLayout.WEST, instructionsLabel,
				LEFT_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, instructionsLabel,
				TOP_OFFSET, SpringLayout.NORTH, theContentPane);

		theContentPane.add(instructionsLabel, BorderLayout.WEST);

		// Table
		theTable = new JTable(new SubstitutionsTableModel(theSubstitutions));
		theTable.setRowSelectionAllowed(true);

		/*
		 * Detect selections so the Edit and Delete buttons can be
		 * enabled/disabled properly.
		 */
		ListSelectionModel listSelectionModel = theTable.getSelectionModel();
		listSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel
				.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent event) {
						int row = theTable.getSelectedRow();
						if (row != -1) {
							theEditButton.setEnabled(true);
							theDeleteButton.setEnabled(true);
						} else {
							theEditButton.setEnabled(false);
							theDeleteButton.setEnabled(false);
						}
					}
				});

		// Scroll Pane
		JScrollPane scrollPane = new JScrollPane(theTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		theLayout.putConstraint(SpringLayout.WEST, scrollPane, LEFT_OFFSET,
				SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, scrollPane, TOP_OFFSET,
				SpringLayout.SOUTH, instructionsLabel);
		theLayout.putConstraint(SpringLayout.SOUTH, scrollPane, BOTTOM_OFFSET,
				SpringLayout.SOUTH, theContentPane);

		theContentPane.add(scrollPane);

		theTable.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		theTable.getModel().addTableModelListener(this);

		// Add button
		JButton addButton = new JButton(ADD_LABEL);
		addButton.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		addButton.setToolTipText(ADD_TOOLTIP);
		
		theLayout.putConstraint(SpringLayout.EAST, addButton, BTTN_OFFSET,
				SpringLayout.EAST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, addButton, 0,
				SpringLayout.NORTH, scrollPane);
		theContentPane.add(addButton);

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				AddDlg addDlg = new AddDlg("Add", getLocation(), getSize(), null, null);
				addDlg.setModal(true);
				addDlg.setVisible(true);
				Kvp kvp = addDlg.getValue();

				if (kvp != null) {
					System.out.println("key: " + kvp.getKey());
					System.out.println("value: " + kvp.getValue());

					SubstitutionsTableModel model = (SubstitutionsTableModel) theTable
							.getModel();
					model.add(kvp);
					model.fireTableRowsInserted(model.getRowCount() - 1,
							model.getRowCount() - 1);
				} else {
					System.out.println("kvp is null");
				}
			}
		});

		// Edit button
		theEditButton = new JButton(EDIT_LABEL);
		theEditButton.setToolTipText(EDIT_TOOLTIP);
		theEditButton.setEnabled(false);
		theEditButton.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		theLayout.putConstraint(SpringLayout.WEST, theEditButton, 0,
				SpringLayout.WEST, addButton);
		theLayout.putConstraint(SpringLayout.NORTH, theEditButton,
				VERTICAL_SPACING, SpringLayout.SOUTH, addButton);
		theContentPane.add(theEditButton);
		
		theEditButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				int selectedRow = theTable.getSelectedRow();
				String search = (String) theTable.getModel().getValueAt(selectedRow, 0);
				String replace = (String) theTable.getModel().getValueAt(selectedRow, 1);
				
				AddDlg addDlg = new AddDlg("Edit", getLocation(), getSize(), search, replace);
				addDlg.setModal(true);
				addDlg.setVisible(true);
				Kvp kvp = addDlg.getValue();

				if (kvp != null) {
					System.out.println("key: " + kvp.getKey());
					System.out.println("value: " + kvp.getValue());

					SubstitutionsTableModel model = (SubstitutionsTableModel) theTable
							.getModel();
					selectedRow = theTable.getSelectedRow();
					model.delete(selectedRow);
					model.add(kvp);
					model.fireTableRowsUpdated(selectedRow, selectedRow);
				} else {
					System.out.println("kvp is null");
				}
			}
		});

		// Delete button
		theDeleteButton = new JButton(DELETE_LABEL);
		theDeleteButton.setToolTipText(DELETE_TOOLTIP);
		theDeleteButton.setEnabled(false);
		theDeleteButton
				.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		theLayout.putConstraint(SpringLayout.WEST, theDeleteButton, 0,
				SpringLayout.WEST, theEditButton);
		theLayout.putConstraint(SpringLayout.NORTH, theDeleteButton,
				VERTICAL_SPACING, SpringLayout.SOUTH, theEditButton);
		theContentPane.add(theDeleteButton);

		theDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				int row = theTable.getSelectedRow();

				if (row != -1) {
					SubstitutionsTableModel model = (SubstitutionsTableModel) theTable
							.getModel();
					model.delete(row);
					model.fireTableRowsDeleted(row, row);
				}
			}
		});

		// Close Button
		JButton closeBttn = new JButton(CLOSE_LABEL);
		closeBttn.setToolTipText(CLOSE_TOOLTIP);
		closeBttn.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		theLayout.putConstraint(SpringLayout.WEST, closeBttn, 0,
				SpringLayout.WEST, theEditButton);
		theLayout.putConstraint(SpringLayout.NORTH, closeBttn,
				2 * VERTICAL_SPACING, SpringLayout.SOUTH, theDeleteButton);
		theContentPane.add(closeBttn);

		closeBttn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});

		this.setPreferredSize(new Dimension(DLG_WIDTH, DLG_HEIGHT));
		pack();

		this.setLocation(new Point(parentLocation.x + parentSize.width / 2,
				parentLocation.y + parentSize.height / 2));

		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent event) {
				System.out
						.println("w: " + event.getComponent().getSize().width);
				System.out.println("h: "
						+ event.getComponent().getSize().height);
			}
		});
	}

	public Substitutions getValue() {
		return theSubstitutions;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public class SubstitutionsTableModel extends AbstractTableModel {

		private static final long serialVersionUID = -6265394059349797998L;
		private final String[] COL_NAMES = { KEY_COL_LABEL, VALUE_COL_LABEL };
		private Substitutions theSubstitions;

		public SubstitutionsTableModel(Substitutions substitutions) {
			theSubstitions = substitutions;
		}

		public void add(Kvp kvp) {
			theSubstitions.add(kvp);
			this.fireTableDataChanged();
		}

		public void delete(Kvp kvp) {
			theSubstitions.delete(kvp);
			this.fireTableDataChanged();
		}

		public void delete(int row) {
			theSubstitions.get().remove(row);
			this.fireTableDataChanged();
		}

		public void edit(Kvp oldKvp, Kvp newKvp) {
			theSubstitions.edit(oldKvp, newKvp);
			this.fireTableDataChanged();
		}

		@Override
		public void fireTableDataChanged() {
			System.out.println("fireTableDataChanged()");
		}

		@Override
		public int getColumnCount() {
			return COL_NAMES.length;
		}

		@Override
		public int getRowCount() {
			return theSubstitions.size();
		}

		@Override
		public String getColumnName(int col) {
			return COL_NAMES[col];
		}

		public Class getColumnClass(int col) {
			return String.class;
		}

		@Override
		public Object getValueAt(int row, int col) {
			Kvp kvp = theSubstitions.get().get(row);

			if (kvp != null) {
				if (col == 0) {
					return kvp.getKey();
				} else if (col == 1) {
					return kvp.getValue();
				}
			}

			return null;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			if (col == 0) {
				theSubstitions.get().get(row).setKey((String) value);
			} else if (col == 1) {
				theSubstitions.get().get(row).setValue((String) value);
			}
		}
	}

	@Override
	public void tableChanged(TableModelEvent event) {
		int row = event.getFirstRow();
		int col = event.getColumn();
		SubstitutionsTableModel model = (SubstitutionsTableModel) event
				.getSource();
		System.out.println("table changed");
	}
}
