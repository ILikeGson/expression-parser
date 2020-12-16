package expression;

import java.util.Objects;

public class Variable implements AnyExpression {
    private String num;

    public Variable(String num) {
        this.num = num;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (num.equals("x")) {
            return x;
        } else if (num.equals("y")) {
            return y;
        } else {
            return z;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(num, variable.num);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString(){
        return num;
    }
}