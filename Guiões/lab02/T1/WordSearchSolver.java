package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WordSearchSolver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Pede o caminho para o arquivo de entrada
        System.out.print("Digite o caminho para o arquivo de entrada: ");
        String inputFilePath = scanner.nextLine();

        // Cria um objeto da classe SoupSolver e passa o caminho do arquivo de entrada
        Sopa solver = new Sopa(inputFilePath);

        // Resolve a sopa de letras
        List<String> foundWords = solver.solve();

        // Imprime as palavras encontradas
        System.out.println("Palavras encontradas:");
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}
