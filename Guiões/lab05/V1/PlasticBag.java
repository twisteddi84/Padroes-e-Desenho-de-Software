package V1;
public class PlasticBag extends Container {
    public PlasticBag(Portion p) {
        super(p);
        
    }
    @Override
    public String toString() {
        return "PlasticBag with portion = " + portion;
    }    
}
