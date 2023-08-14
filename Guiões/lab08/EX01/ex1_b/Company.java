import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getConta();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);


	}

    public void admitEmployee(Person person, double salary) {
		emps.add(new Employee(person.getName() , salary));
    }


}