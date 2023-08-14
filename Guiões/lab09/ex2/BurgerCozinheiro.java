public class BurgerCozinheiro extends Cozinheiro{
        
        public BurgerCozinheiro() {
            super("veggie burger");
        }
    
        @Override
        public void cozinheiro(String pedido) {
            if (this.podeCozinhar(pedido)) {
                System.out.println("Burger Chef: Starting to cook " + pedido +". Out in 19 minutes!");
            } else {
                System.out.println("Burger Chef: I can't cook that!");
                super.cozinheiro(pedido);
            }
        }
    
}
