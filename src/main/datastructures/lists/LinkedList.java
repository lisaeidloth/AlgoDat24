package main.datastructures.lists;

import main.datastructures.stack.MyStack;

public class LinkedList implements MyStack {
    private Node head;

    public void insert(String data) {
        //Sonderfall Liste leer
        if (head == null) head = new Node(data);
        else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
    }

    public void insert(String data, int pos) {
        // wenn vorne eingefügt werden soll oder Liste leer ist
        if (pos == 0 || head == null) insert(data);
            // ansonsten iteriere zu Position,
            // starte bei head
        else {
            // wenn i++ (siehe unten) verwendet, dann hier bei i = 1 starten
            int i = 0;
            Node current = head;
            while (current.next != null && ++i < pos) {
                current = current.next;
                // i++
            }
            // "umhängen" der Pointer auf nächsten Knoten
            Node temp = new Node(data);
            temp.next = current.next;
            current.next = temp;
        }
    }

    public String delete(int pos) {
        Node current = head;
        // Sonderfall: ist leer
        if (isEmpty()) return null;
        //Sonderfall delete head
        if (pos == 0) {
            // head wird gelöscht, also benötigen wir einen neuen head
            head = current.next;
            // gib den Wert des heads zurück (gelöschtes Element)
            return current.data;
        }
        // zwei Variablen für "Zeiger" auf Element vor und Element selbst
        Node prev = current;
        current = current.next;
        int i = 1;
        // iterieren bis Element gefunden wurde
        while (current != null) {
            if (pos == i++) {
                prev.next = current.next;
                return current.data;
            }
            // beide "Zeiger" nach rechts wandern lassen
            prev = current;
            current = current.next;
            // i++;
        }
        return null;
    }

    public String get(int pos) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (pos == i++) {
                return current.data;
            }
            current = current.next;
            // i++;
        }
        return null;
    }

    public boolean isFull() {
        return false;
    }

    @Override
    public void push(String elem) {
        insert(elem, 0);
    }

    @Override
    public String pop() {
        return delete(0);
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {

        Node(String data) {
            this.data = data;
        }

        private String data;
        private Node next;
    }
}
