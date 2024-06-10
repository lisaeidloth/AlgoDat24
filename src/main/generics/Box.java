package main.generics;

public class Box<T> {
    private T field;

    public Box(T initValue) {
        field = initValue;
    }

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
