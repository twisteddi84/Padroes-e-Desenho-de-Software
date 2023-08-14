public class CakeMaster{
    private CakeBuilder cakeBuilder;
    
    public void setCakeBuilder(CakeBuilder cb){
        cakeBuilder = cb;
    }

    public void createCake(String message){
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addMessage(message);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
    }
    public void createCake(Shape sh, int layers , String message){
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(sh);
        cakeBuilder.addMessage(message);
        
        cakeBuilder.addCakeLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
    }

    public void createCake(int layers , String message){
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addMessage(message);
        
        cakeBuilder.addCakeLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
    }
    public Cake getCake() {
        return cakeBuilder.getCake();
    }
    
}
