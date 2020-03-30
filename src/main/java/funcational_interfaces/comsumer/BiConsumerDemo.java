/**
 * @author heyx8
 * @date 06/30/2019
 */

package interfaces.funcational_interfaces.comsumer;

import java.util.function.BiConsumer;

/**
 * @FunctionalInterface public interface BiConsumer<T,​U>
 * Represents an operation that accepts two input arguments and returns no result
 * This is the two-arity specialization of Consumer
 * Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects
 * This is a functional interface whose functional method is accept(Object, Object)
 */
public class BiConsumerDemo {

    public static void main(String[] args) {
        acceptDemo();
    }

    /**
     * void accept​(T t, U u)
     */
    public static void acceptDemo() {
        BiConsumer<String, Integer> consumer = (t1, t2) -> System.out.println(t1 + t2);
        consumer.accept("a", 1);

        BiConsumer<String, String> consumer2 = (t1, t2) -> System.out.println(t1 + t2);
        consumer2.accept("b", "2");
    }

    /**
     * default BiConsumer<T,​U> andThen​(BiConsumer<? super T,​? super U> after)
     * Returns a composed BiConsumer that performs, in sequence, this operation followed by the after operation
     * If performing either operation throws an exception, it is relayed to the caller of the composed operation
     * If performing this operation throws an exception, the after operation will not be performed
     */
    public void andThenDemo() {

    }
}
