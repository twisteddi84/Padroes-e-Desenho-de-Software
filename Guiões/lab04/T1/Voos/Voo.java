// Author: Rafael Pinto, 103379, p5_09

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Voo {
    private String codigo;
    private Aviao aviao;
    private List<Reserva> todas_reservas = new ArrayList<Reserva>();
    private List<Reserva> reservas_ativas = new ArrayList<Reserva>();

    public Voo(String codigo, Aviao aviao) {
        this.codigo = codigo;
        this.aviao = aviao;
    }

    public String getCodigo() {
        return codigo;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public List<Reserva> getTodasReservas() {
        return todas_reservas;
    }

    public List<Reserva> getReservasAtivas() {
        return reservas_ativas;
    }

    public String getReservaByLugar(int fila, int coluna) {
        for (Reserva reserva : this.todas_reservas) {
            List<Map<String, Integer>> lugares = reserva.getLugares();
            for (Map<String, Integer> lugar : lugares) {
                if (lugar.get("fila") == fila && lugar.get("coluna") == coluna) {
                    return reserva.getCodigo();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        //array alphabet
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String str = "\t";
        int n_filas = this.aviao.getN_filas_executivo() + this.aviao.getN_filas_turista();
        int n_lugares_fila = Math.max(this.aviao.getN_lugares_por_fila_executivo(), this.aviao.getN_lugares_por_fila_turista());
        for(int i = 0; i < n_filas; i++){
            str += String.format("%d\t", i+1);
        }
        str += "\n";
        List<Map<String, Integer>> lugares_ocupados = this.aviao.getLugaresOcupados();
        for(int i = 0; i < n_lugares_fila; i++){
            str += String.format("%c\t", alphabet[i]);
            for (int j = 0; j < n_filas; j++){
                // se lugar não existe pula
                if(i >= this.aviao.getN_lugares_por_fila_executivo() && j < this.aviao.getN_filas_executivo()) {
                    str += "\t";
                    continue;    
                } else {
                    // se livre 0 senão codigo reserva
                    Map<String, Integer> lugar = new HashMap<String, Integer>();
                    lugar.put("fila", j);
                    lugar.put("coluna", i);
                    String reserva = getReservaByLugar(j, i);
                    if(lugares_ocupados.contains(lugar)) {
                        str += String.format("%s\t", reserva.split(":")[1]);
                    } else {
                        str += String.format("%d\t", 0);
                    }   
                }
            }
            str += "\n";
        }
        return str;
    }
}
