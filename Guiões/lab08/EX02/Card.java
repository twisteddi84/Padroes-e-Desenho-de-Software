import java.util.ArrayList;
import java.util.List;

public class Card {
    private static List<Employee> listaEmployees = new ArrayList<Employee>();
    private static int counter = 874933; 


    public static void regist(Employee e){
        if (!is_allowed(e)){
            counter = counter+1;
            listaEmployees.add(e);
            }
    }

    public static boolean is_allowed(Employee e){
        if (listaEmployees.contains(e)){
            return true;
        }
        else{
            return false;
        }
    } 

}
