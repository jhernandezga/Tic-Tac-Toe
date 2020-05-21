package data;

public class Board {

    private Square[][] board;

    public Board() {

        char value = '0';
        board = new Square[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Square square = new Square(row, col, (char) (++value));
                board[row][col] = square;
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

    public void updateSquare(Square square) {
        board[square.getRow()][square.getCol()] = square;
    }

    @Override
    public String toString() {
        String printBoard = "\n";

        for (int row = 0; row < board.length; row++) {
            printBoard = printBoard.concat("\t|");
            for (int col = 0; col < board.length; col++) {
                printBoard = printBoard.concat(
                        String.valueOf(board[row][col]).concat("|"));
            }
            printBoard = printBoard.concat("\n");
        }
        return printBoard;
    }
}
