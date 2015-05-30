package phonebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhoneBook implements Serializable {
	private Map<String, LinkedList<String>> phoneBook;

	public PhoneBook() {
		phoneBook = new HashMap<String, LinkedList<String>>();
	}

	/**
	 * Associates the specified number with the specified name in this phone
	 * book. post: If the specified name is not present in this phone book, the
	 * specified name is added and associated with the specified number.
	 * Otherwise the specified number is added to the set of number associated
	 * with name.
	 * 
	 * @param name
	 *            The name for which a phone number is to be added
	 * @param number
	 *            The number associated with the specified name
	 * @return true if the specified name and number was inserted
	 */
	public boolean put(String name, String number) {
		LinkedList<String> list = phoneBook.get(name);
		if (list == null) {
			list = new LinkedList<String>();
		} else if (list.contains(number)) {
			return false;
		}
		list.add(number);
		phoneBook.put(name, list);
		return true;
	}

	/**
	 * Removes the the specified name from this phone book. post: If the
	 * specified name is present in this phone book, it is removed. Otherwise
	 * this phone book is unchanged.
	 * 
	 * @param name
	 *            The name to be removed
	 * @return true if the specified name was present
	 */
	public boolean remove(String name) {
		return phoneBook.remove(name) != null;
	}

	/**
	 * Retrieves a list of phone numbers for the specified name. If the
	 * specified name is not present in this phone book an empty list is
	 * returned.
	 * 
	 * @param name
	 *            The name whose associated phone numbers are to be returned
	 * @return The phone numbers associated with the specified name
	 */
	public List<String> findNumber(String name) {
		LinkedList<String> number = phoneBook.get(name);
		if (number == null) {
			number = new LinkedList<String>();
		}
		return number;
	}

	/**
	 * Retrieves a list of names associated with the specified phone number. If
	 * the specified number is not present in this phone book an empty list is
	 * returned.
	 * 
	 * @param number
	 *            The number for which the set of associated names is to be
	 *            returned.
	 * @return The list of names associated with the specified number
	 */
	public List<String> findNames(String number) {
		LinkedList<String> list = new LinkedList<String>();
		for (Map.Entry<String, LinkedList<String>> e : phoneBook.entrySet()) {
			for (String name : e.getValue()) {
				if (name.equals(number)) {
					list.add(e.getKey());
				}
			}
		}
		return list;
	}

	/**
	 * Retrieves the set of all names present in this phone book. The set's
	 * iterator will return the names in ascending order
	 * 
	 * @return The set of all names present in this phone book
	 */
	public Set<String> names() {
		return phoneBook.keySet();
	}

	/**
	 * Returns true if this phone book is empty
	 * 
	 * @return true if this phone book is empty
	 */
	public boolean isEmpty() {
		return phoneBook.isEmpty();
	}

	/**
	 * Returns the number of names in this phone book
	 * 
	 * @return The number of names in this phone book
	 */
	public int size() {
		return phoneBook.size();
	}

	public void writeToFile(String name) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(new File(name)));
			out.writeObject(phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public boolean readFromFile(String name) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					name));
			phoneBook = (Map<String, LinkedList<String>>) in.readObject();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
