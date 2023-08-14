public class SpongeCakeBuilder extends CakeBuilderAbstract{
    @Override
    public void setCakeShape(Shape shape) {
        bolo.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        bolo.setNumCakeLayers(bolo.getNumCakeLayers() + 1);
    }

    public void addCreamLayer() {
        bolo.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        bolo.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        bolo.setTopping(Topping.Fruit);
    }

    public void addMessage(String m){
        bolo.setMessage(m);
    }

    @Override
    public void createCake() {
        bolo.setCakeLayer("Sponge Cake");
        addCakeLayer();
        addCreamLayer();
        addTopLayer();
        addTopping();
    }

    public Cake getCake(){
        return bolo;
    }
}
