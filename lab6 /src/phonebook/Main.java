package phonebook;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		PhoneBook pb = new PhoneBook();
		PhoneBookGUI gui = new PhoneBookGUI(pb);

		int answer = JOptionPane.showConfirmDialog(gui,
				"Do you want to read from file?");

		if (answer == JOptionPane.YES_OPTION) {
			String name = JOptionPane.showInputDialog("Enter file name:");
			pb.readFromFile(name);
		} else if (answer == JOptionPane.NO_OPTION) {
			pb = new PhoneBook();
		} 
	}
}