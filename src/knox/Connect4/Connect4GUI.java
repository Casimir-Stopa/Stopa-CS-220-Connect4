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
	int turnSwitch = 0;
	spaces win = spaces.BLANK;
	
	class ButtonListener implements ActionListener {
		private int col;
		public ButtonListener(int col) {
			this.col = col;
		}
		public void actionPerformed(ActionEvent e){  
			if(turnSwitch % 2 == 0) {
				whoseTurn = spaces.RED;
			} else {
				whoseTurn = spaces.YELLOW;
			}
			System.out.println("col number " + col);
			
             int row = b.takeTurn(whoseTurn, col);
			 setChecker(row, col);
			 win = checkWin(b.board, row, col, whoseTurn);
             turnSwitch++;
             if (win != spaces.BLANK) {
     			whenWin(win);
     		}
            
		}
		
	}

	private void setChecker(int row, int col) {
		spaces color = b.get(row, col);
		if (color == spaces.YELLOW) {
			grid[row][col].setBackground(Color.YELLOW);
			b.board[row][col] = color;
			
		} else {
			grid[row][col].setBackground(Color.RED);
			b.board[row][col] = color;

		}
		
	}
	public void whenWin(spaces winningColor) {
		if(winningColor == spaces.RED) {
			for (int r=1; r<7; r++) {
				for (int c=1; c<8; c++){
					grid[r][c].setBackground(Color.RED);
					this.add(grid[r][c]);
				}
			}
			
		}	
		if(winningColor == spaces.YELLOW) {
			for (int r=1; r<7; r++) {
				for (int c=1; c<8; c++){
					grid[r][c].setBackground(Color.YELLOW);
					this.add(grid[r][c]);
				}
			}
		}
		
	}
	JPanel[][] grid = new JPanel[7][8];



	public spaces checkWin(spaces[][] board, int row, int col, spaces currTurn) {
		
		int spacesLeft = 0;
		  int spacesRight = 0;
		  
		  //check left to right
		  
		  while (board[row][col - spacesLeft - 1] == currTurn) {
			  spacesLeft++;
		  }
		  while ( board[row][col + spacesRight + 1] == currTurn) {
			  spacesRight++;
		  }
		  int totalLR = (spacesLeft + spacesRight + 1);
		  if (totalLR >= 4) {
			  return currTurn;
		  }
		  
		  //check up to down
		  int spacesUp = 0;
		  int spacesDown = 0;
		  while (board[row + spacesDown + 1][col] == currTurn) {
			  spacesDown++;
		  }
		  	  while (board[row - spacesUp - 1][col] == currTurn) {
			 spacesUp++;
		  }
		  int totalUD = (spacesUp + spacesDown + 1);

		  if (totalUD >= 4) {
			  return currTurn;
		  }
		  
		  //check up left to bottom right
		  int spacesUpLeft = 0;
		  int spacesDownRight = 0;
		  while (board[row - spacesUpLeft - 1][col - spacesUpLeft - 1] == currTurn) {
			  spacesUpLeft++;
		  }
		  	  while (board[row + spacesDownRight + 1][col + spacesDownRight + 1] == currTurn) {
		  		  spacesDownRight++;
		  }
		  int totalUpLeftandDownRight = (spacesUpLeft + spacesDownRight + 1);

		  if (totalUpLeftandDownRight >= 4) {
			  return currTurn;
		  }
		  
		  //check bottom left top right
		  int spacesDownLeft = 0;
		  int spacesUpRight = 0;
		  while (board[row + spacesDownLeft + 1][col - spacesDownLeft - 1] == currTurn) {
			  spacesDownLeft++;
		  }
		  	  while (board[row + spacesUpRight + 1][col + spacesUpRight + 1] == currTurn) {
		  		  spacesUpRight++;
		  }
		  int totalDownLeftandUpRight = (spacesDownLeft + spacesUpRight + 1);

		  if (totalDownLeftandUpRight >= 4) {
			  return currTurn;
		  }
		  
		  
		  return spaces.BLANK;
		
	}


	
	
	
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
			drop1.addActionListener(new ButtonListener(c+1));
			this.add(grid[0][c]);
		}

		// Set the panels for each grid square
		for (int r=1; r<7; r++) {
			for (int c=1; c<8; c++){
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

