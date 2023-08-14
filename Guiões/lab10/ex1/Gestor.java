class Gestor implements Observer {
    private String nome;

    public Gestor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void update(Produto produto, double novoValor) {
        System.out.println("O produto " + produto.getDescricao() + " recebeu uma nova oferta de " + novoValor +
                " no leilão.");
    }

    @Override
    public void vendaRealizada(Produto produto) {
        System.out.println("O produto " + produto.getDescricao() + " foi vendido no leilão.");
    }
}
