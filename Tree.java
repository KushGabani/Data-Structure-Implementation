package DataStructures;

import java.util.Scanner;

public class Tree {
    Node root;
    int size;

    static class Node {
        public int data;
        Node leftChild;
        Node rightChild;
        Node parent;

        Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

        public Node() {
            this(0);
        }
    }

    Tree() {
        this.root = null;
        this.size = 0;
        createTree(7,2,12,1,5,8,16,4,6,15);
    }

    public void addNode(Node newNode, Node currParent) {
        if (newNode.data <= currParent.data) {
            if (currParent.leftChild == null) {
                currParent.leftChild = newNode;
                newNode.parent = currParent;
            }
            else
                addNode(newNode, currParent.leftChild);
        } else {
            if (currParent.rightChild == null) {
                currParent.rightChild = newNode;
                newNode.parent = currParent;
            }
            else
                addNode(newNode, currParent.rightChild);
        }
    }

    public void createTree(int... nodes) {
        for (int data : nodes) {
            Node node = new Node(data);
            if (this.size == 0) {
                this.root = node;
                this.size++;
            } else {
                addNode(node, this.root);
                this.size++;
            }
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

    private boolean hasLeftChild(Node current) {
        return (current.leftChild != null && current.rightChild == null);
    }

    private boolean hasRightChild(Node current) {
        return (current.leftChild == null && current.rightChild != null);
    }

    private boolean hasNoChild(Node current) {
        return current.leftChild == null && current.rightChild == null;
    }

    private boolean hasBothChild(Node current) {
        return current.leftChild != null && current.rightChild != null;
    }

    private boolean hasOneChild(Node current) {
        return (current.leftChild == null && current.rightChild != null) || (current.leftChild != null && current.rightChild == null);
    }

    public void inorderTraversal(Node currNode) {
        if (currNode != null) {
            inorderTraversal(currNode.leftChild);
            System.out.println(currNode.data + "");
            inorderTraversal(currNode.rightChild);
        }
    }

    public void preorderTraversal(Node currNode) {
        if(currNode != null) {
            System.out.println(currNode.data + " ");
            preorderTraversal(currNode.leftChild);
            preorderTraversal(currNode.rightChild);
        }
    }

    public void postorderTraversal(Node currNode) {
        if (currNode != null) {
            preorderTraversal(currNode.leftChild);
            preorderTraversal(currNode.rightChild);
            System.out.println(currNode.data + " ");
        }
    }

    public boolean searchNode(Node currNode, int x) {
        if ( currNode != null) {
            if(currNode.data == x)
                return true;
            else if(x < currNode.data)
                return searchNode(currNode.leftChild, x);
            else
                return searchNode(currNode.rightChild, x);
        }

        return false;
    }

    public Node getNode(Node currNode, int x) {
        if ( currNode != null) {
            if(currNode.data == x)
                return currNode;
            else if(x < currNode.data)
                return getNode(currNode.leftChild, x);
            else
                return getNode(currNode.rightChild, x);
        }
        return null;
    }

    public int min() {
        Node temp = this.root;
        while (temp.leftChild != null) {
            temp = temp.leftChild;
        }
        return temp.data;
    }

    public int max() {
        Node temp = this.root;
        while (temp.rightChild != null) {
            temp = temp.rightChild;
        }
        return temp.data;
    }

    public Node min(Node currNode) {
        Node temp = currNode;
        if(temp != null) {
            while (temp.leftChild != null) {
                temp = temp.leftChild;
            }

            return temp;
        }
        else
            return null;
    }

    public Node max(Node currNode) {
        Node temp = currNode;
        if(temp != null) {
            while (temp.rightChild != null) {
                temp = temp.rightChild;
            }

            return temp;
        }
        else
            return null;
    }


    public Node remove(Node currNode, int data) {
        if (currNode == null) return currNode;
        if(data < currNode.data)
            currNode.leftChild = remove(currNode.leftChild, data);
        else if (data > currNode.data)
            currNode.rightChild = remove(currNode.rightChild, data);
        else {
            //When the node is Found !

            //Case 1 & 2 : If the node have at most 1 child.
            if(currNode.leftChild == null)
                return currNode.rightChild;
            else if (currNode.rightChild == null)
                return currNode.leftChild;

            //Case 3 : If the node to be deleted has exactly 2 nodes.
            Node minInRightTree = min(currNode.rightChild);
            currNode.data = minInRightTree.data;
            currNode.rightChild = remove(currNode.rightChild, currNode.data);
        }
        return currNode;
    }
}

class TreeMain {
    public static void main(String[] args) {
        Tree bst = new Tree();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Tree Data you want to insert as follows (e.g. like 1,2,3,4 .....) \n: ");
        String[] NodeData = in.next().split(",");   //Taking input of node's data as string
        int[] treeData = new int[NodeData.length];

        //converting string type node data into a list of integers that can be passed to the function.
        for (int i = 0; i < NodeData.length; i++) {
            treeData[i] = Integer.parseInt(NodeData[i]);
        }

        //Creating a BST with the data given.
        bst.createTree(treeData);
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

        Tree.Node temp = bst.remove(bst.root, 12);
        bst.size--;
        bst.displayTree(1);
        System.out.println("--------------------------------------");
        bst.displayTree(2);

        bst = null;
    }
}