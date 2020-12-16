package expression;

public abstract class UnaryOperation implements AnyExpression {
    private final AnyExpression expression;

    public UnaryOperation(AnyExpression expression) {
        this.expression = expression;
    }

    public abstract int calculate(int x);

    @Override
    public int evaluate(int x) {
        return calculate(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(expression.evaluate(x,y,z));
    }

    @Override
    public String toMiniString() {
        return null;
    }
}
