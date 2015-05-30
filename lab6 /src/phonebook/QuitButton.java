package phonebook;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class QuitButton extends JButton implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		int answer = JOptionPane.showConfirmDialog(gui, "Do you want to save?");

		if (answer == JOptionPane.YES_OPTION) {
			String name = JOptionPane.showInputDialog("Enter Filename:");
			pb.writeToFile(name);
			System.exit(1);

		} else if (answer == JOptionPane.CANCEL_OPTION
				|| answer == JOptionPane.NO_OPTION) {

			int confirm = JOptionPane.showConfirmDialog(gui, "Are you sure?");

			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(1);
			}

		}
	}

}