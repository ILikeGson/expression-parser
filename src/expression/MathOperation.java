package expression;

import java.util.Objects;

public abstract class MathOperation implements AnyExpression {
    private AnyExpression task1;
    private AnyExpression task2;
    private char sign;

    public MathOperation(AnyExpression task1, AnyExpression task2, char sign) {
        this.task1 = task1;
        this.task2 = task2;
        this.sign = sign;
    }

    public int calculate(int x, int y) {
        if (sign == '+') {
            return x + y;
        } else if (sign == '-') {
            return x - y;
        } else if (sign == '/') {
            return x / y;
        } else if (sign == '*') {
            return x * y;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int evaluate(int x, int y, int z) {
        return calculate(task1.evaluate(x,y,z), task2.evaluate(x,y,z));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MathOperation that = (MathOperation) o;
        return Objects.equals(task1, that.task1) &&
                Objects.equals(task2, that.task2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task1, task2, sign);
    }


    @Override
    public int evaluate(int x) {
        return calculate(task1.evaluate(x), task2.evaluate(x));
    }

    public Expression getTask1() {
        return task1;
    }

    public Expression getTask2() {
        return task2;
    }

    @Override
    public String toString() {
        return  "(" + task1 + " " + sign + " " + task2 + ")";
    }
}
