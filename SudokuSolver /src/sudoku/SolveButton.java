package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import sudoku.SudokuSolver;

public class SolveButton extends JButton implements ActionListener {

	View view;
	SudokuSolver solver = new SudokuSolver();

	/** Skapar en knapp som används då sudokun ska lösas */

	public SolveButton(View view) {
		super("Solve");
		this.view = view;
		addActionListener(this);

	}

	@Override
	/** Vid knapptryck löses sudokun.
	 * param e är det ActionEvent som skapas vid knapptryck */
	
	public void actionPerformed(ActionEvent e) {
		solver.scanMatrix(view.fields);
		if (solver.testFile()) {
			if (solver.solve(0, 0)) {
				int[][] temp = solver.getSolved();

				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						String s = "" + temp[i][j];
						view.fields[i][j].setText(s);
					}
				}
				JOptionPane.showMessageDialog(null, "Lösning hittad!");
			} else {
				JOptionPane.showMessageDialog(null, "Tyvärr fanns ingen lösning!");
			}
		
		}
	}	
}
