
import java.util.ArrayList;

public class Caixa extends Produto {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int peso_caixa = 0;
    private String nome;
    private int peso;

    Caixa(String nome , int peso){
        super(nome, peso);
        this.nome = nome;
        this.peso = peso;
    }

    public void draw() {
        System.out.println("* Caixa '" + getNome() + "' - [Weight : " + this.peso + " || Peso total - " + peso_total() + "]");
        for (Produto produto : produtos) {
            produto.draw();
        }
        
    }

    public void add(Produto x) {
        produtos.add(x);
   }

    public int peso_total(){
        int z = this.peso;
        for (Produto produto : produtos) {
            z = z + produto.getPeso();
        }
        return z;
    }

    public int getPeso() {
        return peso_total();
    }

   
}
