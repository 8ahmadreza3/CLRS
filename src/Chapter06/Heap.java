package Chapter06;

import java.util.ArrayList;

public class Heap {
    static ArrayList<Integer> heap = new ArrayList<>();

    public int parent(int i){
        return i/2 ;
    }
    public int left(int i){
        return 2*i ;
    }
    public int right(int i){
        return 2*i +1 ;
    }

    public void maxHeapify(int i){
        int l = left(i);
        int r = right(i);
        int largest ;
        if(l<heap.size() && heap.get(l)>heap.get(i))
            largest = l ;
        else
            largest = i ;
        if(r<heap.size() && heap.get(r)>heap.get(largest))
            largest = r ;
        if(largest != i){
            exchange(i, largest);
            maxHeapify(largest);
        }
    }

    public void exchange(int i, int j){
        int temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.add(j, temp);
    }

    public void buildMaxHeap(int[] a){
        for(int i=0 ; i<a.length ; ++i){
            heap.add(i, a[i]);
        }
        for(int i=a.length/2 ; i>=0 ; i--){
            maxHeapify(i);
        }
    }

    public static void main(String[] args){

    }
}

