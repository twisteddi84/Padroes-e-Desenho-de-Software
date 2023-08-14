public class Frontend extends AppComponent {
    private AppMediator mediator;

    public void display(String updates) {
        // Display real-time updates on the UI
        System.out.println("Real-time updates: " + updates);
    }

    public void send(String input) {
        // Send user input through the mediator
        mediator.notify(this, input);
    }

    public void handleEvent(Object event) {
        String updates = (String) event;
        display(updates);
    }
}