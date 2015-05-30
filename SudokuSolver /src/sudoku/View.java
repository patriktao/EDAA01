package sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class View {
	private CommandPanel commandPanel;
	private Grid grid;
	public OneLetterField[][] fields;

	public View() {
	
		fields = new OneLetterField[9][9];
		commandPanel = new CommandPanel(this);
		grid = new Grid(this, fields);
		
		JFrame frame = new JFrame("Sudoku");
		frame.add(grid, BorderLayout.NORTH);
		frame.add(commandPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(370, 310);
		frame.setLocationRelativeTo(null);
	}

	/** Skapar en Sudoku */

	public static void main(String[] args) {
		View Sudoku = new View();
	}

}