package S02_SortingAndOrderStatistics.Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public static void bucketSort(float[] arr) {
        int n = arr.length;

        ArrayList[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = (float) buckets[i].get(j);
            }
        }
    }


    static int[] countingSort(int[] a){
        int n = a.length;
        int k = Integer.MIN_VALUE;

        for (int i=0; i < n; i++)
            k = Math.max(k, a[i]);

        int[] countArray = new int[k + 1];
        for(int i = 0; i < n; i++)
            countArray[a[i]]++;
        for(int i = 1; i <= k; i++)
            countArray[i] += countArray[i - 1];

        int[] outputArray = new int[n];
        for (int i=n-1 ; i>=0 ; i--) {
            outputArray[countArray[a[i]] - 1] = a[i];
            countArray[a[i]]--;
        }
        return outputArray;
    }

    public static void main(String[] args){
        float[] a = {0.3f, 0.1f, 0.7f, 0.12f, 0.105f, 0.5f, 0.8f, 0.11f};
        bucketSort(a);
        System.out.println(Arrays.toString(a));
    }
}
