package wineproject;

public class Divide extends Binop {
    public Divide(Op left, Op right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        double rightValue = right.evaluate();
        if (rightValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.evaluate() / rightValue;
    }
}
