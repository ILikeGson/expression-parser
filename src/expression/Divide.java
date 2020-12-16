package expression;

public class Divide extends MathOperation {
    private static final char sign = '/';
    public Divide(AnyExpression task1, AnyExpression task2) {
        super(task1, task2, sign);
    }
}
