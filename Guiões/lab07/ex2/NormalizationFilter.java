package lab07.ex2;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class NormalizationFilter extends ReadDecorator{
    private List<String> normalized_Text = new ArrayList<>();
    private int index = 0;

    public NormalizationFilter(Reader reader) {
        super(reader);
        while(reader.hasNext()){
            String normalizer = Normalizer.normalize(reader.next(), Normalizer.Form.NFD);
            //remove pontuation from string
            String normalized = normalizer.replaceAll("[^\\p{ASCII}]", "");
            //remove special characters from string
            normalized = normalized.replaceAll("[^a-zA-Z0-9]", " ");

            normalized_Text.add(normalized);
        }
    }


    public boolean hasNext() {
        while(index < normalized_Text.size()){
            return true;
        }
        return false;
    }

    public String next() {
        return normalized_Text.get(index++);
    }
}
