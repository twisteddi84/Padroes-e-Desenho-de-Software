package V1;
import java.util.ArrayList;
import java.util.List;
    class Registos {
        // Data elements
        private ArrayList<Empregado> empregados; // Stores the employees
        public Registos() {
            empregados= new ArrayList<>();
        }
        public void insere(Empregado emp) {
            // Code to insert employee
            if(isEmpregado(emp.codigo())){
                System.out.println("Employee already exists");
                return;
            }
            empregados.add(emp);
            System.out.println("Added employee " + emp.codigo());
        }
        public void remove(int codigo) {
            // Code to remove employee
            for (int i= 0; i < empregados.size(); i++) {
                if (empregados.get(i).codigo() == codigo) {
                    empregados.remove(i);
                }
            }
            System.out.println("Deleted employee " + codigo);
        }
        public boolean isEmpregado(int codigo) {
            // Code to find employee
            for (int i= 0; i < empregados.size(); i++) {
                if (empregados.get(i).codigo() == codigo) {
                    return true;
                }
            }
            return false;
        }
        public List<Empregado>listaDeEmpregados() {
            // Code to retrieve collection
            return empregados;
        }
    }
