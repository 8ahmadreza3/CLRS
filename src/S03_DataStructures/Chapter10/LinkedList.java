package S03_DataStructures.Chapter10;

public class LinkedList {
    Node first ;
    Node last ;
    int size ;

    static class Node{
        int value ;
        Node next ;
        public Node(int value){
            this.value = value ;
            this.next = null ;
        }
    }

    boolean isEmpty(){
        return first == null ;
    }

    void addLast(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node ;
        else {
            last.next = node ;
            last = node ;
        }
        size++ ;
    }

    boolean contains(int item){
        return indexOf(item) != -1;
    }

    public int indexOf(int item){
        int index = 0 ;
        Node current = first ;
        while(current!=null){
            if(current.value == item)
                return index ;
            current = current.next ;
            index++ ;
        }
        return -1 ;
    }

    void addFirst(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node ;
        else {
            node.next = first ;
            first = node ;
        }
        size++ ;
    }

    void removeFirst(){
        if(isEmpty())
            return ;
        else if(first == last)
            first = last = null ;
        else{
            Node second = first.next ;
            first.next = null ;
            first = second ;
        }
        size-- ;
    }

    void removeLast(){
        if(isEmpty())
            return;
        else if(first==last)
            first = last = null ;
        else{
            Node curr = first ;
            while(curr != null){
                if(curr.next == last)
                    break;
                curr = curr.next ;
            }
            // getPrevNode(last)
            curr.next = null ;
            last = curr ;
        }
        size-- ;
    }

    Node getPrevNode(Node node){
        Node curr = first ;
        while(curr != null){
            if(curr.next == node)
                return curr;
            curr = curr.next ;
        }
        return null ;
    }

    int size(){
        int size = 0 ;
        Node curr = first ;
        while(curr != null){
            size++ ;
            curr = curr.next ;
        }
        return size ;
    }

    int getSize(){
        return this.size ;
    }

    int[] toArray(){
        int[] a = new int[size];
        Node current = first;
        int index = 0 ;
        while(current!=null){
            a[index++] = current.value ;
            current = current.next ;
        }
        return a ;
    }

    void reverse(){
        Node prev = first ;
        Node current = first.next;
        last = first ;
        last.next = null ;
        while (current!=null){
            Node next = current.next ;
            current.next = prev ;
            prev = current ;
            current = next ;
        }
        first = prev ;
    }

    int findKthFromEnd(int k){
        if(k > size){
            throw  new IllegalArgumentException();
        }
        Node p = first ;
        Node q = first ;
        for (int i=0 ; i<k ; ++i)
            q = q.next ;
        while( q != last){
            p = p.next ;
            q = q.next ;
        }
        return p.value ;
    }
}
