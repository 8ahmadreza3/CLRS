package S03_DataStructures.Chapter10;

class Array {
    public int[] array ;
    public int index = 0 ;

    public Array(int n){
        array = new int[n] ;
    }

    void print(){
        // O(n)
        for(int i=0 ; i<index ; ++i){
            System.out.println(array[i]);
        }
    }

    void insert(int item){
        // O()
        if(index >= array.length){
            int[] a = new int[2*array.length];
            for(int i=0 ; i<array.length ; i++){
                a[i] = array[i] ;
            }
            array = a ;
        }
        array[index++] = item ;
    }

    int indexOf(int key){
        // O(n)
        for(int i=0 ; i<array.length ; ++i){
            if(array[i]==key)
                return i ;
        }
        return -1 ;
    }

    void removeAt(int i){
        // 0(n)
        if(i <= index && i>= 0){
            for(int j=i ; j<array.length ; ++j) {
                array[j] = array[j + 1];
            }
            array[array.length-1] = 0 ;
            index-- ;
        }
    }
}