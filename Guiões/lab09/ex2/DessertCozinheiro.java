public class DessertCozinheiro extends Cozinheiro{
            
    public DessertCozinheiro() {
        super("Chocolate Cake");
    }
        
    @Override
    public void cozinheiro(String pedido) {
        if (this.podeCozinhar(pedido)) {
            System.out.println("Dessert Chef: Starting to cook " + pedido +". Out in 19 minutes!");
         } else {
            System.out.println("Dessert Chef: I can't cook that!");
            super.cozinheiro(pedido);
        }
    }
    
}
