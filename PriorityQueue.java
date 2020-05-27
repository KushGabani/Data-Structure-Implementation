package DataStructures;

import DataStructures.Heap;
import java.util.Scanner;

public class PriorityQueue<type extends Comparable<type>> {
    Heap<type> pqueue;
    PriorityQueue() {
        pqueue = new Heap<type>();
    }

    public void enqueue(type value) {
        pqueue.insertNode(value);
    }

    public type dequeue() {
        return pqueue.removeNode(0);
    }

    public type peek() {
        return pqueue.heap.get(0);
    }

    public void display() {
        pqueue.displayHeap();
    }

}

class PriorityQueueMain {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //Your test code goes here.

        System.out.print("Enter the value for the priority queue (e.g. like 1,2,3,4) \n:");
        String[] dataset = in.nextLine().split(",");

        for (String data : dataset) {
            pq.enqueue(Integer.parseInt(data));
        }

        pq.display();

        System.out.print("Enter a value to add in a priority Queue. \n:");
        int valueToBeAdded = in.nextInt();
        pq.enqueue(valueToBeAdded);
        pq.display();

        System.out.print("Type 'y' to remove the value with the most priority in a priority Queue. \n:");
        String choice = in.next();
        if(choice.equals("y"))   {    System.out.println("Removed element is of priority: " + pq.dequeue());    }

        System.out.println("The next element to be processed is with priority : " + pq.peek());

        pq = null;
    }
}