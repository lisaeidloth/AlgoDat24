package main.generics;


import java.util.LinkedList;
import java.util.List;

public class SuperExample {
    public static void main(String[] args) {
        List<Number> myNumberList = new LinkedList<>();
        List<Object> myObjectList = new LinkedList<>();
        List<Double> myDoubleList = new LinkedList<>();

        for(int i = 0; i < 10; i++) {
            addCurrentTemp(myNumberList); // works
            addCurrentTemp(myObjectList); // works as well
            // addCurrentTemp(myDoubleList); // does not work
        }
    }

    public static void addCurrentTemp(List<? super Integer> listToAdd) {
        // write / put example
        listToAdd.add(19 + (int)(Math.random() * 5));
    }

    public static void test(List<? super Integer> test) {
        Object a = test.get(0);
        // Number b = test.get(0);
        // Integer c = test.get(0);
        // Double d = test.get(0);
    }
}
