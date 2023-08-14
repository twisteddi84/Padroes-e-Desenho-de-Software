public class NullDemo {
    public static void main(String[] args) {
        Employee emp = EmployeeFectory.getEmployee("Mac");
        Employee emp1 = EmployeeFectory.getEmployee("Janela");
        Employee emp2 = EmployeeFectory.getEmployee("Linux");
        Employee emp3 = EmployeeFectory.getEmployee("Macx");

        System.out.println(emp.getName());
        System.out.println(emp1.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
    }
}
