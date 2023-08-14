package lab07.ex2;
import java.util.ArrayList;
import java.util.List;

public class TermFilter extends ReadDecorator{
    private List<String> terms = new ArrayList<>();
    private int index = 0;

    public TermFilter(Reader reader) {
        super(reader);
        while(reader.hasNext()){
            final String[] words_line = reader.next().split(" ");
            for (String word : words_line) {
                terms.add(word);
            }
        }
    }


    public boolean hasNext() {
        while(index < terms.size()){
            return true;
        }
        return false;
    }

    public String next() {
        return terms.get(index++);
    }
}
