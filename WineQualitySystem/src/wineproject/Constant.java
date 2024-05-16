package wineproject;

public class Constant extends Op {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}
