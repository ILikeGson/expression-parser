package expression;

public class UnaryMinus extends UnaryOperation{
    public UnaryMinus(AnyExpression expression) {
        super(expression);
    }

    @Override
    public int calculate(int x) {
        return -x;
    }
}
