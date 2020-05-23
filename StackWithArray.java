package DataStructures;
import java.util.Scanner;

public class StackWithArray {
    int[] stack;
    int top;
    int MAXSIZE;

    StackWithArray(int... dataset) {
        top = -1;
        this.MAXSIZE = dataset.length * 2;
        stack = new int[MAXSIZE];

        for(int data : dataset) {
            push(data);
        }
    }

    StackWithArray(int size) {
        this.MAXSIZE = size;
        stack = new int[MAXSIZE];
        top = -1;
    }

    public void push(int data) {
        if(top <= MAXSIZE) {
            stack[++top] = data;
        }
        else
            System.out.println("Stack Overflow...");
    }

    public int pop() {
        return (top != -1) ? stack[top--] : -1;
    }

    public int peek() {
        return (top != -1) ? stack[top] : -1;
    }
 }

 class StackArrayMain {
    public static void main() {
        Scanner in = new Scanner(System.in);
        //Your test code goes here.
    }
 }