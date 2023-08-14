import java.util.Date;

public class TeamMember extends Decorator{
    public TeamMember (EmployeeInterface tm){
        super(tm);
    }

    public void work() {
        super.work();
        System.out.println("------ Working as TeamMember ------");
    }

    @Override
    public void start(Date date) {
        super.start(date);
    }

    @Override
    public void terminate(Date date) {
        // TODO Auto-generated method stub
        super.terminate(date);
    }
}
