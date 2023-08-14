interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Produto produto, double novoValor);
    void notifyVendaObservers(Produto produto);
}
