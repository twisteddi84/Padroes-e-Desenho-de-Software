import java.util.Date;

public class Decorator implements EmployeeInterface {
    protected EmployeeInterface i;

    public Decorator(EmployeeInterface e){
        this.i = e;
    }
    public void work(){
        i.work();
    }

    @Override
    public void start(Date date) {
        i.start(date);
    }

    @Override
    public void terminate(Date date) {
        i.start(date);
    }
}
