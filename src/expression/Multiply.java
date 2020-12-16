package expression;


public class Multiply extends MathOperation {
    private static final char sign = '*';

    public Multiply(AnyExpression task1, AnyExpression task2) {
        super(task1, task2, sign);
    }
}

