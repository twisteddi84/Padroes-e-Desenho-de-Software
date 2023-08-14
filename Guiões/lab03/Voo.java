package lab03;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Voo {
    public static int fila_vazia = 0; 
    public static int numero_reserva = 1;
    public static void main(String[] args) throws FileNotFoundException{
        List<Aviao> lista_de_avioes = new ArrayList<Aviao>();
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Escolha uma opção: (H para ajuda)");
            System.out.printf(">>");
            String user_input = sc.nextLine();
            List<String> splitted_user_input = Arrays.asList(user_input.split(" "));
            if(splitted_user_input.get(0).charAt(0) == 'I'){
                String file_name = splitted_user_input.get(1).strip();
                Aviao aviao1 = makeAviao(file_name);
                lista_de_avioes.add(aviao1);
                System.out.printf("Código do voo: %s. Lugares disponiveis: %d lugares em Classe Executiva e %d lugares em Classe Turistica.\n",aviao1.getNome(),aviao1.getFila_executiva()*aviao1.getLugar_fila_executiva(),aviao1.getFila_turistica()*aviao1.getLugar_fila_turistica());
                reservas(file_name,aviao1);
                numero_reserva = 1;
            }
            if(splitted_user_input.get(0).charAt(0) == 'Q'){
                break;
            }
            if(splitted_user_input.get(0).charAt(0) == 'H'){
                menu();
            }
            if(splitted_user_input.get(0).charAt(0) == 'M'){
                String file_name = splitted_user_input.get(1).strip();
                for (int i = 0; i < lista_de_avioes.size(); i++) {
                    if (file_name.equals(lista_de_avioes.get(i).getNome())){
                        printLugares(lista_de_avioes.get(i));
                    }
                }
            }
            if(splitted_user_input.get(0).charAt(0) == 'F'){
                String name_of_flight_F = splitted_user_input.get(1).strip();
                String col_and_lin_exe = splitted_user_input.get(2);
                String col_and_lin_tour = splitted_user_input.get(3);
                Aviao temp = new Aviao(name_of_flight_F,col_and_lin_exe,col_and_lin_tour);
                lista_de_avioes.add(temp);
                System.out.printf("Avião Criado: %s\nLugares Executivos: %s\nLugares Turisticos: %s\n" , lista_de_avioes.get(0).getNome(),col_and_lin_exe,col_and_lin_tour);
            }
            if(splitted_user_input.get(0).charAt(0) == 'R'){
                String name_of_flight_R = splitted_user_input.get(1).strip();
                String class_ = splitted_user_input.get(2);
                String number_of_seats_s = splitted_user_input.get(3);
                int number_of_seats = Integer.parseInt(number_of_seats_s);
                for (int i = 0; i < lista_de_avioes.size(); i++){
                    if(name_of_flight_R.equals(lista_de_avioes.get(i).getNome())){
                        if (class_.equalsIgnoreCase("T")){
                            int seats_t = lista_de_avioes.get(i).how_many_seats_free_t();
                            if(number_of_seats >= seats_t){
                               Aviao x = lista_de_avioes.get(i);
                               String[] reservou = reservarT(x,number_of_seats);
                               System.out.println(reservou.toString());
                            }
                            else{
                                System.out.println("Nao dá para fazer a reserva de T" + number_of_seats);
                            }
                        }
                        else{
                            int seats_e = lista_de_avioes.get(i).how_many_seats_free_e();
                            if(number_of_seats >= seats_e){
                               Aviao x = lista_de_avioes.get(i);
                               String[] reservou = reservarE(x,number_of_seats);
                               for (String string : reservou) {
                                
                                    System.out.printf("%s - ",string);
                                
                               }
                            }
                            else{
                                System.out.println("Nao dá para fazer a reserva de T" + number_of_seats);
                            }
                        }  
                        }else{
                            System.out.println("Aviao não existe");
                        }
                        }
                        
                    }
                }
            }
        
    
    public static String[] reservarE(Aviao plane, int bilhetes){
        int[][] mat = plane.getMatriz_executiva();
        String[] lugares = new String[bilhetes];
        int count = 0;
        int count2 = 0;
        int countmat = 0;
        for (int[] is : mat) {
            count2++;
            for (int is2 : is) {
                if (is2 == 0){
                    int ascii = 65 + count;
                    System.out.println(count2 + "/" + count);
                    lugares[countmat] = count2+"/"+count;
                    is2 = plane.getCodigo_reserva();
                    bilhetes--;
                    countmat++;
                }
            }
        }
        return lugares;
    }
    public static String[] reservarT(Aviao plane,int bilhetes){
        int[][] mat = plane.getMatriz_turistica();
        String[] lugares = new String[bilhetes];
        int count = 0;
        int count2 = 0;
        int countmat = 0;
        for (int[] is : mat) {
            count2++;
            for (int is2 : is) {
                if (is2 == 0){
                    int ascii = 65 + count;
                    System.out.println(count2 + "/" + count);
                    lugares[countmat] = count2+"/"+count;
                    is2 = plane.getCodigo_reserva();
                    bilhetes--;
                    countmat++;
                }
            }
        }
        return lugares;
    }

    public static void menu(){
        System.out.println("MENU DE OPÇÕES");
        System.out.println("I Filename --- Lê ficheiro de texto com o voo e reservas");
        System.out.println("M Flight_Code --- Exibe o mapa de lugares do voo");
        System.out.println("F Flight_Code Num_Seats_Executive Num_Seats_Tourist --- Acrescenta um novo voo, e lugares");
        System.out.println("R Flight_Code Class Number_Seats --- Acrescenta uma nova reserva a um voo");
        System.out.println("Q --- Sair do programa");
    }

    public static Aviao makeAviao(String file_name)throws FileNotFoundException{
        File file = new File(file_name);
        Scanner sc2 = new Scanner(file);
        String first_line = sc2.nextLine();
        List<String>first_line_split = Arrays.asList(first_line.split(" "));
        String name_aviao = first_line_split.get(0).strip().replace(">", "");
        String string_executiva;
        String string_turistica;
        if (first_line_split.size()==3){
            string_executiva = first_line_split.get(1).strip();
            string_turistica = first_line_split.get(2).strip(); 
        }else{
            string_executiva = "0x0";
            string_turistica = first_line_split.get(1).strip();
        }
        Aviao av1 = new Aviao(name_aviao,string_executiva,string_turistica);
        sc2.close();
        return av1;   
    }

    public static void reservas(String file_name,Aviao av1) throws FileNotFoundException{
        File file = new File(file_name);
        Scanner sc2 = new Scanner(file);
        sc2.nextLine();
        while(sc2.hasNext()){
            String reserva = sc2.nextLine().replace("\n","");
            if (reserva.startsWith("T")){
                String[] reserva_split = reserva.split(" ");
                int numero_lugares_a_reservar = Integer.parseInt(reserva_split[1]);
                int[][] matriz_turistica = av1.getMatriz_turistica();
                int count_lugares_vazios = 0;
                int total_lugares = av1.getFila_turistica()*av1.getLugar_fila_turistica();
                if(filaVazia(matriz_turistica)){
                    count_lugares_vazios = contarLugarVaziosSeguidos(total_lugares, matriz_turistica, 0, fila_vazia, av1);
                }else{
                    if(encontrarLugaresVazio(matriz_turistica, numero_lugares_a_reservar, total_lugares, av1)){

                    }else{
                        System.out.println("Nao dá para fazer a reserva de T" + numero_lugares_a_reservar);
                    }
                }
                if(numero_lugares_a_reservar <= count_lugares_vazios){
                    int lugar_teste=0;
                    while(numero_lugares_a_reservar>0){
                        matriz_turistica[lugar_teste][fila_vazia] = numero_reserva;
                        lugar_teste++;
                        if(lugar_teste == av1.getLugar_fila_turistica()){
                            lugar_teste = 0;
                            fila_vazia++;
                        }
                        numero_lugares_a_reservar--;
                    }
                    numero_reserva++;
                }

            }else{
                String[] reserva_split = reserva.split(" ");
                int numero_lugares_a_reservar = Integer.parseInt(reserva_split[1]);
                int[][] matriz_executiva = av1.getMatriz_executiva();
                int count_lugares_vazios = 0;
                int total_lugares = av1.getFila_executiva()*av1.getLugar_fila_executiva();
                if(av1.getFila_executiva()!=0 && filaVazia(matriz_executiva)){
                    count_lugares_vazios = contarLugarVaziosSeguidos(total_lugares, matriz_executiva, 0, fila_vazia, av1);
                }else{
                    if(av1.getFila_executiva()!=0 && encontrarLugaresVazio(matriz_executiva, numero_lugares_a_reservar, total_lugares, av1)){

                    }else{
                        System.out.println("Nao dá para fazer a reserva de E" + numero_lugares_a_reservar);
                    }
                }
                if(numero_lugares_a_reservar <= count_lugares_vazios){
                    int lugar_teste=0;
                    while(numero_lugares_a_reservar>0){
                        matriz_executiva[lugar_teste][fila_vazia] = numero_reserva;
                        lugar_teste++;
                        if(lugar_teste == av1.getLugar_fila_executiva()){
                            lugar_teste = 0;
                            fila_vazia++;
                        }
                        numero_lugares_a_reservar--;
                    }
                    numero_reserva++;
                }
            }
        }
        printLugares(av1);
    }

    public static void printLugares(Aviao av1) {
        int[][] matriz_executiva = av1.getMatriz_executiva();
        int[][] matriz_turistica = av1.getMatriz_turistica();
        int numero_total_filas = av1.getFila_executiva()+av1.getFila_turistica();
        int max_lugar=matriz_executiva.length;
        if(matriz_turistica.length>max_lugar){
            max_lugar = matriz_turistica.length;
        }
        System.out.println();
        int a = 65;
        System.out.printf("%5s"," ");
        for(int x = 0;x<numero_total_filas;x++){
            System.out.printf("%5d",x+1);
        }
        System.out.println();
        for(int lugar = 0; lugar<max_lugar;lugar++){
            System.out.printf("%5s",(char)a);
            a++;
            if(lugar<matriz_executiva.length){
                for(int fila = 0;fila<matriz_executiva[0].length;fila++){
                    System.out.printf("%5d",matriz_executiva[lugar][fila]);
                }
            }else if(av1.getFila_executiva()==0){
            }
            else{
                for(int fila = 0;fila<matriz_executiva[0].length;fila++){
                    System.out.printf("%5s"," ");
                }
            }
            for(int fila = 0;fila<matriz_turistica[0].length;fila++){
                System.out.printf("%5d",matriz_turistica[lugar][fila]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean filaVazia(int[][] matriz) {
        int soma = 0;
        for(int fila = 0; fila<matriz[0].length;fila++){
            for (int lugar = 0;lugar<matriz.length;lugar++){
                soma += matriz[lugar][fila];
            }
            if(soma == 0){
                fila_vazia = fila;
                return true;
            }
            soma = 0;
        }
        return false;
    }

    public static boolean encontrarLugaresVazio(int[][] matriz,int numero_lugares_a_reservar,int total_lugares,Aviao av1) {
        int numero_lugares_vazios = 0;
        int soma = 0;
        for(int fila = 0; fila<matriz[0].length;fila++){
            for (int lugar = 0;lugar<matriz.length;lugar++){
                if(matriz[lugar][fila] == 0){
                    numero_lugares_vazios = contarLugarVaziosSeguidos(total_lugares,matriz, lugar, fila,av1);
                    if(numero_lugares_a_reservar <= numero_lugares_vazios){
                        int lugar_teste=lugar;
                        int fila_teste = fila;
                        while(numero_lugares_a_reservar>0){
                            matriz[lugar_teste][fila_teste] = numero_reserva;
                            lugar_teste++;
                            if(lugar_teste == matriz.length){
                                lugar_teste = 0;
                                fila_teste++;
                            }
                            numero_lugares_a_reservar--;
                        }
                        numero_reserva++;
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    public static int contarLugarVaziosSeguidos(int total_lugares, int[][] matriz, int lugar,int fila,Aviao av1) {
        int lugar_teste=lugar;
        int fila_teste = fila;
        int count_lugares_vazios = 0;
        for(int count = 0; count<total_lugares;count++){
            if(matriz[lugar_teste][fila_teste] == 0){
                count_lugares_vazios++;
            }
            else{
                break;
            }
            lugar_teste++;
            if(lugar_teste == matriz.length){
                lugar_teste = 0;
                fila_teste++;
            }
            if(fila_teste == matriz[0].length){
                break;
            }
        }
        return count_lugares_vazios;
    }
}