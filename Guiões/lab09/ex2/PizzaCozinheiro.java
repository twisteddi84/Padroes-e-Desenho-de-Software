public class PizzaCozinheiro extends Cozinheiro{
        
        public PizzaCozinheiro() {
            super("PLAIN pizza");
        }
    
        @Override
        public void cozinheiro(String pedido) {
            if (this.podeCozinhar(pedido)) {
                System.out.println("Pizza Chef: Starting to cook " + pedido +". Out in 7 minutes.");
            } else {
                System.out.println("Pizza Chef: I can't cook that!");
                super.cozinheiro(pedido);
            }
        }
    
}
