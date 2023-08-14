package V1;

public abstract class Container {
    protected Portion portion;
    
    public Container(Portion p) {
        this.portion = p;
    }
    public Portion getPortion() {
        return portion;
    }
        
    public static Container create(Portion p) {
        if(p.getState() == State.Liquid) {
            if(p.getTemperature() == Temperature.COLD){
                return new PlasticBottle(p);
            }else{
                return new TermicBottle(p);
            }
        }else{
            if(p.getTemperature() == Temperature.COLD){
                return new PlasticBag(p);
             }else{
                return new Tupperware(p);
            }
        }
    }
}

