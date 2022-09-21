package functionalinterfaces;

import java.util.function.Supplier;

public class SupplierInterfaceExample {

    public static void supplierExample() {

        // Supplier interface
        // - takes no argument, produces 1 result
        // - has 1 method: get()
        // - introduced in Java 8
        // - often used for lazy evaluation

        // subtypes: LongSupplier, IntSupplier, DoubleSupplier and BooleanSupplier


        // Example
        System.out.println("*** Supplier<Double>");
        Supplier<Double> squareRoot = Math::random;
        System.out.println(squareRoot.get());


        // Example for lazy evaluation using supplier
        // => lazy evaluation = delay evaluation of an expression until its value is needed
        System.out.println("*** Lazy evaluation");
        System.out.println(squareLazy(() -> 5.0));

    }

    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }


}
