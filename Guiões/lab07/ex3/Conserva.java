
public class Conserva extends Produto {
    private String nome;
    private int peso;

    Conserva(String nome , int peso){
        super(nome, peso);
        this.nome = nome;
        this.peso = peso;
    }

    public void draw() {
        System.out.println("Conserva '" + getNome() + "' - Weight : " + getPeso());
    }
}
