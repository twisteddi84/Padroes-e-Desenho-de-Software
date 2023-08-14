
public class Doce extends Produto {

    private String nome;
    private int peso;

    Doce(String nome , int peso){
        super(nome, peso);
        this.nome = nome;
        this.peso = peso;
    }


    public void draw() {
        System.out.println( "Doce '" + getNome() + "' - Weight : " + getPeso());
    }
}
