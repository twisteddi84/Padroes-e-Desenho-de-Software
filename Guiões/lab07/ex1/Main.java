import java.util.Date;

class Main {
    public static void main(String[] args) {
    TeamLeader um = new TeamLeader(new Employee("Johnny Carlos"));
    TeamMember dois = new TeamMember(new Employee("Francisco Coelho"));
    Manager tres = new Manager(new Employee("Big Boss"));

    tres.start(new Date());
    tres.work();
    tres.terminate(new Date());

    dois.start(new Date());
    dois.work();
    dois.terminate(new Date());

    um.start(new Date());
    um.work();
    um.terminate(new Date());

    Manager quatro = new Manager( new TeamMember (new TeamLeader ( new Employee("Tudo ao mesmo tempo"))));
   
    quatro.start(new Date());
    quatro.work();
    quatro.terminate(new Date());

}
}