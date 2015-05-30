package sudoku;

import java.awt.*;
import javax.swing.*;


public class CommandPanel extends JPanel {

	/** Sätter layout och lägger till knapparna SolveButton och ClearButton */
	
	public CommandPanel(View view) {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(new SolveButton(view));
			add(new ClearButton(view));
		}
	}
		
