public class SushiCozinheiro extends Cozinheiro{
    
    public SushiCozinheiro() {
        super("Nigiri and Sashimi");
    }

    @Override
    public void cozinheiro(String pedido) {
        if (this.podeCozinhar(pedido)) {
            System.out.println("Sushi Chef: Starting to cook " + pedido +". Out in 14 minutes.");
        } else {
            System.out.println("Sushi Chef: I can't cook that!");
            super.cozinheiro(pedido);
        }
    }
}
