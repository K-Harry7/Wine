package wineproject;

public class Add extends Binop {
    public Add(Op left, Op right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
