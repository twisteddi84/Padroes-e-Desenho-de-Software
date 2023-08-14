public class Backend extends AppComponent{
    private AppMediator mediator;

    public Backend(AppMediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void display(String updates) {
        // TODO Auto-generated method stub
        System.out.println("Generated updates: " + updates);
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    public void send(String input) {
        // TODO Auto-generated method stub
        mediator.notify(this, input);
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
    @Override
    public void handleEvent(Object event) {
            String updates = (String) event;
            display(updates);

}
}