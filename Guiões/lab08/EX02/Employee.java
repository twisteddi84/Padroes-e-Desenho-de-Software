
class Employee{

private double salary;
private BankAccount conta;
private String nome;
	
	public Employee(String n, double s) {
		salary = s;
		nome = n;
		conta = new BankAccountImpl("PeDeMeia", 0);;

	}

	public double getSalary() {
		return salary;
	}
	
	public BankAccount getConta() {
		return conta;
	}

	public String getNome() {
		return nome;
	}
}