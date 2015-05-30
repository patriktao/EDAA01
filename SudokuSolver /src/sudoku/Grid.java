package sudoku;

import javax.swing.*;

import java.awt.*;
public class Grid extends JPanel{
	
	private OneLetterField[][] fields;
	
	/** Skapar en panel som består ett rutnät 9 * 9 av klassen OneLetterField */
	
	public Grid(View view,  OneLetterField[][] fields) {
		this.fields = fields;
		setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new OneLetterField();
				fields[i][j].setText("");
				if(i/3 != 1 && j/3 != 1 || i/3 == 1 && j/3 == 1) {		
					fields[i][j].setBackground(new Color(180, 180, 180)); 
				}
				add(fields[i][j]);
			}
		}
		
	}	
}