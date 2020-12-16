package expression;

import java.util.List;

public class ExpressionParser implements Parser{
    private List<Character> signs = List.of('*', '/', '+', '-', '(', ')');
    private List<Character> variables = List.of('x', 'y', 'z');
    private ExpressionCharacter character;
    private String expression;
    private char ch;
    private int number;
    private int pos;
    private boolean flag = false;
    @Override

    public TripleExpression parse(String expression) {
        this.expression = expression.replaceAll("\\s+", "");
        pos = 0;
        return add();
    }

    public void nextChar() {
        if (pos == expression.length()) {
            return;
        }
        ch = expression.charAt(pos);
    }

    public void symbol() {
        nextChar();
        if (signs.contains(ch)) {
            if (ch == signs.get(0)) {
                character = ExpressionCharacter.MULTIPLY;
            } else if (ch == signs.get(1)) {
                character = ExpressionCharacter.DIVIDE;
            } else if (ch == signs.get(2)) {
                character = ExpressionCharacter.ADD;
            } else if (ch == signs.get(3)) {
                if (character == ExpressionCharacter.CONST || character == ExpressionCharacter.VARIABLE
                        || character == ExpressionCharacter.CLOSED_BRACKET) {
                    character = ExpressionCharacter.SUBTRACT;
                } else {
                    character = ExpressionCharacter.UNARY_MINUS;
                }
            } else if (ch == signs.get(4)) {
                character = ExpressionCharacter.OPEN_BRACKET;
            } else if (ch == signs.get(5)) {
                character = ExpressionCharacter.CLOSED_BRACKET;
            }

        } else {
            if (ch == 'x' || ch == 'y' || ch == 'z') {
                character = ExpressionCharacter.VARIABLE;
            } else {
                number = 0;
                while (pos < expression.length() && Character.isDigit(expression.charAt(pos))) {
                    number = number * 10 + (expression.charAt(pos) - '0');
                    pos++;
                    flag = true;
                }
                if (flag) {
                    pos--;
                    character = ExpressionCharacter.CONST;
                    flag = false;
                }
            }
        }
        pos++;
    }
     public AnyExpression current() {
        symbol();
        AnyExpression anyExpression = null;
        if (character == ExpressionCharacter.CONST) {
            anyExpression = new Const(number);
            symbol();
        } else if (character == ExpressionCharacter.VARIABLE) {
            anyExpression = new Variable(Character.toString(ch));
            symbol();
        } else if (character == ExpressionCharacter.UNARY_MINUS) {
            anyExpression = new UnaryMinus(current());
        } else if (character == ExpressionCharacter.OPEN_BRACKET) {
            anyExpression = add();
            symbol();
        } else {
            return new Const(0);
        }
        return anyExpression;
     }

     public AnyExpression multiply() {
        AnyExpression anyExpression = current();
        while (character == ExpressionCharacter.MULTIPLY || character == ExpressionCharacter.DIVIDE) {
            if (character == ExpressionCharacter.MULTIPLY) {
                anyExpression = new Multiply(anyExpression, current());
            } else {
                anyExpression = new Divide(anyExpression, current());
            }
        }
        return anyExpression;
     }

     public AnyExpression add() {
        AnyExpression result = multiply();
         while (character == ExpressionCharacter.ADD || character == ExpressionCharacter.SUBTRACT) {
             if (character == ExpressionCharacter.ADD) {
                 result = new Add(result, multiply());
             } else  {
                 result = new Subtract(result, multiply());
             }
         }
        return result;
     }
}
