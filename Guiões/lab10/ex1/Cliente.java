class Cliente implements Observer {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void licitar(Produto produto, double valor) {
        // Verificar se o valor da licitação é maior que o preço base
        if (valor > produto.getPrecoBase()) {
            System.out.println("Parabéns, você está liderando o leilão do produto " + produto.getDescricao() +
                    " com o valor de " + valor);
            produto.addObserver(this);
        } else {
            System.out.println("Sua licitação de " + valor + " não é suficiente para liderar o leilão do produto " +
                    produto.getDescricao());
        }
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
