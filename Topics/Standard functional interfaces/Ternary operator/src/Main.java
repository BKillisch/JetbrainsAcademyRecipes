import java.util.function.*;

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (arg) -> condition.test(arg) ? ifTrue.apply(arg) : ifFalse.apply(arg);
    }
}