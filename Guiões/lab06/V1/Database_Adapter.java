package V1;

import java.util.List;
import java.util.ArrayList;

public class Database_Adapter implements DBInterface{
    
    private Database db1 = new Database();


    public void insere(Empregado e){
        Employee emp = new Employee(e.nome(),(long)e.codigo(), e.salario());
        db1.addEmployee(emp);
    }

    public void remove (int codigo) {
        db1.deleteEmployee((long)codigo);
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (Employee emp : this.db1.getAllEmployees()) {
            if (((int) emp.getEmpNum()) == codigo) {
                return true;
            }
        }
        return false;
    }
    public List<Empregado> listaDeEmpregados() {
        List<Empregado> empregados = new ArrayList<>();
        for (Employee emp : this.db1.getAllEmployees()) {
            empregados.add(new Empregado(emp.getName(), "", (int) emp.getEmpNum(), emp.getSalary()));
        }
        return empregados;
    }
}
