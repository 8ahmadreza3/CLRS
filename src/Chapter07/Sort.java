package Chapter07;

import java.util.Arrays;

public class Sort {

    public static void quickSort(int[] a, int p, int r){
        if(p<r){
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    public static int partition(int[] a, int p, int r){
        int x = a[r];
        int i = p-1 ;
        for(int j=p ; j<r ; j++){
            if(a[j] <= x){
                i++ ;
                exchange(a, i, j);
            }
        }
        exchange(a, i+1 , r);
        return i+1 ;
    }

    public static void exchange(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j] ;
        a[j] = temp ;
    }

    public static void main(String[] args){
        int[] a = {3, 1, 7, 12, 10, 5, 8, 11};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
