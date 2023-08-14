package V1;
import java.util.Vector;

    class Database {// Data elements
        private Vector<Employee> employees; // Stores the employees
        public Database() {
            employees = new Vector<>();
        }
        public boolean addEmployee(Employee employee) {
            // Code to add employee
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpNum() == employee.getEmpNum()) {
                    return false;
                }
            }
            employees.add(employee);
            System.out.println("Added employee " + employee.getEmpNum());
            return true;

        }
        public void deleteEmployee(long emp_num) {
            // Code to delete employee
            employees.removeIf(employee -> employee.getEmpNum() == emp_num);
            System.out.println("Deleted employee " + emp_num);
        }
        public Employee[] getAllEmployees() {
            // Code to retrieve collection
            Employee[] employeesArray = new Employee[employees.size()];
            for (int i = 0; i < employees.size(); i++) {
                employeesArray[i] = employees.get(i);
            }
            return employeesArray;
        }
    }
