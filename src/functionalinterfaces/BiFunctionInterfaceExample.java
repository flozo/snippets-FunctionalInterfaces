package functionalinterfaces;

import java.util.function.BiFunction;

public class BiFunctionInterfaceExample {

    public static void generalBiFunctionExample() {

        // BiFunction interface
        // - takes 2 argument, produces 1 result
        // - has 2 methods: apply(), andThen()
        // - introduced in Java 8

        System.out.println("*** BiFunction<Integer, Integer, Integer>");
        BiFunction<Integer, Integer, Integer> sumMinusFive = (a, b) -> a + b - 5;
        System.out.println(sumMinusFive.apply(3, 4));           // returns 2 (= 3 + 4 - 5)
        System.out.println(sumMinusFive.apply(8, 2));           // returns 5 (= 8 + 2 - 5)

        System.out.println("*** BiFunction<String, Integer, Double>");
        BiFunction<String, Integer, Double> sumDividedByFive = (s, a) -> (Double.parseDouble(s) + a) / 5.0;
        System.out.println(sumDividedByFive.apply("8", 2));     // returns 2.0 (= [8 + 2] / 5.0)


        System.out.println("*** example with andThen()");
        System.out.println(sumDividedByFive.andThen(x -> x * 5).andThen(x -> x / 2).apply("8", 2));     // returns 5.0 (= [8 + 2] / 5.0 * 5 / 2)


    }


}
