package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook pb;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.pb = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Enter name to add to phone book:");
		String number = JOptionPane.showInputDialog("Enter number to add to phone book:");
		
		if (pb.put(name, number)) {
			gui.setText("Phone number added.\n" + name + " : " + number);
		} else {
			gui.setText("Failed to add number.\nNumber already exists for that person.");
		}
	}
}
