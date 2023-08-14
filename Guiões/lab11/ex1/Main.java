public class Main {
    public static void main(String[] args) {
        Telemovel [] telemoveis = {new Telemovel("SnapDragon888", 455, 12, "48MP"),
                                   new Telemovel("Mixa 132", 390, 20, "16MP"),
                                   new Telemovel("SnapDragon123", 202, 8, "24MP"),
                                   new Telemovel("Intel A23", 700, 24, "200MP")};
        Revista rev = new Revista(telemoveis);
        TelemovelWithSorting bub = new TelemovelWithSorting(new BubbleSort());
        TelemovelWithSorting merge = new TelemovelWithSorting(new MergeSort());
        TelemovelWithSorting quick = new TelemovelWithSorting(new QuickSort());
        System.out.println("------Preço------");
        bub.sort(telemoveis,(a,b)->a.getPreco()>b.getPreco()?1:-1);
        System.out.println("------Memoria-----");
        bub.sort(telemoveis,(a,b)->a.getMemoria()>b.getMemoria()?1:-1);
        System.out.println("------Processador----");
        bub.sort(telemoveis,(a,b)->a.getProcessador().compareTo(b.getProcessador()));
        System.out.println("------Camara--------");
        merge.sort(telemoveis, (a, b) -> a.getPreco()>b.getPreco()?1:-1);
        System.out.println("------Processador----");
        quick.sort(telemoveis,(a,b)->a.getProcessador().compareTo(b.getProcessador()));

    }
}
