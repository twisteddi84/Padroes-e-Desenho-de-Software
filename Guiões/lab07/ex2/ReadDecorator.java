package lab07.ex2;
public abstract class ReadDecorator implements Reader{
    protected Reader reader;
    public ReadDecorator(Reader reader) {
        this.reader = reader;
    }
}
