package S02_SortingAndOrderStatistics.Chapter09;

public class MediansOrder {
    int minimum(int[] a){
        int min = a[0];
        for(int i=1 ; i<a.length ; ++i){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min ;
    }


}
