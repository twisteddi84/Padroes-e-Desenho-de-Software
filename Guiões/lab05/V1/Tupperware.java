package V1;
public class Tupperware extends Container {
    public Tupperware(Portion p) {
        super(p);
        
    }
    @Override
    public String toString() {
        return "Tupperware with portion = " + portion;
    }
}