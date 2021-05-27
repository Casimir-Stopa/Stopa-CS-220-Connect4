package knox.Connect4;
import java.util.Scanner; 

public class Connect4  {
	// actual board is a bit bigger than what places can use to avoid out of bounds issues
	
	public int boardHeight = 8;
	public int boardLength = 9;
	public String empty;
	public spaces[][] board;



	public Connect4() {
		
		this.board = new spaces[boardHeight][boardLength];
		for(int i = 0; i < boardHeight; i++) {
			for(int j = 0; j < boardLength; j++) {
				this.board[i][j] = spaces.BLANK;
				
			}
			System.out.println();
			}
	}

	
	
	public static boolean player1Turn(Connect4 curr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1 What is your next move?");
		int n = scan.nextInt();
		while (n < 1 || n > 7) {
			System.out.println("Input a number between 1 and 7");
			n = scan.nextInt();
		}
		
		int i = 6;
		while(curr.board[i][n] != spaces.BLANK) {
			i--;
		}
		curr.board[i][n] = spaces.RED;
		return Connect4.winChecker1(curr.board, curr.board[i][n], i, n);
	}
	
	 public static boolean winChecker1(spaces[][] gameBoard, spaces currPiece, int row, int column) {
		  int spacesLeft = 0;
		  int spacesRight = 0;
		  
		  //check left to right
		  
		  while (gameBoard[row][column - spacesLeft - 1] == spaces.RED) {
			  spacesLeft++;
		  }
		  while ( gameBoard[row][column + spacesRight + 1] == spaces.RED) {
			  spacesRight++;
		  }
		  int totalLR = (spacesLeft + spacesRight + 1);
		  if (totalLR >= 4) {
			  return true;
		  }
		  
		  //check up to down
		  int spacesUp = 0;
		  int spacesDown = 0;
		  while (gameBoard[row + spacesDown + 1][column] == spaces.RED) {
			  spacesDown++;
		  }
		  	  while (gameBoard[row - spacesUp - 1][column] == spaces.RED) {
			 spacesUp++;
		  }
		  int totalUD = (spacesUp + spacesDown + 1);

		  if (totalUD >= 4) {
			  return true;
		  }
		  
		  //check up left to bottom right
		  int spacesUpLeft = 0;
		  int spacesDownRight = 0;
		  while (gameBoard[row - spacesUpLeft - 1][column - spacesUpLeft - 1] == spaces.RED) {
			  spacesUpLeft++;
		  }
		  	  while (gameBoard[row + spacesDownRight + 1][column + spacesDownRight + 1] == spaces.RED) {
		  		  spacesDownRight++;
		  }
		  int totalUpLeftandDownRight = (spacesUpLeft + spacesDownRight + 1);

		  if (totalUpLeftandDownRight >= 4) {
			  return true;
		  }
		  
		  //check bottom left top right
		  int spacesDownLeft = 0;
		  int spacesUpRight = 0;
		  while (gameBoard[row + spacesDownLeft + 1][column - spacesDownLeft - 1] == spaces.RED) {
			  spacesDownLeft++;
		  }
		  	  while (gameBoard[row + spacesUpRight + 1][column + spacesUpRight + 1] == spaces.RED) {
		  		  spacesUpRight++;
		  }
		  int totalDownLeftandUpRight = (spacesDownLeft + spacesUpRight + 1);

		  if (totalDownLeftandUpRight >= 4) {
			  return true;
		  }
		  
		  
		  return false;
	  }
	
	public static boolean player2Turn(Connect4 curr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 2 What is your next move?");
		int n = scan.nextInt();
		while (n < 1 || n > 7) {
			System.out.println("Input a number between 1 and 7");
			n = scan.nextInt();
		}
		
		int i = 6;
		while(curr.board[i][n] != spaces.BLANK) {
			i--;
		}
		curr.board[i][n] = spaces.YELLOW;
		return Connect4.winChecker2(curr.board, curr.board[i][n], i, n);
	}
	
	private static boolean winChecker2(spaces[][] gameBoard, spaces currPiece, int row, int column) {
		int spacesLeft = 0;
		  int spacesRight = 0;
		  
		  //check left to right
		  
		  while (gameBoard[row][column - spacesLeft - 1] == spaces.YELLOW) {
			  spacesLeft++;
		  }
		  while ( gameBoard[row][column + spacesRight + 1] == spaces.YELLOW) {
			  spacesRight++;

		  }
		  int totalLR = (spacesLeft + spacesRight + 1);
		  if (totalLR >= 4) {
			  return true;
		  }
		  
		  //check up to down
		  int spacesUp = 0;
		  int spacesDown = 0;
		  while (gameBoard[row + spacesDown + 1][column] == spaces.YELLOW) {
			  spacesDown++;
		  }
		  	  while (gameBoard[row - spacesUp - 1][column] == spaces.YELLOW) {
			 spacesUp++;
		  }
		  int totalUD = (spacesUp + spacesDown + 1);

		  if (totalUD >= 4) {
			  return true;
		  }
		  
		  //check up left to bottom right
		  int spacesUpLeft = 0;
		  int spacesDownRight = 0;
		  while (gameBoard[row - spacesUpLeft - 1][column - spacesUpLeft - 1] == spaces.YELLOW) {
			  spacesUpLeft++;
		  }
		  	  while (gameBoard[row + spacesDownRight + 1][column + spacesDownRight + 1] == spaces.YELLOW) {
		  		  spacesDownRight++;
		  }
		  int totalUpLeftandDownRight = (spacesUpLeft + spacesDownRight + 1);

		  if (totalUpLeftandDownRight >= 4) {
			  return true;
		  }
		  
		  //check bottom left top right
		  int spacesDownLeft = 0;
		  int spacesUpRight = 0;
		  while (gameBoard[row + spacesDownLeft + 1][column - spacesDownLeft - 1] == spaces.YELLOW) {
			  spacesDownLeft++;
		  }
		  	  while (gameBoard[row + spacesUpRight + 1][column + spacesUpRight + 1] == spaces.YELLOW) {
		  		  spacesUpRight++;
		  }
		  int totalDownLeftandUpRight = (spacesDownLeft + spacesUpRight + 1);

		  if (totalDownLeftandUpRight >= 4) {
			  return true;
		  }
		  
		
		  
		  return false;
	  }



	public static void toString(Connect4 curr) {
		for(int i = 1; i < curr.boardHeight - 1; i++) {
					for(int j = 1; j < curr.boardLength - 1; j++) {
						if(curr.board[i][j] == spaces.BLANK)
							System.out.print("_" + " ");
						if(curr.board[i][j] == spaces.RED)
							System.out.print("R" + " ");
						if(curr.board[i][j] == spaces.YELLOW)
							System.out.print("Y" + " ");
					}
					System.out.println();
					}
			}

	}
	




