package expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        parser.parse("x + 2");
    }
}
