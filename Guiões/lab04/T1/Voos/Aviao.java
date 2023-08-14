// Author: Rafael Pinto, 103379, p5_09

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aviao {
    private int n_filas_executivo;
    private int n_filas_turista;
    private int n_lugares_por_fila_executivo;
    private int n_lugares_por_fila_turista;
    private List<Map<String, Integer>> lugares_turista_livres = new ArrayList<Map<String, Integer>>();
    private List<Map<String, Integer>> lugares_executivo_livres = new ArrayList<Map<String, Integer>>();
    private List<Map<String, Integer>> lugares_ocupados = new ArrayList<Map<String, Integer>>();
    
    public Aviao(int n_filas_turista, int n_lugares_por_fila_turista) {
        this.n_filas_turista = n_filas_turista;
        this.n_lugares_por_fila_turista = n_lugares_por_fila_turista;
        this.n_filas_executivo = 0;
        this.n_lugares_por_fila_executivo = 0;
        inicializarLugares();
    }

    public Aviao(int n_filas_turista, int n_lugares_por_fila_turista, int n_filas_executivo, int n_lugares_por_fila_executivo) {
        this.n_filas_turista = n_filas_turista;
        this.n_lugares_por_fila_turista = n_lugares_por_fila_turista;
        this.n_filas_executivo = n_filas_executivo;
        this.n_lugares_por_fila_executivo = n_lugares_por_fila_executivo;
        inicializarLugares();
    }

    private void inicializarLugares() {
        int n_filas = this.n_filas_turista + this.n_filas_executivo;
        for(int i = 0; i < n_filas; i++){
            if(i < this.n_filas_executivo){
                for(int j = 0; j < this.n_filas_executivo; j++){
                    Map<String, Integer> lugar = new HashMap<String, Integer>();
                    lugar.put("fila", i);
                    lugar.put("coluna", j);
                    lugares_executivo_livres.add(lugar);
                }
            } else {
                for(int j = 0; j < this.n_filas_turista; j++){
                    Map<String, Integer> lugar = new HashMap<String, Integer>();
                    lugar.put("fila", i);
                    lugar.put("coluna", j);
                    lugares_turista_livres.add(lugar);
                }
            }
        }
    }

    public int getTotal_Lugares_Executivo(){
        return this.n_filas_executivo * this.n_lugares_por_fila_executivo;
    }

    public int getTotal_Lugares_Turista(){
        return this.n_filas_turista * this.n_lugares_por_fila_turista;
    }

    public int getN_filas_executivo() {
        return n_filas_executivo;
    }

    public int getN_filas_turista() {
        return n_filas_turista;
    }

    public int getN_lugares_por_fila_executivo() {
        return n_lugares_por_fila_executivo;
    }

    public int getN_lugares_por_fila_turista() {
        return n_lugares_por_fila_turista;
    }

    public List<Map<String, Integer>> getLugaresOcupados() {
        return lugares_ocupados;
    }

    public boolean verificarDisponibilidade(int n_passageiros, ClasseLugar classeLugar) {
        if(classeLugar == ClasseLugar.TURISTA){
            return n_passageiros <= lugares_turista_livres.size();
        } else {
            return n_passageiros <= lugares_executivo_livres.size();
        }
    }

    public List<Map<String, Integer>> reservarLugaresTurista(int n_passageiros) {
        assert n_passageiros <= lugares_turista_livres.size(): "Não há lugares disponíveis na classe turista";
        List<Map<String, Integer>> lugares = new ArrayList<Map<String, Integer>>();
        for(int i = 0; i < n_passageiros; i++){
            lugares.add(lugares_turista_livres.get(i));
            lugares_ocupados.add(lugares_turista_livres.get(i));
            lugares_turista_livres.remove(i);
        }
        return lugares;
    }

    public List<Map<String, Integer>> reservarLugaresExecutivo(int n_passageiros) {
        assert n_passageiros <= lugares_executivo_livres.size(): "Não há lugares disponíveis na classe executiva";
        List<Map<String, Integer>> lugares = new ArrayList<Map<String, Integer>>();
        for(int i = 0; i < n_passageiros; i++){
            lugares.add(lugares_executivo_livres.get(i));
            lugares_ocupados.add(lugares_executivo_livres.get(i));
            lugares_executivo_livres.remove(i);
        }
        return lugares;
    }

    public void cancelarReserva(Reserva reserva) {
        List<Map<String, Integer>> lugares = reserva.getLugares();
        Map<String, Integer> lugar = new HashMap<String, Integer>();
        for(int i = 0; i < reserva.getN_passageiros(); i++){
            lugar = lugares.get(i);
            if(reserva.getClasseLugar() == ClasseLugar.TURISTA){
                lugares_turista_livres.add(0, lugar);
            } else {
                lugares_executivo_livres.add(0, lugar);
            }
            lugares_ocupados.remove(lugar);
        }
    }

}
