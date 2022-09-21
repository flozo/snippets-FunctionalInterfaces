package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {


    public static void consumerExample() {

        // Consumer interface
        // - takes 1 argument, returns nothing
        // - has 2 methods: accept(), andThen()
        // - introduced in Java 8

        // subtypes: DoubleConsumer, IntConsumer, LongConsumer


        // Example using method reference
        System.out.println("*** Consumer<Integer>: example using method reference");
        Consumer<Integer> showNumber = System.out::println;
        showNumber.accept(10);


        System.out.println("*** Consumer<Double>: example using lambda expression");
        Consumer<Double> showDouble = a -> System.out.println(a * 2);
        showDouble.accept(10.0);

        System.out.println("*** Consumer<Double>: example using andThen() method and lambda expression");
        Consumer<Double> showDouble2 = a -> System.out.println(a * 2);
        Consumer<Double> showDouble3 = a -> System.out.println(a * 3);
        showDouble2.andThen(showDouble3).accept(5.0);

        System.out.println("*** Consumer<List<Integer>>: example of multiplying every element of a list by 3");
        // Create Consumer
        Consumer<List<Integer>> multiply = list -> list.replaceAll(a -> a * 3);

        // Create list of integers
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        // Perform Consumer "multiply"
        multiply.accept(integerList);

        // Show result by iterating over list elements
        for (Integer element:integerList) {
            System.out.println(element);
        }

        System.out.println("*** Consumer<List<Integer>>: use a second Consumer to display the list elements");
        // Create Consumer for displaying list elements
        Consumer<List<Integer>> showList = list -> list.forEach(System.out::println);

        // Show result by using the Consumer "showList"
        showList.accept(integerList);

    }
}
