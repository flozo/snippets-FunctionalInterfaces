package functionalinterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionInterfaceExample {

    public static void generalFunctionExample() {

        // Function interface
        // - takes 1 argument, produces 1 result
        // - has 4 methods: apply(), andThen(), compose(), identity()
        // - introduced in Java 8


        // Examples for apply() method
        System.out.println("*** apply()");
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println(half.apply(1));  // returns 0.5
        System.out.println(half.apply(2));  // returns 1.0
        System.out.println(half.apply(3));  // returns 1.5
        System.out.println(half.apply(4));  // returns 2.0
        System.out.println(half.apply(5));  // returns 2.5


        // Examples for andThen() method
        System.out.println("*** andThen(); example 1");
        System.out.println(half.andThen(a -> a * 3).andThen(a -> a / 5.0).apply(5));  // returns 1.5 (= 5 / 2.0 * 3 / 5.0)

        System.out.println("*** andThen(); example 2");
        Function<Double, Double> minusOneFirst = a -> a - 1.0;
        minusOneFirst = minusOneFirst.andThen(a -> a / 2.0);
        System.out.println(minusOneFirst.apply(1.0));   // returns 0.0
        System.out.println(minusOneFirst.apply(2.0));   // returns 0.5
        System.out.println(minusOneFirst.apply(3.0));   // returns 1.0


        // Examples for compose() method
        System.out.println("*** compose()");
        Function<Double, Double> minusOneSecond = a -> a - 1.0;
        minusOneSecond = minusOneSecond.compose(a -> a / 2.0);
        System.out.println(minusOneSecond.apply(1.0));  // returns -0.5
        System.out.println(minusOneSecond.apply(2.0));  // returns 0.0
        System.out.println(minusOneSecond.apply(3.0));  // returns 0.5


        // Examples for identity() method
        System.out.println("*** identity()");
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(20));         // returns 20

    }


    public static void specialFunctionExample() {

        // Function interface
        // - IntFunction, LongFunction, DoubleFunction: arguments are of specified type, return type is parameterized
        // - ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized
        // - DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction:
        //   having both argument and return type defined as primitive types

        // Note: apply() method is replaced by special methods applyAsDouble(), applyAsInt(), etc.


        // Examples

        // general function:
        System.out.println("*** Function");
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println(half.apply(1));                  // returns 0.5
        System.out.println(half.apply(2));                  // returns 1.0
        System.out.println(half.apply(3));                  // returns 1.5

        // instead we can write
        System.out.println("*** IntToDoubleFunction");
        IntToDoubleFunction halfSpecial = a -> a / 2.0;
        System.out.println(halfSpecial.applyAsDouble(1));   // returns 0.5
        System.out.println(halfSpecial.applyAsDouble(2));   // returns 1.0
        System.out.println(halfSpecial.applyAsDouble(3));   // returns 1.5



        System.out.println("*** DoubleToIntFunction");
        DoubleToIntFunction divideByFive = a -> (int) (a / 5);
        System.out.println(divideByFive.applyAsInt(17));    // returns 3

    }


    public static void usageInComputeIfAbsent() {

        // Functions can be used in the argument of the Map.computeIfAbsent() method

        Map<String, Integer> myMap = new HashMap<>();
//        myMap.computeIfAbsent("Key", s -> s.length());
        myMap.computeIfAbsent("Key", String::length);           // method reference version (equivalent to s -> s.length())
        System.out.println(myMap.get("Key"));                   // returns 3
        myMap.computeIfAbsent("Key2", String::length);
        System.out.println(myMap.get("Key2"));                  // returns 4

        myMap.computeIfAbsent("Key2", s -> s.length() + 1);     // not absent
        System.out.println(myMap.get("Key2"));                  // returns 4
        myMap.computeIfAbsent("Key3", s -> s.length() + 5);
        System.out.println(myMap.get("Key3"));                  // returns 9

    }

}
