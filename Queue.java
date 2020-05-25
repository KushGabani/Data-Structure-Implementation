package DataStructures;

public class Queue {
    int[] queue;
    int front;
    int rear;
    int size;

    Queue(int size) {
        this.size = size;
        queue = new int[size];
        rear = front = -1;
    }

    Queue(int... dataset) {
        size = dataset.length * 2;
        queue = new int[size];
        rear = -1;
        front = -1;

        for(int data : dataset) {
            enqueue(data);
        }
    }

    public void enqueue(int data) {
        if(rear != size)
            queue[++rear] = data;
        else
            System.out.println("There is no space in the queue.");
    }

    public int dequeue() {
        if(front != -1 && front != rear)
            return queue[front++];
        return -1;
    }
}

class QueueMain {
    public static void main(String[]args) {
        //Your test code goes here.
    }
}