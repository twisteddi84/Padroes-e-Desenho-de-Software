public class YogurtCakeBuilder extends CakeBuilderAbstract{
    @Override
    public void setCakeShape(Shape shape) {
        bolo.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        bolo.setNumCakeLayers(bolo.getNumCakeLayers() + 1);
    }

    public void addCreamLayer() {
        bolo.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        bolo.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        bolo.setTopping(Topping.Chocolate);
    }

    public void addMessage(String m){
        bolo.setMessage(m);
    }

    @Override
    public void createCake() {
        bolo.setCakeLayer("Yogurt");
        addCakeLayer();
        addCakeLayer();
        addCreamLayer();
        addTopLayer();
        addTopping();
    }

    public Cake getCake(){
        return bolo;
    }
}
