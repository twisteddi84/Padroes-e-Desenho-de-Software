
public class BankProxy extends BankAccountImpl{

    public User x = Company.user;
    private boolean is_owner = (x == User.OWNER);

    BankProxy(String bank, double initialDeposit) {
        super(bank, initialDeposit);
        }
    
    @Override
    public boolean withdraw(double amount) {
        if (is_owner){
            return super.withdraw(amount);}
        else{
            System.out.println("Just the owner can have access to the withdraw");
            return is_owner;
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public double balance() {
        if (is_owner){
            return super.balance();}
        else{
            System.out.println("Just the owner can have access to the balance");
            return 0;
        }
    }
    
    
}
