package V1;
public class PlasticBottle extends Container {
    public PlasticBottle(Portion p) {
        super(p);
        
    }
    @Override
    public String toString() {
        return "PlasticBottle with portion = " + portion;
    }
}
