package lab07.ex2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader implements Reader {
    //Read file
    private List<String> lines;
    private int index = 0;
    //Constructor
    public TextReader(String filename){
        try{
            lines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    //Check if there is a next line
    public boolean hasNext() {
        if (index < lines.size() ){
            return true;
        }else{
            return false;
        }
    }
    //Return next line
    public String next() {
        return lines.get(index++);
    }
}
