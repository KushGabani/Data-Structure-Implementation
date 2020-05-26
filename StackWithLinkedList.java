package DataStructures;

public class StackWithLinkedList <type>{
    LinkedList<type> stack;

    @SafeVarargs
    StackWithLinkedList(type... dataset) {
        stack = new LinkedList<type>();

        for(type data : dataset) {
            push(data);
        }
    }

    public void push(type data) {
        stack.addBegin(data);
    }

    public type pop() {
        if(stack.size != 0) {
            type poppedValue = stack.head.data;
            stack.head = stack.head.next;
            stack.size--;
            return poppedValue;
        }
        return null;
    }

    public type peek() {
        return stack.head.data;
    }
}

class StackLLMain {
    public static void main(String[]args) {
        //Your test code goes here.
    }
}