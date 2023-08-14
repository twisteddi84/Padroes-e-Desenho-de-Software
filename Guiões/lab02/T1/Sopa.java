package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sopa {

    private final char[][] puzzle;
    private final List<String> words;
    private final int size;
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 },
            { 1, -1 } };

    public Sopa(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner1 = new Scanner(file);
        Scanner scanner2 = new Scanner(file);
        puzzle = readPuzzle(scanner1);
        words = readWords(scanner2);
        size = puzzle.length;
        scanner1.close();
        scanner2.close();
    }

    private char[][] readPuzzle(Scanner scanner) {
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim().toUpperCase();
            if (!line.isEmpty()) {
                lines.add(line);
            }
        }
        int n = lines.size() - 1;

        char[][] puzzle = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = lines.get(i);

            for (int j = 0; j < n; j++) {
                puzzle[i][j] = line.charAt(j);
            }
        }
        return puzzle;
    }

    private List<String> readWords(Scanner scanner) {
        List<String> words = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(";") || line.contains(",") || line.contains(" ")) {
                System.out.println(line);
                line = line.trim().toUpperCase();
                if (!line.isEmpty()) {
                    String[] tokens = line.split("[,;\\s]+");
                    for (String token : tokens) {
                        if (token.length() >= 3) {
                            words.add(token);
                        }
                    }
                }
            }
        }

        return words;
    }

    public List<String> solve() {
        List<String> results = new ArrayList<>();
        for (String word : words) {
            String found = findWord(word);
            if (found != null) {
                results.add(found);
            }
        }
        return results;
    }

    private String findWord(String word) {
        int n = size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (puzzle[i][j] == word.charAt(0)) {
                    for (int[] dir : directions) {
                        int x = i;
                        int y = j;
                        int k;
                        for (k = 1; k < word.length(); k++) {
                            x += dir[0];
                            y += dir[1];
                            if (x < 0 || x >= n || y < 0 || y >= n || puzzle[x][y] != word.charAt(k)) {
                                break;
                            }
                        }
                        if (k == word.length()) {
                            return word + " " + (i + 1) + " " + (j + 1);
                        }
                    }
                }
            }
        }
        return null;
    }
}
