/*
 * File: AddDlg.java
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddDlg extends JDialog implements ActionListener {
	private static final long serialVersionUID = 2392798150864283358L;

	// Static labels
	private static final String KEY_LABEL = "Search:";
	private static final String VALUE_LABEL = "Replace:";
	private static final String INSTRUCTIONS_LABEL = "";
	private static final String ADD_BTTN_LABEL = "Add";
	private static final String CANCEL_BTTN_LABEL = "Cancel";
	
	// GUI Layout parameters
	private static final int LEFT_OFFSET = 10;
	private static final int RIGHT_OFFSET = -10;
	private static final int TOP_OFFSET = 5;
	private static final int VERTICAL_SPACING = 10;
	private static final int BTTN_HEIGHT = 26;
	private static final int BTTN_WIDTH = 90;
	private static final int BTTN_OFFSET = -10;
	private static final int TEXT_FIELD_OFFSET = 65;
	private static final int DLG_HEIGHT = 150;
	private static final int DLG_WIDTH = 300;

	private static Container theContentPane;
	private static SpringLayout theLayout;
	private JTextField theSearchTextField;
	private JTextField theReplaceTextField;
	private static Kvp theKvp;
	private String theSearch;
	private String theReplace;

	public AddDlg(String title, Point parentLocation, Dimension parentSize, String search, String replace) {
		setTitle(title);
		
		theContentPane = getContentPane();
		theLayout = new SpringLayout();
		theContentPane.setLayout(theLayout);
		
		theSearch = search;
		theReplace = replace;

		// Instructions label
		JLabel instructionsLabel = new JLabel(INSTRUCTIONS_LABEL);

		theLayout.putConstraint(SpringLayout.WEST, instructionsLabel,
				LEFT_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, instructionsLabel,
				TOP_OFFSET, SpringLayout.NORTH, theContentPane);

		theContentPane.add(instructionsLabel, BorderLayout.WEST);

		// Search label
		JLabel searchLabel = new JLabel(KEY_LABEL);
		theLayout.putConstraint(SpringLayout.WEST, searchLabel, LEFT_OFFSET,
				SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, searchLabel, TOP_OFFSET,
				SpringLayout.SOUTH, instructionsLabel);

		theContentPane.add(searchLabel);

		// Search text field
		theSearchTextField = new JTextField();
		if (theSearch != null) {
			theSearchTextField.setText(theSearch);
		}
		theLayout.putConstraint(SpringLayout.WEST, theSearchTextField,
				TEXT_FIELD_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, theSearchTextField, 0,
				SpringLayout.NORTH, searchLabel);
		theLayout.putConstraint(SpringLayout.EAST, theSearchTextField, RIGHT_OFFSET,
				SpringLayout.EAST, theContentPane);
		theContentPane.add(theSearchTextField);

		// Replace label
		JLabel replaceLabel = new JLabel(VALUE_LABEL);
		theLayout.putConstraint(SpringLayout.WEST, replaceLabel, LEFT_OFFSET,
				SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, replaceLabel, VERTICAL_SPACING,
				SpringLayout.SOUTH, searchLabel);
		theContentPane.add(replaceLabel);

		// Replace text field
		theReplaceTextField = new JTextField();
		if (theReplace != null) {
			theReplaceTextField.setText(theReplace);
		}
		theLayout.putConstraint(SpringLayout.WEST, theReplaceTextField,
				TEXT_FIELD_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, theReplaceTextField, 0,
				SpringLayout.NORTH, replaceLabel);
		theLayout.putConstraint(SpringLayout.EAST, theReplaceTextField, RIGHT_OFFSET,
				SpringLayout.EAST, theContentPane);
		theContentPane.add(theReplaceTextField);

		// Add button
		JButton theAddButton = new JButton(ADD_BTTN_LABEL);
		theAddButton.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		theLayout.putConstraint(SpringLayout.EAST, theAddButton, BTTN_OFFSET,
				SpringLayout.EAST, theContentPane);
		theLayout.putConstraint(SpringLayout.SOUTH, theAddButton, BTTN_OFFSET,
				SpringLayout.SOUTH, theContentPane);
		theContentPane.add(theAddButton);

		theAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String search = theSearchTextField.getText();
				String replace = theReplaceTextField.getText();

				theKvp = new Kvp(search, replace);
				setVisible(false);
				dispose();
			}
		});

		// Cancel button
		JButton theCancelButton = new JButton(CANCEL_BTTN_LABEL);
		theCancelButton
				.setPreferredSize(new Dimension(BTTN_WIDTH, BTTN_HEIGHT));
		theLayout.putConstraint(SpringLayout.EAST, theCancelButton,
				BTTN_OFFSET, SpringLayout.WEST, theAddButton);
		theLayout.putConstraint(SpringLayout.SOUTH, theCancelButton,
				BTTN_OFFSET, SpringLayout.SOUTH, theContentPane);
		theContentPane.add(theCancelButton);

		theCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				theKvp = null;
				dispose();
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

	public Kvp getValue() {
		return theKvp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
