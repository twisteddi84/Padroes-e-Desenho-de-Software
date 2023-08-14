// Author: Rafael Pinto, 103379, p5_09

import java.util.Map;

public class JogoDoGalo implements JGaloInterface{
    private Board board = new Board();
    private char currentPlayer;

    public JogoDoGalo(char initialPlayer) {
        assert initialPlayer == 'X' || initialPlayer == 'O': "Invalid player";
        if (initialPlayer == 'X') {
            currentPlayer = 'X';
        } else {
            currentPlayer = 'O';
        }
    }

    public char getActualPlayer() {
        return currentPlayer;
    }

    public boolean setJogada(int lin, int col) {
        // Search for square in the board
        Square square = null;
        for (Square s : board.getSquares()) {
            Map<String, Integer> coordinates = s.getCoodinates();
            if (coordinates.get("lin") == lin-1 && coordinates.get("col") == col-1) {
                square = s;
                break;
            }
        }
        // If square is empty, set player
        if (square.isEmpty()) {
            square.setPlayer(currentPlayer);
            // toogle player
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        return board.isFull() || checkResult() != ' ';
    }

    public char checkResult() {
        return board.winner();
    }
}
