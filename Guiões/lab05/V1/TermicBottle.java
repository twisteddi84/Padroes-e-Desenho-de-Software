package V1;
public class TermicBottle extends Container {
    public TermicBottle(Portion p) {
        super(p);
        
    }
    @Override
    public String toString() {
        return "TermicBottle with portion = " + portion;
    }
}
    
