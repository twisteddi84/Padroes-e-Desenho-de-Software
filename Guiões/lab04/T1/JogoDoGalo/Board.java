// Author: Rafael Pinto, 103379, p5_09

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Square> squares = new ArrayList<Square>();
    
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares.add(new Square(i, j));
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }

    public boolean isFull() {
        for (Square square : squares) {
            if (square.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public char winner() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (squares.get(i * 3).getPlayer() != ' ' &&
                squares.get(i * 3).getPlayer() == squares.get(i * 3 + 1).getPlayer() &&
                squares.get(i * 3).getPlayer() == squares.get(i * 3 + 2).getPlayer()) {
                return squares.get(i * 3).getPlayer();
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (squares.get(i).getPlayer() != ' ' &&
                squares.get(i).getPlayer() == squares.get(i + 3).getPlayer() &&
                squares.get(i).getPlayer() == squares.get(i + 6).getPlayer()) {
                return squares.get(i).getPlayer();
            }
        }
        // check diagonals
        if (squares.get(0).getPlayer() != ' ' &&
            squares.get(0).getPlayer() == squares.get(4).getPlayer() &&
            squares.get(0).getPlayer() == squares.get(8).getPlayer()) {
            return squares.get(0).getPlayer();
        }
        if (squares.get(2).getPlayer() != ' ' &&
            squares.get(2).getPlayer() == squares.get(4).getPlayer() &&
            squares.get(2).getPlayer() == squares.get(6).getPlayer()) {
            return squares.get(2).getPlayer();
        }
        return ' ';
    }
}
