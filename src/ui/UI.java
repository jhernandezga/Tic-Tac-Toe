package ui;

import data.Board;
import data.Player;

public interface UI {
	
	void printWelcome(Player palyer1,Player player2);
	int askMovement(Board board, char player);
	int askMenuOption();
	void printError(String error);
	void printBoard(Board board);
	void printWinner(Player player);
	void printTie();
	void printMenu();
}
