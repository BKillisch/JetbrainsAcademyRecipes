import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = l -> (l % 2 == 0) ? l + 2 : l + 1;
}