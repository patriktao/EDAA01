package phonebook;

import javax.swing.*;

import java.awt.event.*;
import java.util.List;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;

	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find numbers");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (!pb.isEmpty()) {
			String name = JOptionPane
					.showInputDialog("Find numbers associated with this name:");
			List<String> numbers = pb.findNumber(name);

			if (!numbers.isEmpty()) {
				gui.setText("Numbers associated with name: " + name + "\n" + "\n");
				for (String n : numbers) {
					gui.appendText("Number: " + n + "\n");
				}
			} else {
				gui.setText("No such name in the phonebook!");
			}
		} else {
			gui.setText("Phonebook empty!");
		}

	}
}