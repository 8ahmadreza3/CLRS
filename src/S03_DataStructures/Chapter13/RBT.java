package S03_DataStructures.Chapter13;

public class RBT { // red-black tree
    Node root ;

    public RBT(int value){
        this.root = new Node(value);
    }

    void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null)
            leftChild.right.parent = node;

        leftChild.right = node;
        node.parent = leftChild;
        replaceChild(parent, node, leftChild);
    }

    void replaceChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null)
            root = newChild;
        else if (parent.left == oldChild)
            parent.left = newChild;
        else if (parent.right == oldChild)
            parent.right = newChild;
        else
            throw new IllegalStateException("Node is not a child of its parent");

        if (newChild != null)
            newChild.parent = parent;
    }

    void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null)
            rightChild.left.parent = node;

        rightChild.left = node;
        node.parent = rightChild;
        replaceChild(parent, node, rightChild);
    }

    public void insert(int key) {
        Node node = root;
        Node parent = null;
        while (node != null) {
            parent = node;
            if (key < node.value)
                node = node.left;
            else if (key > node.value)
                node = node.right;
            else
                throw new IllegalArgumentException("BST already contains a node with key " + key);
        }
        // Insert new node
        Node newNode = new Node(key);
        newNode.color = "red";
        if (parent == null)
            root = newNode;
        else if (key < parent.value)
            parent.left = newNode;
        else
            parent.right = newNode;

        newNode.parent = parent;
        fixUP(newNode);
    }

    void fixUP(Node node) {
        Node parent = node.parent;
        if (parent == null)
            return;
        if (parent.color == "black")
            return;
        Node grandparent = parent.parent;
        if (grandparent == null) {
            parent.color = "black";
            return;
        }
        Node uncle = getUncle(parent);
        if (uncle != null && uncle.color == "red") {
            parent.color = "black";
            grandparent.color = "red";
            uncle.color = "black";
            fixUP(grandparent);
        }
        else if (parent == grandparent.left) {
            if (node == parent.right) {
                rotateLeft(parent);
                 parent = node;
            }
            rotateRight(grandparent);
            parent.color = "black";
            grandparent.color = "red";
        }
        else {
            if (node == parent.left) {
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandparent);
            parent.color = "black";
            grandparent.color = "red";
        }
    }

    Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    Node searchNode(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.value)
                return node;
            else if (key < node.value)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    

    static class Node{
        int value ;
        Node right ;
        Node left ;
        Node parent ;
        String color = "black";
        public Node(int value){
            this.value = value ;
        }

        public void changeRed(){
            this.color = "red" ;
        }
    }
}
