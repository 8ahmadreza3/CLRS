package S04_AdvancedDesignAndAnalysisTechniques.Chapter16;

import java.util.*;

class HuffmanCode {
    static char[] charArray = new char[30];
    static int[] charfreq = new int[30];
    static int index = 0;

    static void findFreq(String str){
        int[] freq = new int[str.length()];
        char[] str1 = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    freq[i]++;
                    str1[j] = '0';
                }
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (str1[i] != ' ' && str1[i] != '0') {
                charArray[index] = str1[i] ;
                charfreq[index] = freq[i] ;
                System.out.println(charArray[index] + " :" + charfreq[index]);
                ++index ;
            }
        }
    }
    public static void printCode(Node root, String s) {
        if(root == null)
            return;
        if (root.left == null && root.right == null
                && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        String request = new String("Hello, World!") ;
        findFreq(request);
        PriorityQueue<Node> q  = new PriorityQueue<Node>(index+1, new MyComparator());
        for (int i=0 ; i<=index ; i++) {
            Node node = new Node();
            node.c = charArray[i];
            node.freq = charfreq[i];
            node.left = null;
            node.right = null;
            q.add(node);
        }
        Node root = null;
        while (q.size() > 1) {
            Node x = q.peek();
            q.poll();
            Node y = q.peek();
            q.poll();
            Node f = new Node();
            f.freq = x.freq + y.freq;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }
        printCode(root, "");
    }
}
class Node {
    int freq;
    char c;
    Node left;
    Node right;
}
class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}

