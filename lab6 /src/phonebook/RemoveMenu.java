package phonebook;

import javax.swing.*;
import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;

	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane
				.showInputDialog("Enter name to remove from phonebook:");

		if (pb.remove(name)) {
			gui.setText(name
					+ " has successfully been removed from the phonebook!");
		} else {
			gui.setText(name + " was not found in the phone book!");
		}
	}
}