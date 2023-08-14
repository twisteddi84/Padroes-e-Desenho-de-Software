// Author: Rafael Pinto, 103379, p5_09

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigo;
    private static int codigo_counter = 1;
    private Voo voo;
    private ClasseLugar classe_lugar;
    private int n_passageiros;
    private List<Map<String, Integer>> lugares = new ArrayList<Map<String, Integer>>();
    private boolean ativa = false;

    public Reserva(Voo voo, char classe_lugar, int n_passageiros) {
        assert classe_lugar == 'T' || classe_lugar == 'E': "Classe de lugar inválida";
        this.voo = voo;
        this.classe_lugar = classe_lugar == 'T' ? ClasseLugar.TURISTA : ClasseLugar.EXECUTIVO;
        this.codigo = String.format("%s:%d", this.voo.getCodigo(), codigo_counter);
        codigo_counter++;
        this.n_passageiros = n_passageiros;
        reservar();
    }

    public Voo getVoo() {
        return voo;
    }

    public String getCodigo() {
        return codigo;
    }

    public ClasseLugar getClasseLugar() {
        return classe_lugar;
    }

    public List<Map<String, Integer>> getLugares() {
        return lugares;
    }

    public int getN_passageiros() {
        return n_passageiros;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void reservar() {
        if (this.voo.getAviao().verificarDisponibilidade(this.n_passageiros, this.classe_lugar)) {
            if(classe_lugar == ClasseLugar.TURISTA){
                this.lugares = this.voo.getAviao().reservarLugaresTurista(this.n_passageiros);
            } else {
                this.lugares = this.voo.getAviao().reservarLugaresExecutivo(this.n_passageiros);
            }
            this.voo.getReservasAtivas().add(this);
            this.ativa = true;
        } else {
            System.out.println("Não há lugares disponíveis");
        }
        this.voo.getTodasReservas().add(this);
    }

    public void cancelarReserva() {
        this.voo.getAviao().cancelarReserva(this);
        this.voo.getReservasAtivas().remove(this);
        this.ativa = false;
    }

    @Override
    public String toString() {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String str = String.format("%s = ", this.codigo);
        List<Map<String, Integer>> lugares = this.getLugares();
        for (Map<String, Integer> lugar : lugares) {
            str += String.format("%d%c | ", lugar.get("coluna"), alphabet[lugar.get("fila")]);
        }
        return str;
    }
}
