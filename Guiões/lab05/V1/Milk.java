package V1;

public class Milk implements Portion{
    private Temperature temp;
    public Milk(Temperature temp) {
        this.temp = temp;
    }
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return State.Liquid;
    }

    @Override
    public String toString() {
        return "Milk: Temperature " + this.temp+ ", State " + this.getState();
    }
}
