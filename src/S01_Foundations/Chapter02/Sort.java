package S01_Foundations.Chapter02;

import java.util.Arrays;

public class Sort{

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l+i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m+1+j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
            k++;
        }
        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        // runtime complexity : O(nlogn)
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

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

        a = new int[]{4, 5, 7, 1, 2, 3, 6};
        mergeSort(a, 0, a.length - 1);

        a = new int[]{5, 6, 3, 2, 7, 1, 4, 8};
        bubbleSort(a);
    }
}