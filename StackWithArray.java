package DataStructures;
import java.util.ArrayList;
import java.util.Scanner;

public class StackWithArray<type> {
    ArrayList<type> stack;
    int top;

    StackWithArray(int... dataset) {
        top = -1;
        stack = new ArrayList<type>();
    }

    public void push(type data) {
        stack.set(++top, data);
    }

    public type pop() {
        return (top != -1) ? stack.get(top--) : null;
    }

    public type peek() {
        return (top != -1) ? stack.get(top) : null;
    }
 }

 class StackArrayMain {
    public static void main() {
        Scanner in = new Scanner(System.in);
        //Your test code goes here.
    }
 }