package expression;

public class Subtract extends MathOperation {
    private static final char sign = '-';

    public Subtract(AnyExpression task1, AnyExpression task2) {
        super(task1, task2, sign);
    }
}
