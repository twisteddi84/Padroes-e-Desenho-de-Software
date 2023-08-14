package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class WSGenerator {
    @SuppressWarnings("unchecked")
    public static void main(String[] args)throws IOException {
        WSGenerator generator = new WSGenerator();      

        generator.validacaoArg(args);

        List <String> lista_palavras = generator.make_lista(args);
        int size = generator.size(args);
        char sopa_de_letras_inicial [][] = new char [size][size];
        for(int linha = 0;linha<size;linha++){
            for(int coluna = 0;coluna<size;coluna++){
                sopa_de_letras_inicial[linha][coluna] = '.';
            }
        }

        int size_max_word = generator.size_max_word(lista_palavras);
        if(size_max_word>size){
            System.out.println("Impossivel, existe palavra maior que o tamanho pedido.");
            System.exit(1);
        }

        //Escolher uma posição random da sopa de letras
        int[] random_position = new int[2];
        
        //Ordenar lista de palavras por ordem decrescente do tamanho
        lista_palavras.sort(Comparator.comparingInt(String::length));
        Collections.reverse(lista_palavras);

        //Escolher uma orientação random
        int[] UP = {-1,0};
        int[] DOWN = {1,0};
        int[] RIGHT = {0,1};
        int[] LEFT = {0,-1};
        int[] UpRight = {-1,1};
        int[] UpLeft = {-1,-1};
        int[] DownRight = {1,1};
        int[] DownLeft = {1,-1};
        List<int[]> possible_orientation = Arrays.asList(UP,DOWN,RIGHT,LEFT,UpRight,UpLeft,DownRight,DownLeft);
        generator.random_orientation(possible_orientation);
        int[] random_orientation = new int[2];

        for (String word : lista_palavras) {
            random_position = generator.random_position(size);
            random_orientation = generator.random_orientation(possible_orientation);
            int count = 0;
            while(generator.checkIfRandomsArePossible(sopa_de_letras_inicial, word, random_orientation, random_position, size)==false){
                if (count == 1000){
                    System.out.println("Impossivel, não existe espaço para todas as palavras.");
                    System.exit(1);
                }               
                random_position = generator.random_position(size);
                random_orientation = generator.random_orientation(possible_orientation);
                count++;
            }
            int index_1 = random_position[0];
            int index_2 = random_position[1];
            sopa_de_letras_inicial[index_1][index_2] = word.charAt(0);
            for(int letra_index=1;letra_index<word.length();letra_index++){
                index_1 = index_1 + random_orientation[0];
                index_2 = index_2 + random_orientation[1];
                sopa_de_letras_inicial[index_1][index_2] = word.charAt(letra_index);
            }
        }
        

        System.out.println("");

        Random r = new Random();

        for(int linha = 0;linha<size;linha++){
            for(int coluna = 0;coluna<size;coluna++){
                if(sopa_de_letras_inicial[linha][coluna]=='.'){
                    char c = (char)(r.nextInt(26) + 'A');
                    sopa_de_letras_inicial[linha][coluna] = c;
                }
            }
        }
        if(args.length == 6){
            FileWriter file_resultado = new FileWriter(args[5]);
            PrintWriter file_resultado_print = new PrintWriter(file_resultado);
            printResultado(size, sopa_de_letras_inicial,file_resultado_print,lista_palavras);
            file_resultado_print.close();
            file_resultado.close();
        }else{
            List<String> nome_ficheiro = Arrays.asList(args[1].split("[.]"));
            FileWriter file_resultado = new FileWriter(nome_ficheiro.get(0)+"_result.txt");
            PrintWriter file_resultado_print = new PrintWriter(file_resultado);
            printResultado(size, sopa_de_letras_inicial,file_resultado_print,lista_palavras);
            
            file_resultado.close();
            file_resultado_print.close();
        }
    
    }

    public static void printResultado(int tamanho_matriz,char sopa_de_letras_resultado[][],PrintWriter file_resultado,List<String> lista_palavras) {
        for (int linha = 0;linha<tamanho_matriz;linha++){
            for(int coluna = 0;coluna<tamanho_matriz;coluna++){
                System.out.printf("%3c",sopa_de_letras_resultado[linha][coluna]);
                file_resultado.printf("%c",sopa_de_letras_resultado[linha][coluna]);
            }
            System.out.printf("%n");
            file_resultado.printf("%n");
        }
        for (String word : lista_palavras) {
            file_resultado.printf("%s,",word.toLowerCase());
        }
    }

    private void validacaoArg(String[] args){
        if (args.length == 4 || args.length == 6){
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i] == "-s" && (i == 0 || i == 2)){
                    if ((args[i + 1]).matches(".*\\.txt")){
                        String txtname = args[i + 1];
                        System.out.println(txtname);     
                    }
                    else{
                        System.err.println("MISSUSED ARGUMENTS");
                    }
                }
                else if (args[i] == "-o" && (i == 4)){
                    if ((args[i + 1]).matches(".*\\.txt")){
                        String maketxtname = args[i + 1];
                        System.out.println(maketxtname);
                    }
                    else{
                        System.err.println("MISSUSED ARGUMENTS");
                    } 
                }
                else if(args[i] == "-i" && (i == 0 || i == 2)){
                    if (args[i+1].matches("^[0-9]")){
                        int size = Integer.parseInt(args[i+1]);
                        System.out.println(size);
                    }
                    else{
                        System.err.println("MISSUSED ARGUMENTS");
                    }
                }
            }
            
        }
        else{
            System.err.println("The correct amount of passed arguments!");
            System.exit(1);
        }
    }

    public boolean checkIfRandomsArePossible(char[][]sopa_de_letras,String word,int[] random_orientation, int[] random_position, int size) {
        int word_size = word.length();
        char letra_inicial = word.charAt(0);
        int index_1 = random_position[0];
        int index_2 = random_position[1];

        if(checkIfWordIsOut(index_1, index_2, size) && (sopa_de_letras[index_1][index_2] == '.' || sopa_de_letras[index_1][index_2] == letra_inicial)){
            for(int letra_index = 1;letra_index<word_size;letra_index++){
                index_1 = index_1 + random_orientation[0];
                index_2 = index_2 + random_orientation[1];
                if(checkIfWordIsOut(index_1, index_2, size) && (sopa_de_letras[index_1][index_2] == '.' || sopa_de_letras[index_1][index_2] == word.charAt(letra_index))){
                    continue;
                }else{
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean checkIfWordIsOut(int index_1,int index_2,int size) {
        if(index_1>=size || index_2 >=size || index_1<0 || index_2<0){
            return false;
        }
        return true;
    }

    public static void menu_opcoes() {
        System.out.printf("---------Word Search Generator---------%n");
        System.out.printf("-i : Give the file with the words-----Obrigatory%n");
        System.out.printf("-s : Size of the word search----------Obrigatory%n");
        System.out.printf("-o : File to save the result----------Opcional%n");
        System.out.println("");
        System.out.println("");
    }
    
    private int[] random_orientation(List<int[]> pos_orientation){
        Random rand = new Random();
        int[] orientation = pos_orientation.get(rand.nextInt(pos_orientation.size()));


        return orientation;
    }

    private int[] random_position(int size){
        Random rand = new Random();
        int[] random_position = {rand.nextInt(size),rand.nextInt(size)};
        return random_position;
    }

    private int size_max_word(List<String> words){
        int size = 0;
        for (String word : words) {
            if(word.length()>size){
                size = word.length();
            }
        }
        return size;
    }

    private List make_lista(String[] args)throws IOException {
        List<String> lista_palavras = new ArrayList<>();
        File file = new File(args[1]);
        try (Scanner sc = new Scanner(file)) {
            while(sc.hasNextLine()){
                String palavras = sc.nextLine();
                String[] strSplit = palavras.split("[\\s,;]+");
                for (String string : strSplit) {
                    lista_palavras.add(string.toUpperCase());;
                }           
            }
        }
        return lista_palavras;
    }

    private int size(String[] args){
        int size = 0;
        size = Integer.parseInt(args[3]);
        return size;
    }
}
