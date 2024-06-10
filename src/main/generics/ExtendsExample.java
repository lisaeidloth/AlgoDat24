package main.generics;

import java.util.List;

public class ExtendsExample {

    public static void main(String[] args) {
        List<Integer> myIntegerList = List.of(1,2,3,4,5);
        List<Double> myDoubleList = List.of(5.2, 5.3, 5.4);
        List<Object> myObjectList = List.of("asd", 34, 5.8);

        for(int i = 0; i < 10; i++) {
            System.out.println(sum(myIntegerList)); // works
            System.out.println(sum(myDoubleList)); // works as well
            // System.out.println(sum(myObjectList)); // does not work
        }
    }

    public static Number sum(List<? extends Number> listToSum) {
        // read / get example
        return listToSum.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void test(List<? extends Number> test) {
        // write / put example
        // test.add(5.0);
        // test.add("test");
    }
}
