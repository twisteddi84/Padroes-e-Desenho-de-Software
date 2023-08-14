package V1;

public abstract class PortionFactory{

    public static Portion create(String tipo, Temperature temp) {
        if(tipo == "Beverage") {
            if(temp == Temperature.COLD) {
                return new FruitJuice(temp, "Orange");
            } else {
                return new Milk(temp);
            }
        } else if(tipo == "Meat") {
            if(temp == Temperature.COLD) {
                return new Tuna(temp);
            } else {
                return new Pork(temp);
            }
        } else {
            return null;
        }
    }

}