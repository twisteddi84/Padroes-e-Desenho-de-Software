import java.io.*;
import java.util.*;

public class WSGenerator {
    private final char[][] grid;
    private List<String> words;

    public WSGenerator(String wordsFilePath, int dimension, String puzzleFilePath) {
        words = readWordsFromFile(wordsFilePath);
        grid = new char[dimension][dimension];
        fillGrid();
        writePuzzleToFile(wordsFilePath, puzzleFilePath);
    }

    private List<String> readWordsFromFile(String filePath) {
        this.words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.contains(";")) {
                    
                    String[] wordList = line.split(";");
                    for (String word : wordList) {
                        this.words.add(word.toUpperCase());
                    }
                } else {
                    
                    this.words.add(line.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private void fillGrid() {
        Random random = new Random();
        for (String word : words) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(grid.length);
                int y = random.nextInt(grid[0].length);
                int dx = random.nextInt(3) - 1;
                int dy = random.nextInt(3) - 1;
                if (dx == 0 && dy == 0) {
                    continue;
                }
                if (canPlaceWord(word, x, y, dx, dy)) {
                	
                    for (int i = 0; i < word.length(); i++) {
                        grid[x][y] = word.charAt(i);
                        x += dx;
                        y += dy;
                    }
                    placed = true;
                }
            }
        }
     
        Random random1 = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '\0') {
                    grid[i][j] = (char) (random1.nextInt(26) + 'A');
                }
            }
        }
    }

    private boolean canPlaceWord(String word, int x, int y, int dx, int dy) {
        int wordLength = word.length();
        int endX = x + dx * (wordLength - 1);
        int endY = y + dy * (wordLength - 1);
        if (endX < 0 || endX >= grid.length || endY < 0 || endY >= grid[0].length) {
            return false;
        }
        for (int i = 0; i < wordLength; i++) {
            if (grid[x][y] != '\0' && grid[x][y] != word.charAt(i)) {
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }

    private void writePuzzleToFile(String inputfilePath, String outputfilePath) {
    	boolean flag = false;
    	try {
            File file = new File(inputfilePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(";")) {
                    flag = true;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Greška pri čitanju datoteke");
            e.printStackTrace();
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputfilePath))) {

            for (char[] chars : grid) {
                for (char aChar : chars) {
                    writer.write(aChar);
                }
                writer.newLine();
            }
            if (!flag) {
            	
	            for (String word : words) {
	                writer.write(word);
	                writer.newLine();
	            }
	            
            } else {
            	boolean firstWord = true;
                for (String word : words) {
                    if (!firstWord) {
                        writer.write(";");
                    }
                    writer.write(word);
                    firstWord = false;
                }
                writer.newLine();
            }
	            
	        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   

    public static void main(String[] args) {
    	String inputFile = null;
        String outputFile = null;
        int puzzleSize = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i" -> inputFile = args[i + 1];
                case "-o" -> outputFile = args[i + 1];
                case "-s" -> puzzleSize = Integer.parseInt(args[i + 1]);
            }
        }

        if (inputFile == null || outputFile == null || puzzleSize == 0) {
            System.err.println("Invalid input arguments!");
            return;
        }

        WSGenerator puzzle = new WSGenerator(inputFile, puzzleSize, outputFile);
    }
}

