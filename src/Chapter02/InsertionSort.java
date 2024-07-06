package Chapter02 ;

import java.util.Arrays;

public class InsertionSort{

    static void insertionSort(int[] a){
        // runtime complexity : O(n^2)
        for(int j=0 ; j< a.length; j++){
            int key = a[j] ;
            int i = j-1 ;
            while(i>=0 && a[i]> key){
                a[i+1] = a[i] ;
                i-- ;
            }
            a[i+1] = key ;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args){
        int[] a = {5, 2, 4, 6, 1, 3} ;
        insertionSort(a);
    }
}