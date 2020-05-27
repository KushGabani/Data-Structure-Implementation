package DataStructures;

import java.util.ArrayList;

public class Queue <type> {
    ArrayList<type> queue;
    int front;
    int rear;

    Queue() {
        queue = new ArrayList<type>();
        rear = front = -1;
    }

    public void enqueue(type data) {
        queue.set(++rear, data);
    }

    public type dequeue() {
        return (front != -1 && front != rear) ? queue.get(front++) : null;
    }

    public type peek() {
        return (front != 1 && front != rear) ? queue.get(front) : null;
    }
}

class QueueMain {
    public static void main(String[]args) {
        //Your test code goes here.
    }
}