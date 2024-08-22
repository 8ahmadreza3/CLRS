package S05_AdvancedDataStructures.Chapter18;

class BTree {
    static class BTreeNode {
        int[] keys;
        int t; // Minimum degree
        BTreeNode[] children;
        int n; // Current number of keys
        boolean isLeaf; // True if leaf node

        BTreeNode(int t, boolean isLeaf) {
            this.t = t;
            this.isLeaf = isLeaf;
            this.keys = new int[2*t - 1];
            this.children = new BTreeNode[2*t];
            this.n = 0;
        }
    }

    BTreeNode root;
    int t; // Minimum degree

    BTree(int t) {
        this.root = null;
        this.t = t;
    }

    void traverse() {
        if (root != null)
            traverse(root);
    }

    void traverse(BTreeNode node) {
        for (int i = 0; i < node.n; i++) {
            if (!node.isLeaf)
                traverse(node.children[i]);
            System.out.print(" " + node.keys[i]);
        }
        if (!node.isLeaf)
            traverse(node.children[node.n]);
    }

    BTreeNode search(int k) {
        return (root == null) ? null : search(root, k);
    }

    BTreeNode search(BTreeNode node, int k) {
        int i = 0;
        while (i<node.n && k>node.keys[i])
            i++;

        if (i<node.n && node.keys[i]==k)
            return node;
        if (node.isLeaf)
            return null;

        return search(node.children[i], k);
    }

    void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if (root.n == 2*t -1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                splitChild(s, 0);
                int i = 0;
                if (s.keys[0] < k)
                    i++;

                insertNonFull(s.children[i], k);
                root = s;
            } else
                insertNonFull(root, k);
        }
    }

}