package DataStructures;

public class StackWithLinkedList extends LinkedList{

    StackWithLinkedList(int... dataset) {
        super();

        for(int data : dataset) {
            push(data);
        }
    }

    StackWithLinkedList() {
        this(5,3,4,7,8,2,1);
    }

    public void push(int data) {
        addBegin(new Node(data));
    }

    public int pop() {
        if(size != 0) {
            Node temp = this.head;
            int poppedValue = temp.data;
            this.head = this.head.next;
            temp = null;
            size--;
            return poppedValue;
        }
        return -1;
    }

    public Node peek() {
        return this.head;
    }
}

class StackLLMain {
    public static void main(String[]args) {
        //Your test code goes here.
    }
}