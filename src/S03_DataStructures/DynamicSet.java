package S03_DataStructures;

public class DynamicSet {
    int[] set ;
    int index = 0;

    public DynamicSet(int n){
        set = new int[n] ;
    }

    int search(int k){
        for(int i=0 ; i<set.length ; ++i){
            if(set[i] == k)
                return i ;
        }
        return -1 ;
    }

    void insert(int item){
        if(index >= set.length){
            int[] a = new int[2*set.length];
            for(int i=0 ; i<set.length ; i++){
                a[i] = set[i] ;
            }
            set = a ;
        }
        set[index++] = item ;
    }

    void delete(int i){
        if(i <= index && i>= 0){
            for(int j=i ; j<set.length ; ++j) {
                set[j] = set[j + 1];
            }
            set[index--] = 0 ;
        }
    }

    int minimum(){
        int i = 0 ;
        for(int j=0 ; j<index ; j++){
            if(set[i] > set[j])
                i = j ;
        }
        return i ;
    }

    int maximum(){
        int i = 0 ;
        for(int j=0 ; j<index ; j++){
            if(set[i] < set[j])
                i = j ;
        }
        return i ;
    }

    int successor(int i){
        for(int j=i ; j<index ; ++j){
            if(set[i] < set[j])
                return j ;
        }
        return -1 ;
    }

    int predecessor(int i){
        for(int j=i ; j<index ; ++j){
            if(set[i] > set[j])
                return j ;
        }
        return -1 ;
    }
}
