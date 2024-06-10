package main.generics;

public class BoxTest {

    public static void main(String[] args) {
        Box<String> myBox = new Box<>("Hello!");
        String a = myBox.getField();

        Box<String> anotherBox = new Box<>("5");
        String b = anotherBox.getField();
        System.out.println(b);
    }
}
