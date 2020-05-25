package DataStructures;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class AVLTrees {
    Node root;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;
        Node parent;
        int relativeHeight;

        Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
            this.relativeHeight = 1;
        }

        Node() {
            this(0);
        }
    }

    AVLTrees() {
        this.root = null;
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.relativeHeight;
    }

    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getRelativeHeight(node.leftChild)- getRelativeHeight(node.rightChild);
    }

    private int getRelativeHeight(Node node) {
        return (node == null) ? 0 : (Math.max(getHeight(node.leftChild), getHeight((node.rightChild))) + 1);
    }

    public void display(Node currNode) {
        if(currNode != null) {
            System.out.println(currNode.data + ", Height: " + getRelativeHeight(currNode)+ ", Balance Factor: " + getBalanceFactor(currNode));
            display(currNode.leftChild);
            display(currNode.rightChild);
        }
    }

    public void createTree(int @NotNull ... DATASET) {
        for(int data : DATASET) {
            Node newNode = new Node(data);
            if(this.root == null) {
                this.root = newNode;
            }
            else
                addNode(this.root, newNode);

            updateHeights(this.root);
            balanceTree(newNode);
        }
    }

    public void addNode(Node currNode, Node newNode) {
        while (currNode != null) {
            if(newNode.data <= currNode.data) {
                if(currNode.leftChild == null) {
                    currNode.leftChild = newNode;
                    newNode.parent = currNode;
                    return ;
                }
                else
                    currNode = currNode.leftChild;
            }
            else {
                if(currNode.rightChild == null) {
                    currNode.rightChild = newNode;
                    newNode.parent = currNode;
                    return ;
                }
                else
                    currNode = currNode.rightChild;
            }
        }
    }

    public void updateHeights(Node currNode) {
        if(currNode != null) {
            currNode.relativeHeight = getRelativeHeight(currNode);
            if(currNode.leftChild != null ) updateHeights(currNode.leftChild);
            if(currNode.rightChild != null ) updateHeights(currNode.rightChild);
        }
    }

    public void rotateLeft(@NotNull Node X) {
        Node Y = X.rightChild;
        Y.parent = X.parent;
        if (Y.parent == null)
            this.root = Y;
        else {
            if(Y.parent.leftChild == X)
                Y.parent.leftChild = Y;
            else if (Y.parent.rightChild == X)
                Y.parent.rightChild = Y;
        }
        X.rightChild = Y.leftChild;
        if (X.rightChild != null )
            X.rightChild.parent = X;
        Y.leftChild = X;
        X.parent= Y;
        updateHeights(X);
        updateHeights(Y);
    }

    public void rotateRight(@NotNull Node X) {
        Node Y = X.leftChild;
        Y.parent = X.parent;
        if (Y.parent == null)
            this.root = Y;
        else {
            if(Y.parent.leftChild == X)
                Y.parent.leftChild = Y;
            else if (Y.parent.rightChild == X)
            Y.parent.rightChild = Y;
        }
        X.leftChild = Y.rightChild;
        if (X.leftChild != null )
            X.leftChild.parent = X;
        Y.rightChild = X;
        X.parent= Y;
        updateHeights(X);
        updateHeights(Y);
    }

    public void balanceTree(Node currNode) {
        // Notice when the balance factor is +ve, then the node is left-heavy
        // And when the balance factor is -ve, then the node is right-heavy

        while(currNode != null) {
            if(getBalanceFactor(currNode) > 1) {
                //Case 1 : When X, Y and Z all are in left alignment
                /*          X
                 *       Y
                 *    Z
                 */
                if(currNode.leftChild.leftChild != null)
                    rotateRight(currNode);

                //Case 2 : When X, Y and Z all are in zig zag alignment
                /*     X
                 *  Y
                 *     Z
                 */
                else {
                    rotateLeft(currNode.leftChild);
                    rotateRight(currNode);
                }
            }
            else if(getBalanceFactor(currNode) < -1) {
                //Case 3 : When X, Y and Z all are in right alignment
                /*  X
                 *    Y
                 *      Z
                 */
                if(currNode.rightChild.rightChild != null)
                    rotateLeft(currNode);

                //Case 4 : When X, Y and Z all are in zag zig alignment
                /*    X
                 *      Y
                 *    Z
                 */
                else {
                    rotateRight(currNode.rightChild);
                    rotateLeft(currNode);
                }
            }
            currNode = currNode.parent;
        }
    }
}

class AVLTreesMain {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        AVLTrees avlTrees = new AVLTrees();

        System.out.print("Enter the Tree Data you want to insert as follows (e.g. like 1,2,3,4 .....) \n: ");
        String[] NodeData = in.next().split(",");   //Taking input of node's data as string
        int[] treeData = new int[NodeData.length];

        //converting string type node data into a list of integers that can be passed to the function.
        for (int i = 0; i < NodeData.length; i++) {
            treeData[i] = Integer.parseInt(NodeData[i]);
        }

        avlTrees.createTree(treeData);
        avlTrees.display(avlTrees.root);
        avlTrees = null;
    }
}
