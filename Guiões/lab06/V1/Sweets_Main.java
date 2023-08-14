package V1;
import java.util.ArrayList;
import java.util.List;

public class Sweets_Main {
    public static void main(String[] args) {
        //Test Database
        Database d1 = new Database();
        Employee e1 = new Employee("John", 123, 1000);
        d1.addEmployee(e1);
        Employee e2 = new Employee("Mary", 456, 2000);
        d1.addEmployee(e2);
        Employee [] employees = d1.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName() + " " + employees[i].getEmpNum() + " " + employees[i].getSalary());
        }
        d1.deleteEmployee(123);
        employees = d1.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName() + " " + employees[i].getEmpNum() + " " + employees[i].getSalary());
       }

        System.out.println("--------------------");
        //Test Registos
        Registos r1 = new Registos();
        Empregado emp1 = new Empregado("John", "Doe", 123, 1000);
        r1.insere(emp1);
        Empregado emp2 = new Empregado("Mary", "Doe", 456, 2000);
        r1.insere(emp2);
        List<Empregado> empregados = r1.listaDeEmpregados();
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println(empregados.get(i).nome() + " " + empregados.get(i).apelido() + " " + empregados.get(i).codigo() + " " + empregados.get(i).salario());
        }
        r1.remove(123);
        r1.insere(emp2);
        empregados = r1.listaDeEmpregados();
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println(empregados.get(i).nome() + " " + empregados.get(i).apelido() + " " + empregados.get(i).codigo() + " " + empregados.get(i).salario());
        }

        System.out.println("--------------------");
        
        //Test Interface

        DBInterface [] dbs = {new Database_Adapter(), new Registos_Adapter()};

        for (int i = 0; i < dbs.length; i++) {
            Empregado e3 = new Empregado("John", "Doe", 123, 1000);
            dbs[i].insere(e3);
            Empregado e4 = new Empregado("Mary", "Doe", 456, 2000);
            dbs[i].insere(e4);
            List<Empregado> employees2 = dbs[i].listaDeEmpregados();
            for (int j = 0; j < employees2.size(); j++) {
                System.out.println(employees2.get(j).nome() + " " + employees2.get(j).codigo() + " " + employees2.get(j).salario());
            }
            dbs[i].remove(123);
            dbs[i].insere(e4);
            employees2 = dbs[i].listaDeEmpregados();
            for (int j = 0; j < employees2.size(); j++) {
                System.out.println(employees2.get(j).nome() + " " + employees2.get(j).codigo() + " " + employees2.get(j).salario());
            }
        }


        


    }
}
