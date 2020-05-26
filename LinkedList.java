package DataStructures;

import java.util.Scanner;

public class LinkedList <type> {
    Node<type> head;
    Node<type> tail;
    int size;
    static class Node <type> {
        type data;
        Node<type> next;

        Node(type data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            this.data = null;
            this.next = null;
        }
    }

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void createList(type... newNodeData) {
        for(type data : newNodeData) {
            Node<type> newNode = new Node<type>(data);
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
        for(Node<type> temp = this.head; temp != null; temp = temp.next) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void add(type newData)  {
        Node<type> node = new Node<type>(newData);
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void addBegin(type newData) {
        Node<type> node = new Node<type>(newData);
        if(this.head != null) {
            node.next = this.head;
        }
        this.head = node;
        this.size++;
    }

    public void addBetween(type newData, int pos) {
        Node<type> node = new Node<type>(newData);
        int count = 0;
        Node<type> temp = this.head;

        if(pos == 1) {
            addBegin(node.data);
        }
        else if(pos > 1 && pos < size){
            while(count < pos - 2) {
                count++;
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }
        else
            add(node.data);

    }

    public type pop() {
        if(this.head != null) {
            Node<type> temp;
            for (temp = this.head; temp.next.next != null; temp = temp.next);

            type poppedValue = temp.next.data;
            temp.next = null;
            this.tail = temp;
            return poppedValue;
        }
        return null;
    }

    public type shift() {
        if(this.head != null) {
            type removed = this.head.data;
            this.head = this.head.next;
            return removed;
        }
        return null;
    }

    public boolean searchNode(type data) {
        Node<type> temp = this.head;
        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return true;    }
        }
        return false;
    }

    public Node<type> getPreviousNode(type data) {
        Node<type> temp = this.head;
        Node<type> prevNode = new Node<type>();

        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return prevNode;    }
            prevNode = temp;
        }
        return null;
    }

    public Node<type> getNode(type data) {
        Node<type> temp = this.head;
        for(temp = this.head; temp != null; temp = temp.next)
        {
            if(temp.data == data) {     return temp;    }
        }
        return null;
    }

    public void remove(type data) {
        Node<type> temp;
        if (searchNode(data)) {
            temp = getPreviousNode(data);
            temp.next = temp.next.next;
        }
        else
            System.out.println("Node to be deleted is not found in the LinkedList.");
    }

    public void update(type oldData, type newData) {
        Node<type> nodeToBeUpdated = getNode(oldData);
        if(nodeToBeUpdated != null) nodeToBeUpdated.data = newData;
        else System.out.println("The node to be updated is not found in the LinkedList.");
    }
}

class LinkedListMain {
    public static void main(String[]args) {
        // Your test code goes here........
        //LinkedList<> list = new LinkedList<>();
    }
}