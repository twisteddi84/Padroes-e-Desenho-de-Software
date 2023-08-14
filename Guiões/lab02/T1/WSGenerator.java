package lab01;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class WSGenerator{

    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<>();
        Map<String,String> arg = new HashMap<>();
        String f = " ";
        int n = 40;
        String fileOut = " ";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                case "-s":
                case "-o":
                    arg.put(args[i], args[i+1]);
                    i++; // próximo argumento
                    break;
                default:
                    break;
            }
        }
        
        f = arg.get("-i");
        fileOut = arg.get("-o");
        n = Integer.parseInt(arg.get("-s"));
        if (n > 40) {
            System.out.println("Tamanho máximo excedido");
            System.exit(0);
        }
       
        try{
           
            Scanner read = new Scanner(new File(f));
            while(read.hasNextLine()){
                String line = read.nextLine();
                String [] init = line.split("\\W+");

                for (int i = 0; i < init.length; i++) {
                    if (init[i].length() >=4) {
                        words.add(init[i]); //adicionar as palavras ao arrayList words
                    }
                }
            }

            //checking redundancy
            ArrayList<String> uniqueWords = new ArrayList<>(words); //lista com apenas palavras únicas
            
            for (int i = 0; i < uniqueWords.size(); i++) {
                for (int j = 0; j < uniqueWords.size(); j++) {
                    if (i!=j && uniqueWords.get(i).contains(uniqueWords.get(j))) { 
                        uniqueWords.remove(j); //elimina palavras que estejam contidas noutras
                    }
                }
            }

            //criação da sopa de letras
            char[][] soup = new char [n][n]; //sopa de tamanho n*n
            for (String word : uniqueWords) {
                boolean wordPlaced = false;
            
                while (!wordPlaced) {
                    int initRow = randNum(0, n-1); //definir posições iniciais
                    int initCol = randNum(0, n-1);
            
                    if (soup[initRow][initCol] != '\0') {
                        continue; // posição inicial já está ocupada
                    }
            
                    int row = 0;
                    int col = 0;
                    while (row == 0 && col == 0) { //escolher para onde a palavra vai ser orientada, row e col não podem ser ambos 0 visto que assim não existe orientação
                        row = randNum(-1, 1);
                        col = randNum(-1, 1);
                    }
            
                    boolean canPlaceWord = true;
                    for (int i = 1; i < word.length(); i++) {
                        int curRow = initRow + i * row;
                        int curCol = initCol + i * col;
                        if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= n ||  soup[curRow][curCol] != '\0') {  //verificação se a palavra cabe dentro da sopa e 
                            canPlaceWord = false;                                                                       //verifica se existe alguma letra na direção da palavra
                            break;
                        }
                    }
            
                    if (canPlaceWord) {
                        for (int i = 0; i < word.length(); i++) {
                            int curRow = initRow + i * row;
                            int curCol = initCol + i * col;
                            soup[curRow][curCol] = Character.toUpperCase(word.charAt(i)); //preenche o espaço disponível com a palavra
                        }
                        wordPlaced = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (soup[i][j] == '\0') {
                        soup[i][j] = randChar(); //preenche espaços vazios com random caracteres
                    }
                }
            }
            read.close();
            File fileout = new File(fileOut);
            FileWriter fw = new FileWriter(fileout);
            for (int i = 0; i < n; i++) {  //loop pelas linhas e colunas
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += soup[i][j];
                }
                fw.write(s+"\n");
            }
            for (String s : uniqueWords) {
                fw.write(s+";");  //imprimir as palavras a procurar
            }
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace(); 
            return;
        }
    }

    private static int randNum(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min)+1) + min;
    }

    private static char randChar(){
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        return alpha.charAt(r.nextInt(alpha.length()));
    }
}

