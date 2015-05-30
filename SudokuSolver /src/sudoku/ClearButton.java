package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ClearButton extends JButton implements ActionListener {
	private View view;

	public ClearButton(View view) {
		
		super("Clear");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Rensar Sudoku.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				view.fields[j][i].setText("");
			}
		}
	}	
	
	
	
	

}
