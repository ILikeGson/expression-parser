package expression;

public class Add extends MathOperation {
    private static final char sign = '+';

    public Add(AnyExpression task1, AnyExpression task2) {
        super(task1, task2, sign);
    }
}