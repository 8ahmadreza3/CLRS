package S03_DataStructures.Chapter10;

public class Tree {
    Node root ;

    public Tree(int value){
        this.root = new Node(value);
    }

    void insert(int value){
        Node current = root ;
        while(current != null){
            if(value > current.value)
                current = current.right ;
            else
                current = current.left ;
        }
        current = new Node(value);
    }

    void preOrder(Node root){
        if(root == null)
            return ;
        System.out.println(root.value);
        preOrder(root.right);
        preOrder(root.left);
    }

    void inOrder(Node root){
        if(root == null)
            return ;
        inOrder(root.right);
        System.out.println(root.value);
        inOrder(root.left);
    }

    void postOrder(Node root){
        if(root == null)
            return ;
        postOrder(root.right);
        postOrder(root.left);
        System.out.println(root.value);
    }

    boolean isLeaf(Node node){
        return node.right == null && node.left == null ;
    }

    int maximum(){
        Node current = root ;
        while(current.right != null){
            current = current.right ;
        }
        return current.value;
    }

    int minimum(){
        Node current = root ;
        while(current.left != null){
            current = current.left ;
        }
        return current.value;
    }

    void nodeAtDistance(Node node, int d){
        if(node == null)
            return ;
        if(d == 0)
            System.out.println(node.value);
        else {
            nodeAtDistance(node.right, d - 1);
            nodeAtDistance(node.left, d - 1);
        }
    }

    void levelOrder(){
        for(int i=0 ; i<height(root) ; ++i){
            nodeAtDistance(root, i);
        }
    }

    boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;
        return equals(first.left, second.left) &&
                equals(first.right, second.right) &&
                first.value == second.value ;
    }

    int height(Node root){
        if(isLeaf(root))
            return 0 ;
        return 1 + Math.max(height(root.right), height(root.right));
    }

    boolean contain(int value){
        Node current = root ;
        while(current != null){
            if(value < current.value)
                current = current.left ;
            else if(value > current.value)
                current = current.right ;
            else
                return true ;
        }
        return false ;
    }

    static class Node{
        int value ;
        Node right ;
        Node left ;
        public Node(int value){
            this.value = value ;
        }
    }
}
