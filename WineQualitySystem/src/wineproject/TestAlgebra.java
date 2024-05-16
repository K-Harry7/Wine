package wineproject;

public class TestAlgebra {
    public static void main(String[] args) {
        Op const1 = new Constant(5);
        Op const2 = new Constant(3);
        Op addition = new Add(const1, const2);
        Op subtraction = new Subtract(const1, const2);
        Op multiplication = new Multiply(const1, const2);
        Op division = new Divide(const1, const2);

        System.out.println("Addition: " + addition.evaluate());           // 5 + 3 = 8
        System.out.println("Subtraction: " + subtraction.evaluate());     // 5 - 3 = 2
        System.out.println("Multiplication: " + multiplication.evaluate());// 5 * 3 = 15
        System.out.println("Division: " + division.evaluate());           // 5 / 3 = 1.6667

        try {
            Op divisionByZero = new Divide(const1, new Constant(0));
            System.out.println("Division by Zero: " + divisionByZero.evaluate());
        } catch (ArithmeticException e) {
            System.out.println("Division by Zero: " + e.getMessage());    // Should handle division by zero
        }
    }
}
