package TicTacToe;

// Scanner
import java.util.Scanner;


public class TicTacToe {

	public static void main(String[] args) {
		
		// GameBoard Pattern
		char[][] gameBoard = {{' ', '│', ' ', '│', ' '},
							  {'─', '+', '─', '+', '─'},
							  {' ', '│', ' ', '│', ' '},
							  {'─', '+', '─', '+', '─'},
							  {' ', '│', ' ', '│', ' '}};
		
		// GameNumberBoard Pattern
		char[][] gameNumberBoard = {{' ', '1', '│', '2', '│', '3'},
							        {' ', '─', '+', '─', '+', '─'},
							        {' ', '4', '│', '5', '│', '6'},
							        {' ', '─', '+', '─', '+', '─'},
							        {' ', '7', '│', '8', '│', '9'}};
		
		// is Player X (You can change the Starter Piece)
		boolean isPlayerX = true;
		
		// Create Scanner for reading User Input
		Scanner scan = new Scanner(System.in);
		
		// Official First Render of the Game Board
		drawGameBoard(0, "", gameBoard, gameNumberBoard);
		// Only There is 9 rounds of the game, also change the player's character,
		// and call the selectPosition function for adding new pieces to the game board
		for(int i = 0; i < 9; i++) {
			isPlayerX = !isPlayerX;
			selectPosition(gameBoard, gameNumberBoard, isPlayerX, scan);
		}
		
		// Close Scanner after the game is over
		scan.close();
		
		// The Game ends
		System.out.println("\nThe Game Is Over");
		
	}
	
	public static void drawGameBoard(int pos, String playerName, char[][] gameBoard, char[][] gameNumberBoard) {
		// if drawGameBoard takes position number as 0
		// That Means it'll render the default gameBoard Pattern Only Once (For the first time)
		// else it means it has to add new pieces to the game board
		if (pos == 0) {			
			for (int rows = 0; rows < gameBoard.length; rows++) {
				for (int columns = 0; columns < gameBoard[rows].length; columns++) {				
					System.out.print(gameBoard[rows][columns] + " ");
				}
				for (int columns = 0; columns < gameNumberBoard[rows].length; columns++) {				
					System.out.print(gameNumberBoard[rows][columns] + " ");
				}
				
				// Go Next Line
				System.out.println();
			}
			
		} else {
			// If playerName equals X or O, then based on the selected position calculate the row / column numbers,
			// and replace the empty space with playerName.charAt(0)
			if (playerName.equals("X") || playerName.equals("O")) {
				int row = (pos - 1) / 3 * 2;
			    int col = (pos - 1) % 3 * 2;
			    gameBoard[row][col] = playerName.charAt(0);
			}
			
			// Draw the next updated gameBoard with the pieces
			for (int rows = 0; rows < gameBoard.length; rows++) {
				for (int columns = 0; columns < gameBoard[rows].length; columns++) {				
					System.out.print(gameBoard[rows][columns] + " ");
				}
				for (int columns = 0; columns < gameNumberBoard[rows].length; columns++) {				
					System.out.print(gameNumberBoard[rows][columns] + " ");
				}
				
				// Go Next Line
				System.out.println();
			}
		}
	}

	public static void placePiece(int pos, char[][] gameBoard, char[][] gameNumberBoard, boolean isPlayerX) {
		// If isPlayerX true, then call drawGameBoard with the X else with the O player's name
		if (isPlayerX) {
			drawGameBoard(pos, "X", gameBoard, gameNumberBoard);
		} else {
			drawGameBoard(pos, "O", gameBoard, gameNumberBoard);
		}
	}
	
	public static void selectPosition(char[][] gameBoard, char[][] gameNumberBoard, boolean isPlayerX, Scanner scan) {
		// Get User Input of Position
		System.out.print(isPlayerX ? "X -> Enter Your Placement (1-9): " : "O -> Enter Your Placement (1-9): ");
		int pos = scan.nextInt();
		// Go Next Line
		System.out.print("\n");
		// Place The Piece to that position, also use the player's name
		placePiece(pos, gameBoard, gameNumberBoard, isPlayerX);
	}	
}
