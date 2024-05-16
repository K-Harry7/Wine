package wineproject;

abstract class Binop extends Op {
    protected Op left;
    protected Op right;

    public Binop(Op left, Op right) {
        this.left = left;
        this.right = right;
    }
}
