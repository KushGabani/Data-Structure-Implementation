package DataStructures;

public class UnionFind {
    int length;
    int[] map;
    int[] lengthEach;

    UnionFind(int size) {
        if(size <= 0)
            System.out.println("Size cannot be negative");
        else {
            this.length  = size;
            lengthEach = new int[this.length];
            map = new int[this.length];

            for(int i = 0; i < this.length; i++) {
                map[i] = i;
                lengthEach[i] = i;
            }
        }
    }

    public int find(int rootToFind) {
        int root = rootToFind;
        while(root != map[root]) {
            root = map[rootToFind];
        }

        compressPath(rootToFind);

        return root;
    }

    public void compressPath(int from) {
        int to = find(from);

        while(to != from) {
            int passingBy = map[from];
            map[from] = to;
            from = passingBy;
        }
    }

    public boolean belongToSameGroup(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int componentSize(int current) {
        return lengthEach[find(current)];
    }

    public void unify(int node1, int node2) {
        if(belongToSameGroup(node1, node2))
            return ;

        int root1 = find(node1);
        int root2 = find(node2);

        if(lengthEach[root1] > lengthEach[root2]) {
            lengthEach[root1] += lengthEach[root2];
            map[root2] = root1;
        }
        else {
            lengthEach[root2] += lengthEach[root1];
            map[root1] = root2;
        }
    }
}


class UnionFindMain {
    public static void main(String[]args) {
        //Your test code goes here.
    }
}
