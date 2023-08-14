package V1;

public class FruitJuice implements Portion{
    private Temperature temp;
    private String fruitname;
    public FruitJuice(Temperature temp,String fruitname) {
        this.temp = temp;
        this.fruitname = fruitname;
    }
    public Temperature getTemperature() {
        return this.temp;
    }
    public State getState() {
        return State.Liquid;
    }
    public String getFruitname() {
        return fruitname;
    }
    @Override
    public String toString() {
        return "Fruit Juice:"+this.getFruitname() +", Temperature " + this.temp+ ", State " + this.getState();
    }
}