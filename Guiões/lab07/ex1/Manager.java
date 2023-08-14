import java.util.Date;

public class Manager extends Decorator{
    public Manager (EmployeeInterface m){
        super(m);
    }

    public void manage(){
        System.out.println("------ Working as Manager ------");
    }

    @Override
    public void work() {
        super.work();
        this.manage();
    }

    @Override
    public void start(Date date) {
        super.start(date);
    }

    @Override
    public void terminate(Date date) {
        super.terminate(date);
    }

}
