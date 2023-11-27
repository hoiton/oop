package ch.hslu.oop.sw06;

public class Mercury extends Element {
    protected Mercury() {
        super("Hg", 357, -39);
    }

    @Override
    public String toString(){
        return "TOXIC!+ \n" + super.toString();
    }
}
