import java.util.Comparator;
public class TelemovelWithSorting implements SortStrategy{
    private final SortStrategy strategy;

    public TelemovelWithSorting(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(Telemovel[] telemoveis, Comparator<Telemovel> comparator) {
        strategy.sort(telemoveis,comparator);
    }
    
}
