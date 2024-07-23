package S02_SortingAndOrderStatistics.Chapter06;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    public ArrayList<Integer> heap = new ArrayList<>();

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
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void buildMaxHeap(int[] a){
        for(int i=0 ; i<a.length ; ++i){
            heap.add(i, a[i]);
        }
        for(int i=a.length/2 ; i>=0 ; i--){
            maxHeapify(i);
        }
    }

    public void heapSort(int[] a){
        buildMaxHeap(a);
        for(int i=a.length-1 ; i>1 ; --i){
            exchange(1, i);
            maxHeapify(1);
        }
    }

    public int heapMaximum(){
        return heap.getFirst();
    }

    public int heapExtractMax(){
        if(heap.isEmpty()){
            return -1 ;
        }
        int max = heapMaximum();
        int last = heap.size()-1 ;
        heap.set(0, heap.get(last));
        heap.remove(last);
        maxHeapify(0);
        return max ;
    }

    public void heapIncreaseKey(int i, int key){
        if(key< heap.get(i)){
            System.out.println("new key is smaller than current key");
            return;
        }
        heap.set(i , key);
        while(i>0 && heap.get(parent(i))<heap.get(i)){
            exchange(i, parent(i));
            i=parent(i);
        }
    }

    public void maxHeapInsert(int key){
        heap.add(Integer.MIN_VALUE);
        heapIncreaseKey(heap.size()-1, key);
    }

    public static void main(String[] args){
        int[] a = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        Heap h = new Heap();
        h.heapSort(a);
        h.heapExtractMax();
        System.out.println(Arrays.toString(h.heap.toArray()));
        h.heapIncreaseKey(3, 19);
        System.out.println(Arrays.toString(h.heap.toArray()));
    }
}

