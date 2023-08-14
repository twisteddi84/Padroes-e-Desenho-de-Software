import java.util.Comparator;

public class BubbleSort implements SortStrategy{
    public void sort(Telemovel[] telemoveis, Comparator<Telemovel> comparator) {
        for (int i = 0; i < telemoveis.length; i++) {
            for (int j = 0; j < telemoveis.length - 1; j++) {
                if (comparator.compare(telemoveis[j], telemoveis[j + 1]) > 0) {
                    Telemovel temp = telemoveis[j];
                    telemoveis[j] = telemoveis[j + 1];
                    telemoveis[j + 1] = temp;
                }
            }
        }
        //Print sorted array
        for (int i = 0; i < telemoveis.length; i++) {
            System.out.println(telemoveis[i].toString());
        }
    }
}
