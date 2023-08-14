abstract class Cozinheiro {
    private Cozinheiro proximo;
    private String pedido;

    public Cozinheiro(String pedido) {
        this.pedido = pedido;
    }

    public void cozinheiro(String pedido) {
        if (this.proximo != null) {
            this.proximo.cozinheiro(pedido);
        }else{
            System.out.println("No one can cook that!");
        }

    }

    protected boolean podeCozinhar(String pedido) {
        return this.pedido==pedido;
    }

    public Cozinheiro proximoCozinheiro(Cozinheiro proximo) {
        this.proximo = proximo;
        return this;
    }
}