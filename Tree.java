package DataStructures;

import java.util.Scanner;

public class Tree<type extends  Comparable<type>> {
    Node<type> root;
    int size;

    public static class Node<type> {
        public type data;
        Node<type> leftChild;
        Node<type> rightChild;
        Node<type> parent;

        Node(type data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

    }

    Tree() {
        this.root = null;
        this.size = 0;
    }

    public void addNode(Node<type> newNode, Node<type> currParent) {
        if(this.size == 0) {
            this.root = newNode;
            this.size++;
        }
        else if (newNode.data.compareTo(currParent.data) <= 0) {
            if (currParent.leftChild == null) {
                currParent.leftChild = newNode;
                newNode.parent = currParent;
                this.size++;
            }
            else
                addNode(newNode, currParent.leftChild);
        } else {
            if (currParent.rightChild == null) {
                currParent.rightChild = newNode;
                newNode.parent = currParent;
                this.size++;
            }
            else
                addNode(newNode, currParent.rightChild);
        }
    }

    public void displayTree(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println("Inorder Traversal : \n");
                inorderTraversal(this.root);
            }
            case 2 -> {
                System.out.println("Preorder Traversal : \n");
                preorderTraversal(this.root);
            }
            case 3 -> {
                System.out.println("Postorder Traversal : \n");
                postorderTraversal(this.root);
            }
        }
    }

    private boolean hasLeftChild(Node<type> current) {
        return (current.leftChild != null && current.rightChild == null);
    }

    private boolean hasRightChild(Node<type> current) {
        return (current.leftChild == null && current.rightChild != null);
    }

    private boolean hasNoChild(Node<type> current) {
        return current.leftChild == null && current.rightChild == null;
    }

    private boolean hasBothChild(Node<type> current) {
        return current.leftChild != null && current.rightChild != null;
    }

    private boolean hasOneChild(Node<type> current) {
        return (current.leftChild == null && current.rightChild != null) || (current.leftChild != null && current.rightChild == null);
    }

    public void inorderTraversal(Node<type> currNode) {
        if (currNode != null) {
            inorderTraversal(currNode.leftChild);
            System.out.println(currNode.data + "");
            inorderTraversal(currNode.rightChild);
        }
    }

    public void preorderTraversal(Node<type> currNode) {
        if(currNode != null) {
            System.out.println(currNode.data + " ");
            preorderTraversal(currNode.leftChild);
            preorderTraversal(currNode.rightChild);
        }
    }

    public void postorderTraversal(Node<type> currNode) {
        if (currNode != null) {
            preorderTraversal(currNode.leftChild);
            preorderTraversal(currNode.rightChild);
            System.out.println(currNode.data + " ");
        }
    }

    public boolean searchNode(Node<type> currNode, type x) {
        if ( currNode != null) {
            if(currNode.data.compareTo(x) == 0)
                return true;
            else if(x.compareTo(currNode.data) < 0)
                return searchNode(currNode.leftChild, x);
            else
                return searchNode(currNode.rightChild, x);
        }

        return false;
    }

    public Node<type> getNode(Node<type> currNode, type x) {
        if ( currNode != null) {
            if(currNode.data.compareTo(x) == 0)
                return currNode;
            else if(x.compareTo(currNode.data) < 0)
                return getNode(currNode.leftChild, x);
            else
                return getNode(currNode.rightChild, x);
        }
        return null;
    }

    public type min() {
        Node<type> temp = this.root;
        while (temp.leftChild != null) {
            temp = temp.leftChild;
        }
        return temp.data;
    }

    public type max() {
        Node<type> temp = this.root;
        while (temp.rightChild != null) {
            temp = temp.rightChild;
        }
        return temp.data;
    }

    public Node<type> min(Node<type> currNode) {
        Node<type> temp = currNode;
        if(temp != null) {
            while (temp.leftChild != null) {
                temp = temp.leftChild;
            }

            return temp;
        }
        else
            return null;
    }

    public Node<type> max(Node<type> currNode) {
        Node<type> temp = currNode;
        if(temp != null) {
            while (temp.rightChild != null) {
                temp = temp.rightChild;
            }

            return temp;
        }
        else
            return null;
    }


    public Node<type> remove(Node<type> currNode, type data) {
        if (currNode == null) return currNode;
        if(data.compareTo(currNode.data) < 0)
            currNode.leftChild = remove(currNode.leftChild, data);
        else if (data.compareTo(currNode.data) > 0)
            currNode.rightChild = remove(currNode.rightChild, data);
        else {
            //When the node is Found !

            //Case 1 & 2 : If the node have at most 1 child.
            if(currNode.leftChild == null)
                return currNode.rightChild;
            else if (currNode.rightChild == null)
                return currNode.leftChild;

            //Case 3 : If the node to be deleted has exactly 2 nodes.
            Node<type> minInRightTree = min(currNode.rightChild);
            currNode.data = minInRightTree.data;
            currNode.rightChild = remove(currNode.rightChild, currNode.data);
        }
        return currNode;
    }
}

class TreeMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tree<Integer> bst = new Tree<Integer>();

        //Your test goes here.

        int[] dataset = {7,2,12,1,5,8,16,4,6,15};

        //converting string type node data into a list of integers that can be passed to the function.
        for (int value : dataset) {
            bst.addNode(new Tree.Node<>(value), bst.root);
        }

        //Creating a BST with the data given.
        bst.displayTree(1);     //Inorder Traversal
        bst.displayTree(2);        //Preorder Traversal
        bst.displayTree(3);        //Postorder Traversal

        System.out.println("--------------------------------------");

        int i = 0;
        //Searching a node in a BST
        while(i < 2) {
            System.out.print("Enter a node to be searched. \n: ");
            int x = in.nextInt();
            boolean nodeFound = bst.searchNode(bst.root, x);
            if (nodeFound)
                System.out.println("Node Found in the Binary Tree.");
            else
                System.out.println("Node is not found in the Binary Tree.");

            i++;
        }

        System.out.println("--------------------------------------");

        //Getting Minimum and Maximum elements in the tree.
        System.out.println("Minimum element in the tree is : " + bst.min() );
        System.out.println("Maximum element in the tree is : " + bst.max() );

        System.out.println("--------------------------------------");

        System.out.println("Enter a node to be deleted : ");
        int toBeDeleted = in.nextInt();

        Tree.Node<Integer> temp = bst.remove(bst.root, toBeDeleted);
        bst.size--;
        bst.displayTree(1);
        System.out.println("--------------------------------------");
        bst.displayTree(2);

        bst = null;
    }
}