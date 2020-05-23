package DataStructures;

import java.util.Scanner;

public class LinkedList {
    Node head;
    Node tail;
    int size;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            this.data = 0;
            this.next = null;
        }
    }

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void createList(int... newNodeData) {
        for(int data : newNodeData) {
            Node newNode = new Node(data);
            if(size == 0) {
                this.tail = this.head = newNode;
                this.size++;
            }
            else {
                this.tail.next = newNode;
                this.tail = newNode;
                this.size++;
            }
        }
    }

    public void displayList() {
        for(Node temp = this.head; temp != null; temp = temp.next) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void add(Node node)  {
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void addBegin(Node node) {
        if(this.head != null) {
            this.head = node;
        }
        else {
            node.next = this.head;
            this.head = node;
        }

        this.size++;
    }

    public void addBetween(Node node, int pos) {
        int count = 0;
        Node temp;

        if(pos == 1) {
            addBegin(node);
        }
        else if(pos > 1 && pos < size){
            for(temp = this.head; count <= pos - 1 ;count++) { temp = temp.next; }

            node.next = temp.next;
            temp.next = node;
        }
        else
            add(node);

    }

    public int pop() {
        if(this.head != null) {
            Node temp = this.head;
            for (int i = 0; i < size; i++) {
                temp = temp.next;
            }
            int poppedValue = temp.next.data;
            temp.next = null;
            this.tail = temp;
            return poppedValue;
        }
        return -1;
    }

    public void shift() {
        if(this.head != null) this.head = this.head.next;
    }

    public boolean searchNode(int data) {
        Node temp = this.head;
        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return true;    }
        }
        return false;
    }

    public Node getPreviousNode(int data) {
        Node temp = this.head;
        Node prevNode = new Node();

        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return prevNode;    }
            prevNode = temp;
        }
        return null;
    }

    public Node getNode(int data) {
        Node temp = this.head;
        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return temp;    }
        }
        return null;
    }

    public void remove(int data) {
        Node temp;
        if (searchNode(data)) {
            temp = getPreviousNode(data);
            temp.next = temp.next.next;
        }
        else
            System.out.println("Node to be deleted is not found in the LinkedList.");
    }

    public void update(int oldData, int newData) {
        Node nodeToBeUpdated = getNode(oldData);
        if(nodeToBeUpdated != null) nodeToBeUpdated.data = newData;
        else System.out.println("The node to be updated is not found in the LinkedList.");
    }
}

class LinkedListMain {
    public static void main(String[]args) {
        // Your test code goes here........
    }
}