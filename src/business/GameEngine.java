/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Frame;

import javax.swing.JOptionPane;

import data.Board;
import data.Player;
import ui.SwingUI;
import ui.TextUI;
import ui.UI;

public class GameEngine {

    private static Player player1;
    private static Player player2;
    private static Board board;
    private static UI ui;

    private static void selectUI(String[] args) {
    	
    	int answer = JOptionPane.showConfirmDialog(new Frame(), "Do you want to use GUI?", "A question",JOptionPane.YES_NO_OPTION);
        
    	if (answer == JOptionPane.YES_OPTION) {
            ui = new SwingUI();
        } else if (answer == JOptionPane.NO_OPTION) {
            ui = new TextUI();
        } else {
            ui = new SwingUI();
        }
    }

    public static void main(String[] args) {

        selectUI(args);

        do {
            ui.printMenu();
            switch (ui.askMenuOption()) {
                case 1: {
                    startGame();
                }
                break;
                case 2: {
                    System.exit(0);
                }
                default:
                	System.out.println("Invalid Option");
            }
        } while (true);
    }
    

    public static void startGame() {

        player1 = new Player('X', true);
        player2 = new Player('O', false);
        board = new Board();

        ui.printWelcome(player1, player2);
        ui.printBoard(board);
        TurnController.setUi(ui);

        play();
    }

    private static void play() {

        Player current = null;
        boolean isTie = false;
        boolean isWinner = false;

        do {
            current = getCurrentPlayer(current);
            board = TurnController.playTurn(board, current);
            if(board == null)
            {
            	break;
            }

            if (MovementHandler.isWinningMovement(board, current)) {
                ui.printWinner(current);
                isWinner = true;
            } else {
                if (!TurnController.existFreeSquares(board, player1, player2)) {
                    ui.printTie();
                    isTie = true;
                }
            }

        } while (!isWinner && !isTie);

    }

    private static Player getCurrentPlayer(Player current) {

        if (current == null) {
            return player1;
        } else {
            if (current == player1) {
                return player2;
            } else {
                return player1;
            }
        }
    }
}

