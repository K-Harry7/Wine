package wineproject;

public class Multiply extends Binop {
    public Multiply(Op left, Op right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
