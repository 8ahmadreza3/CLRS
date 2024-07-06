package Chapter02;

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] a){
        // runtime complexity : O(n^2)
        int n = a.length ;
        for(int i=0 ; i<n ; ++i){
            for(int j=n-1 ; j>i ; j--){
                if(a[j] < a[j-1]){
                    swap(a , j, j-1);
                }
            }
        }
    }

    static void swap(int[] a, int i , int j){
        int temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }

    public static void main(String[] args){
        int[] a = {5, 6, 3, 2, 7, 1, 4, 8} ;
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
