package expression;


public class Const implements AnyExpression {
    private int num;

    public Const(int num) {
        this.num = num;
    }

    @Override
    public int evaluate(int x) {
        return num;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return num == aConst.num;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString(){
        return String.valueOf(num);
    }
}
