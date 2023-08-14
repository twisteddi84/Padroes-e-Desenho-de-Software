import javax.management.modelmbean.DescriptorSupport;
import javax.swing.DebugGraphics;

public class Main {
    public static void main(String[] args) {
        enviarPedido("veggie burger");
        System.out.println();
        enviarPedido("Pasta Carbonara");
        System.out.println();
        enviarPedido("PLAIN pizza");
        System.out.println();
        enviarPedido("Nigiri and Sashimi");
        System.out.println();
        enviarPedido("Salad and tuna");
        System.out.println();
        enviarPedido("Strawberry ice cream");
        System.out.println();

    }

    public static void enviarPedido(String pedido){
        System.out.println("Can I please get a " + pedido + "?");
        Cozinheiro sushiChef = new SushiCozinheiro().proximoCozinheiro(
            new PastaCozinheiro().proximoCozinheiro(
                new BurgerCozinheiro().proximoCozinheiro(
                    new PizzaCozinheiro().proximoCozinheiro(new DessertCozinheiro())
                )));

        sushiChef.cozinheiro(pedido);

    }
}
