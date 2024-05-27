package main.datastructures.stack;

import java.util.Stack;

public class StacksQueue {

    private final Stack<Integer> stackA;
    private final Stack<Integer> stackB;


    public StacksQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void enqueue(int toPush) {
        stackA.push(toPush);
    }

    public int dequeue() {
        if(stackB.isEmpty()) {
            while (!stackA.isEmpty()) stackB.push(stackA.pop());
        }
        return stackB.pop();
    }


    public static void main(String[] args) {
        StacksQueue queue = new StacksQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

//        queue.enqueue(5);
//        queue.enqueue(6);
//        queue.enqueue(7);
//        queue.enqueue(8);
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//
//        queue.enqueue(9);
//
//        System.out.println(queue.dequeue());
    }

}
