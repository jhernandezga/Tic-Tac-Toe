package ui;

import java.util.Scanner;
import data.Board;
import data.Player;

public class TextUI implements UI{

    private static String lineDecorator = "xoXOxo xoXOxo oxoX-Oxox xoXOxo xoXOxo";
    private static Scanner reader = new Scanner(System.in);

    public void printWelcome(Player player1, Player player2) {

        System.out.println(lineDecorator);
        System.out.println("xoXOxo xoXOxo TicTacToe xoXOxo xoXOxo");
        System.out.println(lineDecorator);

        System.out.println();

        System.out.println(player1);
        System.out.println(player2);

        System.out.println();
        System.out.println(lineDecorator);
        System.out.println("\nPlayer " + player1.getPlayer() + " starts");

    }

    public int askMovement(Board board, char player) {

        printBoard(board);

        System.out.println("Player " + player + " turn ");
        System.out.println("Select the square to play and press the enter key: ");

        return reader.nextInt();
    }

    public static void printError() {
        System.out.println("\n\tPLEASE TRY AGAIN");
    }

    public void printBoard(Board board) {
        System.out.println(board);
    }

    public void printWinner(Player player) {
        System.out.println(lineDecorator);
        System.out.println(lineDecorator);
        System.out.println();
        System.out.println("\t Winner is player " + player.getPlayer());
        System.out.println();
        System.out.println(lineDecorator);
        System.out.println(lineDecorator);
    }

    public void printTie() {
        System.out.println(lineDecorator);
        System.out.println(lineDecorator);
        System.out.println();
        System.out.println("\t\t TIE");
        System.out.println();
        System.out.println(lineDecorator);
        System.out.println(lineDecorator);
    }

	@Override
	public int askMenuOption() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	@Override
	public void printError(String error) {
		System.out.println(error);
		System.out.println("TRY AGAIN");
		
	}

	@Override
	public void printMenu() {
		System.out.println("Select one option: ");
		System.out.println("1. New Game");
		System.out.println("2. Exit");
		
	}
}
