import java.util.Date;

public class TeamLeader extends Decorator{
    public TeamLeader (EmployeeInterface tl){
        super(tl);
    }

    public void work() {
        super.work();
        System.out.println("------ Working as TeamLeader ------");
    }

    @Override
    public void start(Date date) {
        // TODO Auto-generated method stub
        super.start(date);
    }

    @Override
    public void terminate(Date date) {
        // TODO Auto-generated method stub
        super.terminate(date);
    }


}
