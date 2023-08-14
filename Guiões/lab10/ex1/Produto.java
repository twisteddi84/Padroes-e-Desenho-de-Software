import java.util.ArrayList;
import java.util.List;
class Produto implements Subject {
    private static int contadorCodigo = 0;
    private int codigo;
    private String descricao;
    private double precoBase;
    private Estado estado;
    private long tempoMaximoLeilao;
    private List<Observer> observers;

    public Produto(String descricao, double precoBase) {
        this.codigo = ++contadorCodigo;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.estado = Estado.STOCK;
        this.observers = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public Estado getEstado() {
        return estado;
    }

    public long getTempoMaximoLeilao() {
        return tempoMaximoLeilao;
    }

    public void setTempoMaximoLeilao(long tempoMaximoLeilao) {
        this.tempoMaximoLeilao = tempoMaximoLeilao;
    }

    public void passarParaLeilao(long tempoMaximoLeilao) {
        this.estado = Estado.LEILAO;
        this.tempoMaximoLeilao = tempoMaximoLeilao;
    }

    public void reporNoStock() {
        this.estado = Estado.STOCK;
    }

    public void vender() {
        this.estado = Estado.VENDAS;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Produto produto, double novoValor) {
        for (Observer observer : observers) {
            observer.update(produto, novoValor);
        }
    }

    @Override
    public void notifyVendaObservers(Produto produto) {
        for (Observer observer : observers) {
            observer.vendaRealizada(produto);
        }
    }
}
