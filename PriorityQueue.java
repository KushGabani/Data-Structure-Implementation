package DataStructures;

import DataStructures.Heap;
import java.util.Scanner;

public class PriorityQueue extends Heap {
    PriorityQueue() {
        super(16,7,14,2,9,3);
    }

    PriorityQueue(int... values) {
        super(values);
    }

    public void enqueue(int value) {
        insertNode(value);
    }

    public int dequeue() {
        return removeNode(0);
    }

    public int peek() {
        return heap.get(0);
    }

}

class PriorityQueueMain {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value for the priority queue (e.g. like 1,2,3,4) \n:");
        String[] inputAsStr = in.nextLine().split(",");
        int[] dataSet = new int[inputAsStr.length];

        for(int i = 0; i < inputAsStr.length; i++) {
            dataSet[i] = Integer.parseInt(inputAsStr[i]);
        }

        PriorityQueue pq = new PriorityQueue(dataSet);
        pq.displayHeap();

        System.out.print("Enter a value to add in a priority Queue. \n:");
        int valueToBeAdded = in.nextInt();
        pq.enqueue(valueToBeAdded);
        pq.displayHeap();

        System.out.print("Type 'y' to remove the value with the most priority in a priority Queue. \n:");
        String choice = in.next();
        if(choice.equals("y"))   {    System.out.println("Removed element is of priority: " + pq.dequeue());    }


        System.out.println("The next element to be processed is with priority : " + pq.peek());

        pq = null;
    }
}