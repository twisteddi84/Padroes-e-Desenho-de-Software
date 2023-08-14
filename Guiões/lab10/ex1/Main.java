public class Main {
    public static void main(String[] args) {
        // Criação dos produtos
        Produto produto1 = new Produto("Produto 1", 100.0);
        Produto produto2 = new Produto("Produto 2", 200.0);
        Produto produto3 = new Produto("Produto 3", 300.0);
        Produto produto4 = new Produto("Produto 4", 400.0);
        Produto produto5 = new Produto("Produto 5", 500.0);

        // Definição do tempo máximo de leilão para cada produto (em segundos)
        produto1.setTempoMaximoLeilao(60);
        produto2.setTempoMaximoLeilao(120);
        produto3.setTempoMaximoLeilao(180);
        produto4.setTempoMaximoLeilao(240);
        produto5.setTempoMaximoLeilao(300);

        // Criação dos clientes
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        Cliente cliente3 = new Cliente("Cliente 3");

        // Criação do gestor
        Gestor gestor = new Gestor("Gestor");

        // Simulação de licitações
        cliente1.licitar(produto1, 150.0);
        cliente2.licitar(produto1, 200.0);
        cliente3.licitar(produto1, 180.0);

        // Simulação de notificações
        produto1.notifyObservers(produto1, 220.0);

        // Simulação de venda
        produto1.vender();
        produto1.notifyVendaObservers(produto1);
    }
}
