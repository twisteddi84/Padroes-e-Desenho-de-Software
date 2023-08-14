public class Cake{
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake(){
        shape = Shape.Circle;
        numCakeLayers = 1;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public String getCakeLayer() {
        return cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return midLayerCream;
    }
    
    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Topping getTopping() {
        return topping;
    }
    public String toString() {
        if (numCakeLayers == 1 || this.midLayerCream == null)
            if (this.topping == null)
                return this.cakeLayer + " cake with " + this.numCakeLayers + " layers, topped with " + this.topLayerCream
                        + " cream. Message says: \"" + this.message + "\".";
            else
                return this.cakeLayer + " cake with " + this.numCakeLayers + " layers, topped with " + this.topLayerCream
                        + " cream and " + this.topping + ". Message says: \"" + this.message + "\".";
        
        if (this.topping == null)
            return this.cakeLayer + " cake with " + this.numCakeLayers + " layers and " + this.midLayerCream
                    + " cream, topped with "
                    + this.topLayerCream + " cream. Message says: \"" + this.message + "\".";
        else
            return this.cakeLayer + " cake with " + this.numCakeLayers + " layers and " + this.midLayerCream
                    + " cream, topped with "
                    + this.topLayerCream + " cream and " + this.topping + ". Message says: \"" + this.message + "\".";
    }    

}
