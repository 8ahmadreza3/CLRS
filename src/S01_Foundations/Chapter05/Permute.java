package S01_Foundations.Chapter05;

import java.util.Arrays;

public class Permute {

    static void permuteBySorting(int[] a){
        int n = a.length ;
        int[] p = new int[n] ;
        for(int i=0 ; i<n ; ++i){
            p[i] = (int) (Math.random() * (Math.pow(n, 3)-1)) +1 ;
        }
        System.out.println("p is:" + Arrays.toString(p));
        insertionSort(a, p);
    }

    static void insertionSort(int[] a, int[] p){
        // runtime complexity : O(n^2)
        for(int j=0 ; j<a.length ; j++){
            int key = p[j] ;
            int prev = a[j] ;
            int i = j-1 ;
            while(i>=0 && p[i]> key){
                a[i+1] = a[i] ;
                p[i+1] = p[i] ;
                i-- ;
            }
            a[i+1] = prev ;
            p[i+1] = key ;
            System.out.println(Arrays.toString(a));
        }
    }

    static void permuteWithoutIdentity(int[] a){
        int n = a.length;
        for(int i=0 ; i<n-1 ; ++i){
            System.out.println(Arrays.toString(a));
            randomSwap(a, i, i+1 , a.length-1);
        }
    }

    static void permuteByCyclic(int[] a){
        int n = a.length ;
        int offset = (int) (Math.random()*(n-1));
        for(int i=0 ; i<n ; i++){
            int dest = i + offset ;
            if(dest>=n)
                dest = dest - n ;
            swap(i, dest, a) ;
            System.out.println(Arrays.toString(a));
        }
    }

    static void swap(int i, int j, int[] a){
        int temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }

    static void permuteWithAll(int[] a){
        int n = a.length ;
        for(int i=0 ; i<n ; i++){
            randomSwap(a, i, 0 , a.length-1);
            System.out.println(Arrays.toString(a));
        }
    }

    static void randomSwap(int[] a, int i, int l, int h){
        int random = (int) (Math.random()*(h-l)) +l;
        int temp = a[i] ;
        a[i] = a[random] ;
        a[random] = temp ;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        permuteByCyclic(a);
    }
}
