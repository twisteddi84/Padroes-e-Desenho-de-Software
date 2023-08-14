package src;

public class Orientation {
    private int linha;
    private int coluna;
    private String orientacao;
    public Orientation(int linha,int coluna, String orientacao){
        setColuna(coluna);
        setLinha(linha);
        setOrientacao(orientacao);
    }
    public int getLinha(){
        return this.linha;
    }
    public int getColuna(){
        return this.coluna;
    }
    public String getOrientation(){
        return this.orientacao;
    }
    public void setLinha(int linha){
        this.linha = linha;
    }
    public void setColuna(int coluna){
        this.coluna = coluna;
    }
    public void setOrientacao(String orientacao){
        this.orientacao = orientacao;
    }
}
