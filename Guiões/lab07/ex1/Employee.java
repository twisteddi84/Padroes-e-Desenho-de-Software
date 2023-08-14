import java.util.Date;

public class Employee implements EmployeeInterface{
    private String name;

    public Employee(String name){
        this.name = name;
    }

    @Override
    public void start(Date date) {
        System.out.println("\n" + this.name + " começou a trabalhar no dia " + date );
    }

    @Override
    public void terminate(Date date) {
        System.out.println("\n" + this.name + " terminou de trabalhar no dia " + date );
    }

    @Override
    public void work() {
        System.out.println("\n" + this.name + " está a trabalhar");
    }

    public String getName() {
        return name;
    }

}
