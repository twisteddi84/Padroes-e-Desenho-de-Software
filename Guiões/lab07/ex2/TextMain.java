package lab07.ex2;
public class TextMain {
    public static void main(String[] args) {
        Reader reader = new TermFilter(new TextReader("ex2/text.txt"));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }

        System.out.println("---------------------");

        reader = new NormalizationFilter(new TextReader("ex2/text.txt"));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }
        System.out.println("---------------------");

        reader = new VowelFilter(new TextReader("ex2/text.txt"));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }

        System.out.println("---------------------");

        reader = new CapitalizationFilter(new TextReader("ex2/text.txt"));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }
    }
}
