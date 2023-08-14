package src;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WSSolver{
    public static void main(String[] args) throws IOException {
        if (args.length != 1 ){
            System.err.println("Only a .txt file is needed");
        }
            if (!args[0].matches(".*\\.txt")) {
                System.err.println("Is not a .txt file!");
            }
            File file = new File(args[0]);
        
        try (Scanner sc = new Scanner(file)) {
            int tamanho_matriz = sc.nextLine().length();
            
            char sopa_de_letras[][] = new char [tamanho_matriz][tamanho_matriz];
            
            char sopa_de_letras_resultado[][] = new char [tamanho_matriz][tamanho_matriz]; 

            try(Scanner sc_2 = new Scanner(file)){
                for (int linha = 0; linha<tamanho_matriz;linha++){
                    String linha_sopa = sc_2.nextLine();
                    for(int letra=0;letra<tamanho_matriz;letra++){
                        sopa_de_letras[linha][letra] = linha_sopa.charAt(letra);
                        sopa_de_letras_resultado[linha][letra] = '.';
                    }
                }
            
                List <String> lista_palavras = new ArrayList<>();
            
                while(sc_2.hasNextLine()){
                    String palavras = sc_2.nextLine();
                    String[] strSplit = palavras.split("[\\s,;]+");
                    for (String string : strSplit) {
                        lista_palavras.add(string);;
                    }           
                }
            
                List<String> nome_ficheiro = Arrays.asList(args[0].split("[.]"));

                FileWriter file_resultado = new FileWriter(nome_ficheiro.get(0)+"_result.txt");
                PrintWriter file_resultado_print = new PrintWriter(file_resultado);
            
                file_resultado_print.printf("%-15s %-10s %-13s %s%n","PALAVRA","TAMANHO","COORDENADA","ORIENTAÇÃO");

                System.out.printf("%-15s %-10s %-13s %s%n","PALAVRA","TAMANHO","COORDENADA","ORIENTAÇÃO");
                


            
                for (String palavra : lista_palavras) {
                    findFirstLetter(sopa_de_letras, palavra, tamanho_matriz,sopa_de_letras_resultado,file_resultado_print);
                }
                printResultado(tamanho_matriz, sopa_de_letras_resultado,file_resultado_print);

                file_resultado_print.close();
                file_resultado.close();
            }
        }catch(Exception e){
            System.out.println("Error File");
        }

    }

    public static void findFirstLetter(char sopa_de_letras[][],String palavra,int tamanho_matriz,char sopa_de_letras_resultado[][],PrintWriter file_resultado) {
        char primeira_letra = palavra.charAt(0);
        Orientation UP = new Orientation(-1,0,"UP");
        Orientation DOWN = new Orientation(1,0,"DOWN");
        Orientation RIGHT = new Orientation(0,1,"RIGHT");
        Orientation LEFT = new Orientation(0,-1,"LEFT");
        Orientation UpRight = new Orientation(-1,1,"UpRight");
        Orientation UpLeft = new Orientation(-1,-1,"UpLeft");
        Orientation DownRight = new Orientation(1,1,"DownRight");
        Orientation DownLeft = new Orientation(1,-1,"DownLeft");
        List<Orientation> orientations = Arrays.asList(UP,DOWN,RIGHT,LEFT,UpRight,UpLeft,DownRight,DownLeft);


        System.out.println();
        for (int linha = 0; linha<tamanho_matriz;linha++){
            for (int coluna = 0; coluna<tamanho_matriz;coluna++){
                if(Character.toLowerCase(sopa_de_letras[linha][coluna]) == primeira_letra){
                    //Encontra a primeira letra na sopa de letras
                    findAllPositions(orientations, sopa_de_letras, tamanho_matriz, linha, coluna, palavra, sopa_de_letras_resultado, file_resultado);
                }
            }
        }
    }

    public static void findAllPositions(List<Orientation> orientations, char sopa_de_letras[][], int tamanho_matriz, int linha, int coluna, String palavra, char sopa_de_letras_resultado[][], PrintWriter file_resultado) {
        for (Orientation orientation : orientations) {
            int linha_inicial = linha;
            int coluna_inicial = coluna;
            int tamanho_palavra = palavra.length();
            palavra = palavra.toUpperCase();
            String palavra_teste = "";
            for(int count = 0; count <tamanho_palavra;count++){
                if(coluna>=tamanho_matriz || linha >=tamanho_matriz || coluna<0 || linha<0){
                    break;
                }
                palavra_teste =palavra_teste + sopa_de_letras[linha][coluna];
                if(palavra.equals(palavra_teste)){
                    System.out.printf("%-15s %-10d %-2d,%-10d %s%n",palavra.toLowerCase(),tamanho_palavra,linha_inicial+1,coluna_inicial+1,orientation.getOrientation());
                    file_resultado.printf("%-15s %-10d %-2d,%-10d %s%n",palavra.toLowerCase(),tamanho_palavra,linha_inicial+1,coluna_inicial+1,orientation.getOrientation());
                    colocarResultado(linha_inicial, coluna_inicial, tamanho_palavra, sopa_de_letras_resultado, orientation.getOrientation(), palavra);
                    return;
                }
                linha = linha + orientation.getLinha();
                coluna = coluna + orientation.getColuna();
            }
            linha = linha_inicial;
            coluna = coluna_inicial;
        }
    }

    public static void colocarResultado(int linha,int coluna, int tamanho_palavra,char sopa_de_letras_resultado[][],String orientacao,String palavra) {
        switch(orientacao){
            case "RIGHT":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                coluna++;
            }
            break;
            case "LEFT":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                coluna--;
            }
            break;
            case "UP":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha--;
            }
            break;

            case "DOWN":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha++;
            }
            break;
            case "UpRight":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha--;
                coluna++;
            }
            break;
            case "UpLeft":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha--;
                coluna--;
            }
            break;
            case "DownLeft":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha++;
                coluna--;
            }
            break;
            case "DownRight":
            for(int count=0;count<tamanho_palavra;count++){
                sopa_de_letras_resultado[linha][coluna] = palavra.charAt(count);
                linha++;
                coluna++;
            }
            break;
        }
    }

    public static void printResultado(int tamanho_matriz,char sopa_de_letras_resultado[][],PrintWriter file_resultado) {
        file_resultado.printf("%n");
        for (int linha = 0;linha<tamanho_matriz;linha++){
            for(int coluna = 0;coluna<tamanho_matriz;coluna++){
                System.out.printf("%3c",sopa_de_letras_resultado[linha][coluna]);
                file_resultado.printf("%3c",sopa_de_letras_resultado[linha][coluna]);
            }
            System.out.printf("%n");
            file_resultado.printf("%n");
        }
    }
}