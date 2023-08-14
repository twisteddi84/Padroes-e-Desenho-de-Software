import java.util.Comparator;
public class QuickSort implements SortStrategy {
    public void sort(Telemovel[] telemoveis, Comparator<Telemovel> comparator) {
        quickSort(telemoveis, 0, telemoveis.length - 1, comparator);

        // Print sorted array
        for (int i = 0; i < telemoveis.length; i++) {
            System.out.println(telemoveis[i]);
        }
    }

    private void quickSort(Telemovel[] telemoveis, int low, int high, Comparator<Telemovel> comparator) {
        if (low < high) {
            int pivotIndex = partition(telemoveis, low, high, comparator);
            quickSort(telemoveis, low, pivotIndex - 1, comparator);
            quickSort(telemoveis, pivotIndex + 1, high, comparator);
        }
    }

    private int partition(Telemovel[] telemoveis, int low, int high, Comparator<Telemovel> comparator) {
        Telemovel pivot = telemoveis[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(telemoveis[j], pivot) <= 0) {
                i++;
                swap(telemoveis, i, j);
            }
        }

        swap(telemoveis, i + 1, high);
        return i + 1;
    }

    private void swap(Telemovel[] telemoveis, int i, int j) {
        Telemovel temp = telemoveis[i];
        telemoveis[i] = telemoveis[j];
        telemoveis[j] = temp;
    }
}
