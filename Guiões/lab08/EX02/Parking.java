import java.util.ArrayList;
import java.util.List;

public class Parking {
    private static List<Employee> listaEmployees = new ArrayList<Employee>();
    private static List<Integer> listaSlots = new ArrayList<Integer>();
    private static int counter = 0; 


    public static void regist(Employee e){
        if (!is_allowed(e)){
            listaEmployees.add(e);
            counter = counter+1;
            listaSlots.add(counter);
            
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
