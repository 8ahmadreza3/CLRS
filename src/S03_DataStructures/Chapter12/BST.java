package S03_DataStructures.Chapter12;

import S03_DataStructures.Chapter10.Tree;

public class BST {
    Node root ;

    public BST(int value){
        this.root = new Node(value);
    }

    static class Node{
        int value ;
        Node right ;
        Node left ;
        public Node(int value){
            this.value = value ;
        }
    }

    Node treeSuccessor(Node root, Node node){
        if(node.right != null)
            return treeMinimum(node.right);
        Node y = null ;
        while (root != null) {
            if (node.value < root.value) {
                y = root;
                root = root.left;
            }
            else if (node.value > root.value)
                root = root.right;
            else
                break;
        }
        return y;
    }

    void treeInsert(int value){
        Node current = root ;
        while(current != null){
            if(value > current.value)
                current = current.right ;
            else
                current = current.left ;
        }
        current = new Node(value);
    }

    Node treeDelete(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.value > x) {
            root.left = treeDelete(root.left, x);
        } else if (root.value < x) {
            root.right = treeDelete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node succ = getSuccessor(root);
            root.value = succ.value;
            root.right = treeDelete(root.right, succ.value);
        }
        return root;
    }

    static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    Node iterativeTreeSearch(int value){
        Node current = root ;
        while(current != null){
            if(value < current.value)
                current = current.left ;
            else if(value > current.value)
                current = current.right ;
            else
                return current ;
        }
        return null ;
    }

    Node treeMaximum(Node node){
        Node current = node ;
        while(current.right != null){
            current = current.right ;
        }
        return current;
    }

    Node treeMinimum(Node node){
        Node current = node ;
        while(current.left != null){
            current = current.left ;
        }
        return current;
    }

    Node treeSearch(Node node, int target){
        if(node == null || node.value == target)
            return node;
        if(target < node.value)
            return treeSearch(node.left, target);
        else
            return treeSearch(node.right, target);
    }

    void inOrderTreeWalk(Node root){
        if(root == null)
            return ;
        inOrderTreeWalk(root.right);
        System.out.println(root.value);
        inOrderTreeWalk(root.left);
    }
}
