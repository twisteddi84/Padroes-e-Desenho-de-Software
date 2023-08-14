// Author: Rafael Pinto, 103379, p5_09

import java.util.Map;
import java.util.HashMap;

public class Square {
    private int lin;
    private int col;
    private char player = ' ';

    public Square(int lin, int col) {
        assert lin >= 0 && lin < 3 && col >= 0 && col < 3: "Invalid position";
        this.lin = lin;
        this.col = col;
    }

    public boolean isEmpty() {
        return player == ' ';
    }

    public void setPlayer(char player) {
        assert player == 'X' || player == 'O': "Invalid player";
        if (isEmpty()) {
            this.player = player;
        }
    }

    public char getPlayer() {
        return player;
    }

    public Map<String,Integer> getCoodinates() {
        Map<String, Integer> coordinates = new HashMap<String, Integer>();
        coordinates.put("lin", lin);
        coordinates.put("col", col);
        return coordinates;
    }
}
