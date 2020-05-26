package DataStructures;

import java.util.Scanner;

public class DoublyLinkedList <type> {
    Node<type> head;
    Node<type> tail;
    int size;

    static class Node <type> {
        type data;
        Node<type> next;
        Node<type> prev;

        Node(type data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void createList(type... newNodeData) {
        for (type data : newNodeData) {
            Node<type> newNode = new Node<type>(data);
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
        for (Node<type> temp = this.head; temp != null; temp = temp.next) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void displayReverse() {
        for (Node<type> temp = this.tail; temp != null; temp = temp.prev) {
            System.out.println("Data : " + temp.data);
        }
    }

    public void add(type newData) {
        Node<type> node = new Node<type>(newData);
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.size++;
    }

    public void addBegin(type newData) {
        Node<type> node = new Node<type>(newData);
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        this.size++;
    }

    public void addBetween(type newData, int pos) {
        Node<type> node = new Node<type>(newData);
        int count = 0;
        Node<type> temp;

        if (pos == 1) {
            addBegin(node.data);
        } else if (pos > 1 && pos < size) {
            for (temp = this.head; count <= pos - 2; count++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next.prev = node;
            node.prev = temp;
            temp.next = node;
        } else
            add(node.data);
    }

    public type pop() {
        if(this.head != null) {
            type poppedValue = this.tail.data;
            this.tail = this.tail.prev;
            this.tail.next = null;
            return poppedValue;
        }
        return null;
    }

    public type shift() {
        if (this.head != null) {
            type shiftedValue = this.head.data;
            this.head = this.head.next;
            this.head.prev = null;
            return shiftedValue;
        }
        return null;
    }

    public boolean searchNode(type data) {
        Node<type> temp = this.head;
        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    public Node<type> getPreviousNode(type data) {
        Node<type> temp = this.head;

        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp.prev;
            }
        }
        return null;
    }

    public Node<type> getNode(type data) {
        Node<type> temp = this.head;
        for (temp = this.head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp;
            }
        }
        return null;
    }

    public void remove(type data) {
        Node<type> temp;
        if (searchNode(data)) {
            temp = getPreviousNode(data);
            temp.next = temp.next.next;
            temp.next.prev = temp;
        } else
            System.out.println("Node to be deleted is not found in the LinkedList.");
    }

    public void update(type oldData, type newData) {
        Node<type> nodeToBeUpdated = getNode(oldData);
        if (nodeToBeUpdated != null) nodeToBeUpdated.data = newData;
        else System.out.println("The node to be updated is not found in the LinkedList.");
    }
}

class DoublyLinkedListMain {
    public static void main(String[]args) {
        //Your test code goes your
        //DoublyLinkedList<> dll = new DoublyLinkedList<>();
    }
}
