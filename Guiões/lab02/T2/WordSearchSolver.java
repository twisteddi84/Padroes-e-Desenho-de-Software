import java.io.*;
import java.util.*;

public class WordSearchSolver {

    private char[][] puzzle;
    private final List<String> words;
    private final int[][] foundPositions;
    private final int[][] foundDirections;
    private final int[][] directions;
    private final Map<List<Integer>, String> directionNames;
    private final String filePath;

    public WordSearchSolver(String filePath) throws IOException {
        this.filePath = filePath;
        this.words = new ArrayList<>();
        readFile(filePath);

        this.foundPositions = new int[words.size()][2];
        this.foundDirections = new int[words.size()][2];

        this.directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        this.directionNames = new HashMap<>();
        directionNames.put(Arrays.asList(-1, -1), "upLeft");
        directionNames.put(Arrays.asList(-1, 0), "up");
        directionNames.put(Arrays.asList(-1, 1), "upRight");
        directionNames.put(Arrays.asList(0, -1), "left");
        directionNames.put(Arrays.asList(0, 1), "right");
        directionNames.put(Arrays.asList(1, -1), "downLeft");
        directionNames.put(Arrays.asList(1, 0), "down");
        directionNames.put(Arrays.asList(1, 1), "downRight");
    }

    private void readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        this.puzzle = new char[lines.get(0).length()][];
        for (int i = 0; i < lines.get(0).length(); i++) {
            puzzle[i] = lines.get(i).toCharArray(); // Convert each line to char array
        }

        for (int i = lines.get(0).length(); i < lines.size(); i++) {
            String[] lineWords = lines.get(i).split( "[\\s,;]+" );
            this.words.addAll(Arrays.stream(lineWords).toList());
        }

    }

    private boolean checkIfWordInDirectionVector(int[] currentPosition, int[] direction, String word) {
        if (word.equals(""))
            return true;

        currentPosition[0] = currentPosition[0] + direction[0];
        currentPosition[1] = currentPosition[1] + direction[1];

        if (isNextPositionInValidRange(currentPosition) && puzzle[currentPosition[0]][currentPosition[1]] == Character.toUpperCase(word.charAt(0)))
            return checkIfWordInDirectionVector(currentPosition, direction, word.substring(1));

        return false;
    }

    private boolean isNextPositionInValidRange(int[] position) {
        return !(position[0] < 0 || position[1] < 0 || position[0] >= puzzle.length || position[1] >= puzzle.length);
    }

    private void solve() {
        int cnt = 0;
        for(String word : this.words) {
            boolean found = false;
            for(int i = 0; !found && i < puzzle.length; i++) {

                for(int j = 0; !found && j < puzzle.length; j++) {
                    //System.out.println(puzzle[i][j]);
                    if (puzzle[i][j] == Character.toUpperCase((word.charAt(0)))) {
                        for(int[] direction : this.directions) {
                            found = checkIfWordInDirectionVector(new int[]{i, j}, direction, word.substring(1));
                            if (found) {
                                foundPositions[cnt] = new int[]{i+1, j+1};
                                foundDirections[cnt] = direction;
                            }
                        }
                    }
                }
            }

            cnt++;
        }
    }

    public void printSolution() throws FileNotFoundException {
        this.solve();

        StringBuilder rows = new StringBuilder();
        int cnt = 0;

        for(String word : this.words) {
            rows.append(word)
                    .append(" ")
                    .append(word.length())
                    .append(" ")
                    .append(foundPositions[cnt][0])
                    .append(".")
                    .append(foundPositions[cnt][1])
                    .append(" ")
                    .append(directionNames.get(Arrays.asList(foundDirections[cnt][0], foundDirections[cnt][1])))
                    .append("\n");
            cnt++;
        }

        try (PrintWriter out = new PrintWriter(this.filePath.substring(0, this.filePath.length() - 4) + "_result.txt")) {
            out.println(rows);
        }

        System.out.println(rows);
    }

    public static void main(String[] args) throws IOException {
        String input_file = args[0];
        WordSearchSolver wordSearchSolver = new WordSearchSolver(input_file);
        wordSearchSolver.printSolution();
    }
}





