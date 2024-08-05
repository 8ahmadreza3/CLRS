package S03_DataStructures.Chapter13;

import S03_DataStructures.Chapter10.Tree;

public class RBT {
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
        replaceParentsChild(parent, node, leftChild);
    }

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
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

    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null)
            rightChild.left.parent = node;

        rightChild.left = node;
        node.parent = rightChild;
        replaceParentsChild(parent, node, rightChild);
    }

    public Node searchNode(int key) {
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
