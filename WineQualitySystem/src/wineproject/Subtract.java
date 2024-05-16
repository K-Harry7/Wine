package wineproject;

public class Subtract extends Binop {
    public Subtract(Op left, Op right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
