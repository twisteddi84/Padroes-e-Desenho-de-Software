public class Telemovel {
    private String processador;
    private int preco;
    private int memoria;
    private String camara;

    public Telemovel(String processador, int preco, int memoria, String camara) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }

    public String getProcessador() {
        return processador;
    }

    public int getPreco() {
        return preco;
    }

    public int getMemoria() {
        return memoria;
    }

    public String getCamara() {
        return camara;
    }

    @Override
    public String toString() {
        return "Telemovel{" + "processador=" + processador + ", preco=" + preco + ", memoria=" + memoria + ", camara=" + camara + '}';
    }
}
