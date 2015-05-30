package sudoku;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class OneLetterField extends JTextField {

	/** Skapar en textruta som får innehålla en siffra */
	
	public OneLetterField() {
		super("");
		setDocument(new OneNumberDocument());
	}
	
	public void clearField() {
		removeAll();
		setDocument(new OneNumberDocument());
	}
	
	private class OneNumberDocument extends PlainDocument {	   	   
		OneNumberDocument() {	    
			super();
		} 	
		
		/** När användaren skriver i textrutorna undersöks detta om det är OK.
		 *  Endast siffrorna 1-9 tillåts.
		 */

		public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {	
			if (str.equals("") || str.equals("0") ){
				return;
			}
			if ((getLength() + str.length()) > 1) {
				return;
			}	
			if (!Character.isDigit(str.charAt(0))) {	//
				return;
			}
			super.insertString(offset, str, attr);	         
		}
	}

}