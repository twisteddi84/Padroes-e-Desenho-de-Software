package V1;
public class Pork implements Portion{
    private Temperature temp;
    public Pork(Temperature temp) {
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
        return "Pork: Temperature " + this.temp+ ", State " + this.getState();
    }
}
