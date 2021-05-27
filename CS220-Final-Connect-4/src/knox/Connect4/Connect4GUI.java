package knox.Connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Connect4GUI extends JFrame {
	// make Connect4
	Connect4 b;
	spaces whoseTurn = spaces.YELLOW;
	
	class ButtonListener implements ActionListener {
		private int col;
		public ButtonListener(int col) {
			this.col = col;
		}
		public void actionPerformed(ActionEvent e){  
			System.out.println("Column number " + col);
             int row = b.takeTurn(whoseTurn, col);
			 setChecker(row, col);
			 // TODO: switch whoseTurn
		}
	}

	private void setChecker(int row, int col) {
		spaces color = b.get(row, col);
		if (color == spaces.YELLOW) {
			grid[row][col].setBackground(Color.yellow);
		} else {
			grid[row][col].setBackground(Color.red);
		}
		
	}


	JPanel[][] grid = new JPanel[7][7];
	
	
	
    JMenuBar menuBar;
	Connect4GUI() {

		// hack alert!
		JFrame f = this;
		b = new Connect4();
		
		setTitle("Connect 4");
		//f.setSize(1000, 1000);
    	f.setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	f.setLayout(new GridLayout(7, 7));

		// Set the buttons
		for (int c=0; c<7; c++) {
			grid[0][c] = new JPanel();
    		JButton drop1 = new JButton("drop in " + (c+1));
			grid[0][c].add(drop1);
			grid[0][c].setSize(100, 100);
			drop1.addActionListener(new ButtonListener(c));
			this.add(grid[0][c]);
		}

		// Set the panels for each grid square
		for (int r=1; r<7; r++) {
			for (int c=0; c<7; c++){
				grid[r][c] = new JPanel();
				grid[r][c].setBackground(Color.white);
				this.add(grid[r][c]);
			}
		}

		
		
        f.setResizable(true);
        f.pack();
        f.setLocation(100,100);
        f.setFocusable(true);

		repaint();

		
	 
    
	}

	public static void main(String[] args){
		Connect4GUI c4 = new Connect4GUI();
		c4.setVisible(true);
	}
	
    
}
