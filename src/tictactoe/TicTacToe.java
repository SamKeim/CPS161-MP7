package tictactoe;

import java.util.*;

class TicTacToe {
	Map<Character, Character> ttt = setBlankBoard();
	//char ttt[][] = new char[3][3];
	static final char player1 = 'O';
	static final char player2 = 'X';
	Scanner scan = new Scanner(System.in);

	String playerID(char player) {
	// Prints the identity of the player
	// For example:
	// player2: X
		if (player == player1)
			return "player1: " + player;
		else
			return "player2: " + player;
	}
	
	Map<Character, Character> setBlankBoard() {
		Map<Character, Character> board = new HashMap<>();
		board.put('A', ' ');
		board.put('B', ' ');
		board.put('C', ' ');
		board.put('D', ' ');
		board.put('E', ' ');
		board.put('F', ' ');
		board.put('G', ' ');
		board.put('H', ' ');
		board.put('I', ' ');
//		board.put('A', '1');
//		board.put('B', '2');
//		board.put('C', '3');
//		board.put('D', '4');
//		board.put('E', '5');
//		board.put('F', '6');
//		board.put('G', '7');
//		board.put('H', '8');
//		board.put('I', '9');
		return board;
	}
	void getPlayerInput(char player) {
		// ******* Details to fill in ************

		// Prompt the user for a cell input. Make sure its a legal
		// cell designator. Also make sure the cell doesn't already
		// have a player in it. Prompt the user again in the case
		// of any problem. Once a valid spot has been found,
		// you will issue a statement like:
		// ttt[row][col] = player;
		boolean isValid = true;
		Character userInput = ' ';
		do {
			System.out.println("Entering input for: " + playerID(player));
			System.out.print("Enter in cell: ");
			userInput = scan.nextLine().toUpperCase().charAt(0);
			if(userInput < 'A' || userInput > 'I') {
				isValid = false;
				System.out.println("Please enter a valid cell.");
			} else {
				isValid = true;
			}
		} while (!isValid);
		ttt.put(userInput, player);

	}

	boolean gameIsDraw() {
		// ******* Details to fill in ************

		// If all ttt entries have been taken return true
		// otherwise return false
		boolean isDraw = true;
		for(Character c = 'A'; c <= 'I'; c++) {
				if(ttt.get(c) == ' ') {
					isDraw = false;
			}
		}
		return isDraw;
	}

	boolean winner(char player) {
		// ******* Details to fill in ************

		// Check to see if the parameter player has won
		// Winning means that player shows up in a line of
		// three. The line can be a column, row or a diagonal
		// Return true if player is a winner, otherwise return false.
		
		// Possible Win Conditions:
		// Horizontal
		// ABC / DEF / GHI
		// Vertical
		// ADG / BEH / CFI
		// Diagonal
		// AEI / CEG
		
		boolean winner = false;
		if(ttt.get('A') == player) {
			if(ttt.get('B') == player && ttt.get('C') == player) {
				winner = true;
			} else if (ttt.get('D') == player && ttt.get('G') == player) {
				winner = true;
			} else if (ttt.get('E') == player && ttt.get('I') == player) {
				winner = true;
			}
		} else if (ttt.get('B') == player && ttt.get('E') == player && ttt.get('H') == player) {
			winner = true;
		} else if (ttt.get('C') == player) {
			if(ttt.get('F') == player && ttt.get('I') == player) {
				winner = true;
			} else if (ttt.get('E') == player && ttt.get('G') == player) {
				winner = true;
			}
		} else if (ttt.get('D') == player && ttt.get('E') == player && ttt.get('F') == player) {
			winner = true;
		} else if (ttt.get('G') == player && ttt.get('H') == player && ttt.get('I') == player) {
			winner = true;
		}
		return winner;
	}

	void displayBoard() {
		// ******* Details to fill in ************
		Character c = 'A';
		System.out.println("********************************");
		System.out.println(" ---a------b------c---");
		for (int i = 0; i < 3; i++) {
			if(c <= 'I') {
				System.out.printf(" |  %s   |  %s   |  %s   |\n", ttt.get(c++),  ttt.get(c++),  ttt.get(c++));
			}
			switch (i) {
			case 0:
				System.out.println(" ---d------e------f---");
				break;
			case 1:
				System.out.println(" ---g------h------i---");
				break;
			case 2:
				System.out.println(" ---------------------");
				break;
			}
		}
	}

	void newgame() {
		char currPlayer = player1;
		ttt = setBlankBoard();
		boolean continueFlag = true;
	
		while (continueFlag) {
			displayBoard();
			if (gameIsDraw()) {
				System.out.println("Game Ends in Draw");
				continueFlag = false;
			} else {
				getPlayerInput(currPlayer);
				if (winner(currPlayer)) {
					System.out.println("We have a winner: " + playerID(currPlayer));
					displayBoard();
					continueFlag = false;
				} else {
					if (currPlayer == player1)
						currPlayer = player2;
					else
						currPlayer = player1;
				}
			}
		}

	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		String str;
		do {
			game.newgame();

			System.out.println("Do you want to play Tic-Tac-Toe (y/n)?");
			str = game.scan.next();
			game.scan.nextLine();
		} while ("y".equalsIgnoreCase(str));

		System.out.println("Bye");
	}
}