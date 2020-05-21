package DataStructures;

import java.util.Scanner;
import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> heap = new ArrayList<>();

    /* Here is how we implement a heap as an array and retrieve values of the nodes.
     * Parent(i) is at (i-1)/2\
     * LeftChild(i) is at 2i + 1
     * RightChild(i) is at 2i + 2
     */

    // Getting the input of the dataSet to be formatted as a heap.
    public Heap(int... array) {
        for (int element : array) {
            heap.add(element);
        }
    }

    // Setting the default dataSet to be formatted as a heap.
    Heap() {
        this(8,2,9,4,3,7,16,14,1,10);
    }

    //Get the index of the left child of the node, say 'i'
    private int getLeftChild(ArrayList<Integer> array, int index) {
        return (2 * index + 1 < heap.size()) ? 2 * index + 1 : -1;
    }

    //Get the index of the right child of the node, sat 'i'
    private int getRightChild(ArrayList<Integer> array, int index) {
        return (2 * index + 2 < heap.size()) ? 2 * index + 2 : -1;
    }

    //A trivial function to elements of the array
    private void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    //This functions swaps the value in their correct place following the heap rep. invariant (representation invariant)
    // Time complexity - O(log(n))
    public void heapify(int i) {
        int left = getLeftChild(heap, i);
        int right = getRightChild(heap, i);
        int largestIndex = i;

        if(left != -1 && right == -1 && heap.get(i) < heap.get(left))
            largestIndex = left;
        else if(right != -1 && left == -1 && heap.get(i) < heap.get(right))
            largestIndex = right;
        else if (left != -1 && right != -1) {
            if(heap.get(i) < heap.get(left) || heap.get(i) < heap.get(right)) {
                if(heap.get(left) > heap.get(right))
                    largestIndex = left;
                else
                    largestIndex = right;
            }
        }

        if (largestIndex != i) {
            swap(largestIndex, i);
            heapify(largestIndex);
        }
    }

    //This functions set each value to their correct place using heapify
    //NOTE : Here, we start from the middle value of the array down to the first element because
    //       By default, all the values after the middle element are leafs of the heap and thus by default
    //       it follows the heap rep. invariant i.e. "All the child values must be smaller than the parent and its ancester."
    public void maxHeap() {
        for(int i = Math.max(0, heap.size()/2 - 1); i >= 0 ; i--) {
            heapify(i);
        }
    }

    //To display the heap, we can traverse through the heap linearly because it is visualised in an array.
    public void displayHeap() {
        for (int element: heap) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //Inserting a value into the heap.
    // We first add the new value to the last place in the array. Then we use heapify() to satisfy the rep. invariant
    public void insertNode(int value) {
        heap.add(value);
        maxHeap();
    }

    //Remove a value from the heap at an index
    public int removeNode(int index) {
        //Swap the required value and the last value from the heap.
        //Then remove the last value from the heap.
        //Again run heapify() on that heap

        swap(index, heap.size() - 1);
        int poppedValue = heap.remove(heap.size() - 1);
        maxHeap();
        return poppedValue;
    }

    public void heapSort() {
        int[] sortedList = new int[heap.size()];

        for (int i = 0; i < sortedList.length; i++) {
            sortedList[i] = removeNode(0);
            System.out.print(sortedList[i] + " ");
        }

    }
}


class HeapMain {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        //Your test code goes here


        System.out.println("Enter the dataset to enter in the heap (e.g. like 16,14,9,4,10.....\n:");
        String[] inputAsStr = in.next().split(",");
        int[] dataSet = new int[inputAsStr.length];
        for(int i = 0; i < inputAsStr.length; i++) {
            dataSet[i] = Integer.parseInt(inputAsStr[i]);
        }

        Heap heap = new Heap(dataSet);

        System.out.println("heap before Heap Sort. \n:");
        heap.displayHeap();
        heap.maxHeap();
        System.out.println("heap after Heap Sort. \n:");
        heap.displayHeap();

        /*
        System.out.print("Enter the element you want to enter in the heap \n: ");
        int valueToAdd = in.nextInt();

        heap.insertNode(valueToAdd);
        System.out.println("Heap after inserting the value : " + valueToAdd);
        heap.displayHeap();

        System.out.print("Enter the index to be deleted from the array \n:");
        int toBeDeleted = in.nextInt();
        heap.removeNode(toBeDeleted);
        */

        heap.heapSort();

        heap = null;
    }
}
