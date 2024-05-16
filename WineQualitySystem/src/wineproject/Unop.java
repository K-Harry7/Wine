package wineproject;

abstract class Unop extends Op {
    protected Op operand;

    public Unop(Op operand) {
        this.operand = operand;
    }
}
