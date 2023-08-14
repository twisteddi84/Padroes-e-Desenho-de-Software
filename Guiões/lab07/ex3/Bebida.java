
public class Bebida extends Produto {

    private String nome;
    private int peso;

    Bebida(String nome , int peso){
        super(nome, peso);
        this.nome = nome;
        this.peso = peso;
    }

    public void draw() {
        System.out.println( "Bebida '" + getNome() + "' - Weight : " + getPeso());
    }
}
