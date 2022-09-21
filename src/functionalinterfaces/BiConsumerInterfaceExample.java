package functionalinterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerInterfaceExample {


    public static void biConsumerExample() {

        // BiConsumer interface
        // - takes 2 arguments, returns nothing
        // - has 2 methods: accept(), andThen()
        // - introduced in Java 8
        // - used in method Map.forEach() as argument


        System.out.println("*** BiConsumer<Integer, Integer>: example for adding two integer numbers");
        BiConsumer<Integer, Integer> addTwoNumbers = (a, b) -> System.out.println(a + b);
        addTwoNumbers.accept(5, 7);     // returns 12


        System.out.println("*** BiConsumer<T, T>: example for adding two objects using a generic method");
        addTwo(5, 7, (a, b) -> System.out.println(a + b));
        addTwo("Hello", " world!", (a, b) -> System.out.println(a + b));


        System.out.println("*** BiConsumer<String, String>: example with Map.forEach()");
        Map<String, String> myMap = new HashMap<>();
        String[][] stringArray = {{"Key1", "Value1"}, {"Key2", "Value2"}, {"Key3", "Value3"}};

        // Fill Map with array values
        for (String[] strings : stringArray) {
            myMap.put(strings[0], strings[1]);
        }

        // Create BiConsumer for showing key-value pairs
        BiConsumer<String, String> showEntry = (key, value) -> System.out.println("Key \"" + key + "\" has value: " + value);
        // Perform BiConsumer
        myMap.forEach(showEntry);

    }

    public static <T> void addTwo(T a, T b, BiConsumer<T, T> consumer) {
        consumer.accept(a, b);
    }


}
