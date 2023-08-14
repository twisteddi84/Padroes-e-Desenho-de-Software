package V1;
public class Tuna implements Portion{
    private Temperature temp;
    public Tuna(Temperature temp) {
        this.temp = temp;
    }
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return State.Solid;
    }

    @Override
    public String toString() {
        return "Tuna: Temperature " + this.temp+ ", State " + this.getState();
    }
}
