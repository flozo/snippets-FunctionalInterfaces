package functionalinterfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInterfaceExample {


    public static void predicateExample() {

        // Predicate interface
        // - takes 1 argument, returns a boolean value
        // - has 5 methods: and(), isEqual(), negate(), or(), test()
        // - introduced in Java 8
        // - purpose: move conditions to a central place; enable testing conditions separately


        System.out.println("*** Predicate<Integer>: testing a number of being greater than 10");
        Predicate<Integer> greaterThanTen = a -> (a > 10);
        System.out.println(greaterThanTen.test(9));     // returns false
        System.out.println(greaterThanTen.test(10));    // returns false
        System.out.println(greaterThanTen.test(11));    // returns true


        System.out.println("*** Predicate<Integer>: example for predicate chaining using and(); test if 10 < number < 20");
        Predicate<Integer> lessThanTwenty = a -> (a < 20);
        System.out.println(greaterThanTen.and(lessThanTwenty).test(10));     // returns false
        System.out.println(greaterThanTen.and(lessThanTwenty).test(15));     // returns true
        System.out.println(greaterThanTen.and(lessThanTwenty).test(20));     // returns false


        System.out.println("*** Predicate<Integer>: example for predicate chaining using and() and negate(); test if NOT 10 < number < 20");
        System.out.println(greaterThanTen.and(lessThanTwenty).negate().test(10));    // returns true
        System.out.println(greaterThanTen.and(lessThanTwenty).negate().test(15));    // returns false
        System.out.println(greaterThanTen.and(lessThanTwenty).negate().test(20));    // returns true


        System.out.println("*** Predicate<Integer>: example for predicate chaining using or(); test if number < 10 or number > 20");
        Predicate<Integer> lessThanTen = a -> (a < 10);
        Predicate<Integer> greaterThanTwenty = a -> (a > 20);
        System.out.println(lessThanTen.or(greaterThanTwenty).test(5));      // returns true
        System.out.println(lessThanTen.or(greaterThanTwenty).test(15));     // returns false
        System.out.println(lessThanTen.or(greaterThanTwenty).test(25));     // returns true

        predicateForFilteringAList();
        predicateForFilteringAMap();
    }

    public static void predicateForFilteringAList() {

        System.out.println("*** Predicate<String>: example using a Predicate for filtering a List");
        Predicate<String> stringLengthMax5 = s -> s.length() <= 5;
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abdce", "abcdef", "abcdefg", "abcdefgh");

        List<String> filteredStrings = strings.stream().filter(stringLengthMax5).collect(Collectors.toList());
        System.out.println(filteredStrings);

        Predicate<String> endsWithF = s -> s.endsWith("f");
        List<String> filteredStrings2 = strings.stream().filter(endsWithF).collect(Collectors.toList());
        System.out.println(filteredStrings2);

    }

    public static void predicateForFilteringAMap() {

        System.out.println("*** Predicate<String>: example using a Predicate for filtering a Map");
        Predicate<String> keyEndsWithNumber = s -> s.endsWith("number");
        Map<String, String> myMap = new HashMap<>();
        myMap.put("a.number", "123");
        myMap.put("ab", "hello");
        myMap.put("abc.number", "456");
        myMap.put("abcd", "world");
        myMap.put("abcde.number", "789");

//        Map<String, String> filteredMap = myMap.entrySet().stream().filter(map -> map.getKey().endsWith("number")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<String, String> filteredMap = myMap.entrySet()
                .stream()
                .filter(entry -> keyEndsWithNumber.test(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Use Consumer to display Map entries
        Consumer<Map<String, String>> showMapEntries = map -> map.forEach((key, value) -> System.out.println(key + " = " + value));

        showMapEntries.accept(filteredMap);

    }

}
