// Author: Rafael Pinto, 103379, p5_09

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileUtils {

    public static List<String> readFile(String pathname) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(pathname);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
            sc.close();            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return lines;
    }

    public static void printFile(String text, String filename){
        File file = new File(filename);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.print(text);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not create file");
            System.exit(1);
        }
    }
}
