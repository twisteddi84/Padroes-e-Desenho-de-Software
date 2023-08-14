package lab07.ex2;
import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;
public class VowelFilter extends ReadDecorator{
    private List<String> vowel_filter = new ArrayList<>();
    private int index = 0;

    public VowelFilter(Reader reader) {
        super(reader);
        while(reader.hasNext()){
            final String[] words_line = reader.next().split(" ");
            for (String word : words_line) {
                //remove vowel from word
                String normalizer = Normalizer.normalize(word, Normalizer.Form.NFD);
                String vowel = normalizer.replaceAll("[aeiouAEIOU]", "");
                vowel_filter.add(vowel.trim());
            }
        }
    }


    public boolean hasNext() {
        while(index < vowel_filter.size()){
            return true;
        }
        return false;
    }

    public String next() {
        return vowel_filter.get(index++);
    }
}
