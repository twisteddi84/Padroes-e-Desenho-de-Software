import java.util.Comparator;

public class MergeSort implements SortStrategy {
    public void sort(Telemovel[] telemoveis, Comparator<Telemovel> comparator) {
        mergeSort(telemoveis, 0, telemoveis.length - 1, comparator);

        // Print sorted array
        for (int i = 0; i < telemoveis.length; i++) {
            System.out.println(telemoveis[i].toString());
        }
    }

    private void mergeSort(Telemovel[] telemoveis, int start, int end, Comparator<Telemovel> comparator) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(telemoveis, start, mid, comparator);
            mergeSort(telemoveis, mid + 1, end, comparator);

            merge(telemoveis, start, mid, end, comparator);
        }
    }

    private void merge(Telemovel[] telemoveis, int start, int mid, int end, Comparator<Telemovel> comparator) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        Telemovel[] leftArray = new Telemovel[leftSize];
        Telemovel[] rightArray = new Telemovel[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = telemoveis[start + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = telemoveis[mid + 1 + i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = start;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) <= 0) {
                telemoveis[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                telemoveis[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftSize) {
            telemoveis[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightSize) {
            telemoveis[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }
}
