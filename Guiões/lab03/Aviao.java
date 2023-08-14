package lab03;
public class Aviao {
    String nome, string_executiva, string_turistica;
    int fila_executiva,fila_turistica,lugar_fila_executiva,lugar_fila_turistica;
    int codigo_reserva = 1;
    int [][] matriz_executiva,matriz_turistica;
    public Aviao(){}

    public Aviao(String nome, String string_executiva, String string_turistica) {
        setNome(nome);
        setFila_executiva(string_executiva);
        setLugar_fila_executiva(string_executiva);
        setFila_turistica(string_turistica);
        setLugar_fila_turistica(string_turistica);
        setMatriz_executiva();
        setMatriz_turistica();
    }

    public String getNome() {
        return this.nome;
    }
    
    public int getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(int codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFila_executiva(String string_executiva) {
        String[] executiva = string_executiva.split("x");
        int fila = Integer.parseInt(executiva[0]);
        this.fila_executiva = fila;
    }
    public void setLugar_fila_executiva(String string_executiva) {
        String[] executiva = string_executiva.split("x");
        int lugar = Integer.parseInt(executiva[1]);
        this.lugar_fila_executiva = lugar;
    }

    public void setFila_turistica(String string_turistica) {
        String[] turistica = string_turistica.split("x");
        int fila = Integer.parseInt(turistica[0]);
        this.fila_turistica = fila;
    }
    public void setLugar_fila_turistica(String string_turistica) {
        String[] turistica = string_turistica.split("x");
        int lugar = Integer.parseInt(turistica[1]);
        this.lugar_fila_turistica = lugar;
    }
    

    public void setMatriz_executiva() {
        int [][] matriz = new int [this.lugar_fila_executiva][this.fila_executiva];
        this.matriz_executiva = matriz;
    }

    public int[][] getMatriz_executiva() {
        return matriz_executiva;
    }

    public void setMatriz_turistica() {
        int [][] matriz = new int [this.lugar_fila_turistica][this.fila_turistica];
        this.matriz_turistica = matriz;
    }

    public int[][] getMatriz_turistica() {
        return matriz_turistica;
    }

    public int getFila_executiva() {
        return this.fila_executiva;
    }
    public int getFila_turistica() {
        return this.fila_turistica;
    }
    public int getLugar_fila_executiva() {
        return this.lugar_fila_executiva;
    }
    public int getLugar_fila_turistica() {
        return this.lugar_fila_turistica;
    }

    public int how_many_seats_free_t(){
        int count = 0;
        for (int[] seat_line : matriz_turistica) {
            for (int i : seat_line) {    
                if (i == 0){
                    count++;}
            }   
            }
        
        return count;
    }

    public int how_many_seats_free_e(){
        int count = 0;
        for (int[] seat_line : matriz_executiva) {
            for (int i : seat_line) {    
                if (i == 0){
                    count++;}
            }   
        }
    
    return count;
    }
}