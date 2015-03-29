/*
 * File: GenGen.java
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

/**
 * The GenGen class is the main class for GenGen, a tool for generating
 * code that generates code.
 * 
 * @author Scott Ritchie
 *
 * @history sritchie Mar 28, 2015 : Initial creation.
 */
public class GenGen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 5127975755643311953L;

	// Preference Keys
	private static final String HEIGHT = "Height";
	private static final String WIDTH = "Width";
	private static final String SUBSTITUTIONS = "Substitutions";
	private static final String X_POS = "X_POS";
	private static final String Y_POS = "Y_POS";

	// Static labels
	private static final String CONVERT_LABEL = "Convert";
	private static final String CLEAR_LABEL = "Clear";
	private static final String FILE_LABEL = "File";
	private static final String EXIT_LABEL = "Exit";
	private static final String SUBSTITUTIONS_MENU_LABEL = "Substitutions";
	private static final String SUBSTITUTIONS_LABEL = "Substitutions...";
	private static final String INSTRUCTIONS_LABEL = "Cut and paste your code to the text area below, then press Convert:";
	private static final String PREFS_ROOT_NODE = "GENGEN";

	// GUI Layout parameters
	private static final int LEFT_OFFSET = 10;
	private static final int RIGHT_OFFSET = -10;
	private static final int TOP_OFFSET = 5;
	private static final int BOTTOM_OFFSET = -50;
	private static final int SCROLL_PANE_TOP_OFFSET = 20;
	private static final int DEFAULT_HEIGHT = 227;
	private static final int DEFAULT_WIDTH = 794;

	// GUI components
	private static Container theContentPane;
	private static SpringLayout theLayout;
	private static Preferences thePreferences;
	private JTextArea theTextArea;
	private JButton theConvertButton;

	// Misc
	private static String LINE_SEPARATOR = "\n";
	private static boolean isDebug = false;

	private int theX = 0;
	private int theY = 0;
	private int theHeight = 0;
	private int theWidth = 0;

	Substitutions theSubstitutions;

	/**
	 * This application converts Java code to Java code that can generate
	 * itself.
	 */
	public GenGen() {
		getPreferences();
		buildMenuBar();

		theContentPane = getContentPane();
		theLayout = new SpringLayout();
		theContentPane.setLayout(theLayout);

		buildPanel();

		pack();
		setVisible(true);
		setLocation(theX, theY);
		setSize(theWidth, theHeight);
		setTitle("GenGen");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(CONVERT_LABEL)) {
			String[] strings = theTextArea.getText().split("\n");
			String result = "";

			for (String s : strings) {
				result = result.concat(convert(s) + LINE_SEPARATOR);
			}

			theTextArea.setText(result);

			theConvertButton.setEnabled(false);
		} else if (e.getActionCommand().equals(CLEAR_LABEL)) {
			theTextArea.setText("");
			theConvertButton.setEnabled(true);
		}
	}

	/*
	 * This method converts the provided string to code that will generate the
	 * string.
	 */
	private String convert(String input) {
		String result = "";
		String trimmedInput = input.trim();

		if (trimmedInput.length() == 0) {
			result = "toString = toString.concat(LINE_SEPARATOR);";
		} else {
			String tmpString = "";
			char c = 0;
			for (int i = 0; i < trimmedInput.length(); i++) {
				c = trimmedInput.charAt(i);

				// Escape any embedded quotes
				if (c == '"') {
					tmpString = tmpString.concat("\\");
				}

				// Decrement the level if a closing brace is detected
				if (c == '}' && i == 0) {
					result = result.concat("theLevel--;" + LINE_SEPARATOR);
				}

				tmpString = tmpString.concat(Character.toString(c));
			}
			
			for (Kvp kvp : theSubstitutions.get()) {
				while (tmpString.contains(kvp.getKey())) {
					tmpString = tmpString.replace(kvp.getKey(), kvp.getValue());
				}
			}

			result = result.concat("toString = toString.concat(getPad() + \""
					+ tmpString + "\" + LINE_SEPARATOR);");

			/*
			 * If the last character is an opening brace then increment the
			 * level.
			 */
			if (c == '{') {
				result = result.concat(LINE_SEPARATOR + "theLevel++;");
			}
		}

		return result;
	}

	/*
	 * This method gets the preferences.
	 */
	private void getPreferences() {
		thePreferences = Preferences.userRoot().node(PREFS_ROOT_NODE);
		theX = thePreferences.getInt(X_POS, 291);
		theY = thePreferences.getInt(Y_POS, 90);

		theHeight = thePreferences.getInt(HEIGHT, DEFAULT_HEIGHT);
		theWidth = thePreferences.getInt(WIDTH, DEFAULT_WIDTH);

		byte[] bytes = thePreferences.getByteArray(SUBSTITUTIONS, null);
		HexDump.hexDump(bytes);

		if (bytes != null) {
			theSubstitutions = new Substitutions();
			theSubstitutions.unpack(bytes);
		} else {
			theSubstitutions = new Substitutions();
			Kvp kvp = new Kvp("someCode", "\" + getSomeOtherCode() + \"");
			theSubstitutions.add(kvp);
		}
	}

	/*
	 * This method builds the main panel.
	 */
	private void buildPanel() {
		JLabel instructionsLabel = new JLabel(INSTRUCTIONS_LABEL);

		theLayout.putConstraint(SpringLayout.WEST, instructionsLabel,
				LEFT_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, instructionsLabel,
				TOP_OFFSET, SpringLayout.NORTH, theContentPane);

		theContentPane.add(instructionsLabel, BorderLayout.WEST);

		// Text area
		theTextArea = new JTextArea("");

		// Scroll Pane
		JScrollPane scrollPane = new JScrollPane(theTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		theLayout.putConstraint(SpringLayout.WEST, scrollPane, LEFT_OFFSET,
				SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.EAST, scrollPane, RIGHT_OFFSET,
				SpringLayout.EAST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, scrollPane,
				SCROLL_PANE_TOP_OFFSET, SpringLayout.NORTH, instructionsLabel);
		theLayout.putConstraint(SpringLayout.SOUTH, scrollPane, BOTTOM_OFFSET,
				SpringLayout.SOUTH, theContentPane);

		theContentPane.add(scrollPane, BorderLayout.WEST);

		// Convert button
		theConvertButton = new JButton(CONVERT_LABEL);

		theLayout.putConstraint(SpringLayout.WEST, theConvertButton,
				LEFT_OFFSET, SpringLayout.WEST, theContentPane);
		theLayout.putConstraint(SpringLayout.NORTH, theConvertButton,
				TOP_OFFSET, SpringLayout.SOUTH, scrollPane);

		theContentPane.add(theConvertButton, BorderLayout.WEST);

		theConvertButton.setActionCommand(CONVERT_LABEL);
		theConvertButton.addActionListener(this);

		// Clear button
		JButton clearButton = new JButton(CLEAR_LABEL);

		theLayout.putConstraint(SpringLayout.WEST, clearButton, LEFT_OFFSET,
				SpringLayout.EAST, theConvertButton);
		theLayout.putConstraint(SpringLayout.NORTH, clearButton, TOP_OFFSET,
				SpringLayout.SOUTH, scrollPane);

		theContentPane.add(clearButton, BorderLayout.WEST);

		clearButton.setActionCommand(CLEAR_LABEL);
		clearButton.addActionListener(this);
	}

	/*
	 * This method builds the menubar.
	 */
	private void buildMenuBar() {
		JMenuBar menuBar;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the File menu.
		JMenu fileMenu = new JMenu(FILE_LABEL);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// Clear
		menuItem = new JMenuItem(CLEAR_LABEL);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				theTextArea.setText("");
				theConvertButton.setEnabled(true);
			}
		});

		fileMenu.add(menuItem);

		// Exit
		menuItem = new JMenuItem(EXIT_LABEL);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				thePreferences.putInt(X_POS, getLocation().x);
				thePreferences.putInt(Y_POS, getLocation().y);
				thePreferences.putInt(HEIGHT, getSize().height);
				thePreferences.putInt(WIDTH, getSize().width);
				
				byte[] bytes = theSubstitutions.pack();
				HexDump.hexDump(bytes);
				thePreferences.putByteArray(SUBSTITUTIONS, theSubstitutions.pack());

				System.exit(0);
			}
		});

		fileMenu.add(menuItem);

		// Build the Substitutions menu
		JMenu substitutionsMenu = new JMenu(SUBSTITUTIONS_MENU_LABEL);
		substitutionsMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(substitutionsMenu);

		// Substitutions...
		menuItem = new JMenuItem(SUBSTITUTIONS_LABEL);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubstitutionsDlg subDlg = new SubstitutionsDlg(getLocation(),
						getSize(), theSubstitutions);
				subDlg.setModal(true);
				subDlg.setVisible(true);

				theSubstitutions = subDlg.getValue();
				System.out.println("# of substitutions: "
						+ theSubstitutions.size());
			}
		});

		substitutionsMenu.add(menuItem);

		this.setJMenuBar(menuBar);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (String arg : args) {
			if (arg.equals("-d")) {
				isDebug = true;
			}
		}
		new GenGen();
	}
}
