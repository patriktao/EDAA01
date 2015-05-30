package phonebook;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class FindNamesMenu extends JMenuItem implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;

	public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find names");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (!pb.isEmpty()) {

			gui.setText("");
			String number = JOptionPane
					.showInputDialog("Find names associated with this number: ");

			LinkedList<String> names = (LinkedList<String>) pb
					.findNames(number);

			gui.setText(" Name : ");
			if (names != null) {
				gui.setText("People with phone number: " + number + "\n" + "\n");
				for (String s : names) {
					gui.appendText("Name: " + s + "\n");

				}
			} else {
				gui.setText("No such number in the phonebook!");
			}

		} else {
			gui.setText("Phonebook empty!");
		}
	}
}