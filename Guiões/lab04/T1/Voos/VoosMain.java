// Author: Rafael Pinto, 103379, p5_09

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VoosMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Usage: java VoosMain [filename]");
            return;
        }
        List<Voo> voos = new ArrayList<Voo>();
        if (args.length == 1){
            List<String> comandos = FileUtils.readFile(args[0]);
            for(String comando : comandos){
                menu(comando, voos);
            }
        } else {
            while(true){
                System.out.println("Escolha uma opcao: (H para ajuda)");
                String comando = sc.nextLine();
                menu(comando, voos);
            }
        }   
    }

    private static void menu(String comando, List<Voo> voos) {
        char tipo = Character.toUpperCase(comando.charAt(0));
        String[] comando_decode;
        String flight_code;
        Voo voo;
        int n_filas_executivo, n_filas_turista, n_lugares_por_fila_executivo, n_lugares_por_fila_turista;
        switch(tipo){
            case 'H':   // apresenta as opções do menu
                System.out.println("H - Ajuda");
                System.out.println("I <filename> - Ler ficheiro com informação sobre um voo");
                System.out.println("M <flight_code> - Mostrar o voo de um dado código");
                System.out.println("F <flight_code> <num_seats_executive> <num_seats_tourist> - Acrescenta um novo voo");
                System.out.println("R <flight_code> <class> <number_seats> - Faz uma reserva");
                System.out.println("C <reservation_code> - Cancela uma reserva");
                break;
            case 'I':   // lê ficheiro com informação sobre um voo
                comando_decode = comando.split(" ");
                if(comando_decode.length != 2){
                    System.out.println("Usage: I <filename>");
                    break;
                }

                String filename = comando_decode[1];
                List<String> lines = new ArrayList<String>();
                lines = FileUtils.readFile(filename);

                if(!validateFile(lines)){
                    System.out.println("Ficheiro inválido");
                    break;
                }

                String first_line = lines.get(0);
                flight_code = getFlightCode(first_line);
                n_filas_executivo = getFilasExecutivo(first_line);
                n_filas_turista = getFilasTurista(first_line);
                n_lugares_por_fila_executivo = getLugaresPorFilaExecutivo(first_line);
                n_lugares_por_fila_turista = getLugaresPorFilaTurista(first_line);
            
                Aviao aviao = new Aviao(n_filas_turista, n_lugares_por_fila_turista, n_filas_executivo, n_lugares_por_fila_executivo);
                voo = new Voo(flight_code, aviao);

                lines.remove(0);
                for(String line : lines){
                    String[] aux = line.split(" ");
                    String classe = aux[0];
                    int n_passageiros = Integer.parseInt(aux[1]);
                    new Reserva(voo, classe.charAt(0), n_passageiros);
                }
                printOptionI(voo);
                break;
            case 'M':   // mostra o voo de um dado código
                comando_decode = comando.split(" ");
                if(comando_decode.length != 2){
                    System.out.println("Usage: M <flight_code>");
                    break;
                }
                flight_code = comando_decode[1];
                for(Voo v : voos){
                    if(v.getCodigo().equals(flight_code)){
                        System.out.println(v);
                        break;
                    }
                }
                break;
            case 'F':   // acrescenta um novo voo
                comando_decode = comando.split(" ");
                if(comando_decode.length <= 3){
                    System.out.println("Usage: F <flight_code> [<num_seats_executive>] <num_seats_tourist>");
                    break;
                }
                flight_code = comando_decode[1];
                if (comando_decode.length == 4) {
                    String[] executive_seats = comando_decode[2].split("x");
                    String[] tourist_seats = comando_decode[3].split("x");
                    n_filas_executivo = Integer.parseInt(executive_seats[0]);
                    n_lugares_por_fila_executivo = Integer.parseInt(executive_seats[1]);
                    n_filas_turista = Integer.parseInt(tourist_seats[0]);
                    n_lugares_por_fila_turista = Integer.parseInt(tourist_seats[1]);
                } else {
                    String[] tourist_seats = comando_decode[2].split("x");
                    n_filas_executivo = 0;
                    n_lugares_por_fila_executivo = 0;
                    n_filas_turista = Integer.parseInt(tourist_seats[0]);
                    n_lugares_por_fila_turista = Integer.parseInt(tourist_seats[1]);
                }
                Aviao a = new Aviao(n_filas_turista, n_lugares_por_fila_turista, n_filas_executivo, n_lugares_por_fila_executivo);
                voo = new Voo(flight_code, a);
                voos.add(voo);
                break;
            case 'R':   // faz uma reserva
                comando_decode = comando.split(" ");
                if(comando_decode.length != 4){
                    System.out.println("Usage: R <flight_code> <class> <number_seats>");
                    break;
                }
                flight_code = comando_decode[1];
                char classe = comando_decode[2].charAt(0);
                int n_passageiros = Integer.parseInt(comando_decode[3]);
                Reserva nova_reserva = null;
                for(Voo v : voos){
                    if(v.getCodigo().equals(flight_code)){
                        nova_reserva = new Reserva(v, classe, n_passageiros);
                        break;
                    }
                }
                System.out.println(nova_reserva);
                break;
            case 'C':   // cancela uma reserva
                comando_decode = comando.split(" ");
                if(comando_decode.length != 2){
                    System.out.println("Usage: C <reservation_code>");
                    break;
                }
                String rc = comando_decode[1];
                for(Voo v : voos){
                    for(Reserva r : v.getReservasAtivas()){
                        if(r.getCodigo().equals(rc)){
                            r.cancelarReserva();
                            break;
                        }
                    }
                }
                break;
            case 'Q':   // termina o programa
                System.exit(0);
                break;
            default:
                System.out.println("Comando inválido");
                break;
        }
    }

    private static int getLugaresPorFilaTurista(String first_line) {
        String[] aux = first_line.split(" ");
        if(aux.length != 3) {
            aux = aux[1].split("x");
            return Integer.parseInt(aux[1]);
        } else {
            aux = aux[2].split("x");
            return Integer.parseInt(aux[1]);
        }
        
    }

    private static int getLugaresPorFilaExecutivo(String first_line) {
        String[] aux = first_line.split(" ");
        if(aux.length != 3) {
            return 0;
        } else {
            aux = aux[1].split("x");
            return Integer.parseInt(aux[1]);
        }
    }

    private static int getFilasTurista(String first_line) {
        String aux[] = first_line.split(" ");
        if (aux.length != 3) {
            aux = aux[1].split("x");
            return Integer.parseInt(aux[0]);
        } else {
            aux = aux[2].split("x");
            return Integer.parseInt(aux[0]);
        }
    }

    private static int getFilasExecutivo(String first_line) {
        String[] aux = first_line.split(" ");
        if(aux.length != 3) {
            return 0;
        } else {
            aux = aux[1].split("x");
            return Integer.parseInt(aux[0]);
        }
    }

    private static String getFlightCode(String first_line) {
        String[] aux = first_line.split(" ");
        return aux[0].substring(1);
    }

    private static boolean validateFile(List<String> lines) {
        return true;
    }

    private static void printOptionI(Voo voo) {
        if(voo.getAviao().getN_filas_executivo() > 0){
            System.out.printf("Codigo de voo %s. Lugares disponiveis: %d em classe Executiva; %d lugares em classe Turistica.\n", voo.getCodigo(), voo.getAviao().getTotal_Lugares_Executivo(), voo.getAviao().getTotal_Lugares_Turista());
        } else {
            System.out.printf("Codigo de voo %s. Lugares disponiveis: %d em classe lugares Turistica.\n", voo.getCodigo(), voo.getAviao().getTotal_Lugares_Turista());
            System.out.println("Classe executiva nao disponivel neste voo.");
        }
        List<Reserva> reservas_invalidas = new ArrayList<Reserva>();
        for(int i=0; i < voo.getTodasReservas().size(); i++){
            if(!voo.getTodasReservas().get(i).isAtiva()){
                reservas_invalidas.add(voo.getTodasReservas().get(i));
            }
        }
        if(reservas_invalidas.size() > 0){
            System.out.print("Nao foi possivel obter lugares para a reserva: ");
            for(Reserva reserva : reservas_invalidas){
                if(reserva.getClasseLugar() == ClasseLugar.TURISTA){
                    System.out.printf("T %d", reserva.getN_passageiros());
                } else {
                    System.out.printf("E %d", reserva.getN_passageiros());
                }
            }
        }
        System.out.println();
    }
}
