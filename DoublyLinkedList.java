package DataStructures;

import java.util.Scanner;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node() {
            this(0);
        }
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void createList(int... newNodeData) {
        for (int data : newNodeData) {
            Node newNode = new Node(data);
            if (size == 0) {
                this.tail = this.head = newNode;
                this.size++;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
                this.size++;
            }
        }
    }

    public void displayList() {
        for (Node temp = this.head; temp != null; temp = temp.next) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void displayReverse() {
        for (Node temp = this.tail; temp != null; temp = temp.prev) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void add(Node node) {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.size++;
    }

    public void addBegin(Node node) {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        this.size++;
    }

    public void addBetween(Node node, int pos) {
        int count = 0;
        Node temp;

        if (pos == 1) {
            addBegin(node);
        } else if (pos > 1 && pos < size) {
            for (temp = this.head; count <= pos - 1; count++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next.prev = node;
            node.prev = temp;
            temp.next = node;
        } else
            add(node);
    }

    public void pop() {
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

    public void shift() {
        if (this.head != null) {
            this.head = this.head.next;
            this.head.prev = null;
        }
    }

    public boolean searchNode(int data) {
        Node temp = this.head;
        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    public Node getPreviousNode(int data) {
        Node temp = this.head;

        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp.prev;
            }
        }
        return null;
    }

    public Node getNode(int data) {
        Node temp = this.head;
        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp;
            }
        }
        return null;
    }

    public void remove(int data) {
        Node temp;
        if (searchNode(data)) {
            temp = getPreviousNode(data);
            temp.next = temp.next.next;
            temp.next.prev = temp;
        } else
            System.out.println("Node to be deleted is not found in the LinkedList.");
    }

    public void update(int oldData, int newData) {
        Node nodeToBeUpdated = getNode(oldData);
        if (nodeToBeUpdated != null) nodeToBeUpdated.data = newData;
        else System.out.println("The node to be updated is not found in the LinkedList.");
    }
}

class DoublyLinkedListMain {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        //Your test code goes your
    }
}
