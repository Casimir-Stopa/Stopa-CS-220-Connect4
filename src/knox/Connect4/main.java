package knox.Connect4;

public class main {
	
  	public static void main(String[] args) {
  		Connect4 b = new Connect4();
		Connect4GUI bBUI = new Connect4GUI();
  		boolean player1Win = false;
  		boolean player2Win = false;

  		while(!player1Win && !player2Win) {
  			System.out.print(b.toString());
  			
  			player1Win = Connect4.player1Turn(b);
  			if(player1Win) {
  	  			//Connect4.toString(b);
				System.out.println(b.toString());
  				System.out.print("Player 1 wins!!");
  				break;
  			}
  			System.out.print(b.toString());
  			player2Win = Connect4.player2Turn(b);
  			if(player2Win) {
  	  			System.out.print(b.toString());
  				System.out.print("Player 2 wins!!");
  				break;
  			}
  		} 

  	}
  	}
	
	



