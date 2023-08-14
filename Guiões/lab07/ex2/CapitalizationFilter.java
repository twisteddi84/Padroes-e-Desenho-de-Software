package lab07.ex2;
import java.util.ArrayList;
import java.util.List;
public class CapitalizationFilter extends ReadDecorator{
    private List<String> capitalized = new ArrayList<>();
    private int index = 0;

    public CapitalizationFilter(Reader reader) {
        super(reader);
        while(reader.hasNext()){
            final String[] words_line = reader.next().split(" ");
            for (String word : words_line) {
                //Last letter to upper case
                String capitalized_word = word.substring(0, word.length() - 1) + word.substring(word.length() - 1).toUpperCase();
                //First letter to upper case
                capitalized_word = capitalized_word.substring(0, 1).toUpperCase() + capitalized_word.substring(1);
                capitalized.add(capitalized_word);
            }
        }
    }


    public boolean hasNext() {
        while(index < capitalized.size()){
            return true;
        }
        return false;
    }

    public String next() {
        return capitalized.get(index++);
    }
}
