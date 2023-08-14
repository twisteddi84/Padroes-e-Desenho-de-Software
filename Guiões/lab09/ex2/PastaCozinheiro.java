public class PastaCozinheiro extends Cozinheiro{
        
        public PastaCozinheiro() {
            super("Pasta Carbonara");
        }
    
        @Override
        public void cozinheiro(String pedido) {
            if (this.podeCozinhar(pedido)) {
                System.out.println("PastaChef: Starting to cook " + pedido+". Out in 14 minutes!");
            } else {
                System.out.println("PastaChef: I can't cook that!");
                super.cozinheiro(pedido);
            }
        }
    
}
