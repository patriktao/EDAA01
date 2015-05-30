package phonebook;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class ShowAll extends JMenuItem implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;

	public ShowAll(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show all");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (pb.isEmpty()) {
			gui.setText("The phone book is empty.");
		} else {
			gui.setText("People contained in this phonebook: " + "\n" + "\n");

			for (String n : pb.names()) {
				for (String i : pb.findNumber(n))
					gui.appendText(n + " : " + i + "\n");

			}
		}

	}
}