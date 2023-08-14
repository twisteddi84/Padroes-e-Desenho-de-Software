
public abstract class Produto{
    private String nome;
    private int peso;

    Produto (String name , int weight){
        this.nome = name;
        this.peso = weight;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    
    public abstract void draw(); 
}
