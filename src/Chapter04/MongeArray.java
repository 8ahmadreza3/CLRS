package Chapter04;

public class MongeArray {

    static boolean isMongeArray(int[][] a){
        int n = a.length ;
        int m = a[0].length ;
        for(int i=0 ; i<n-1 ; ++i){
            for(int j=0 ; j<m-1 ; j++){
                for(int k=i+1 ; k<n-1 ; ++k){
                    for(int l=j+1 ; l<m-1 ; ++l){
                        int x = a[i][j] + a[k][l] ;
                        int y = a[i][l] + a[k][j] ;
                        if(x>y){
                            return false ;
                        }
                    }
                }
            }
        }
        return true ;
    }

    public static void main(String[] args){
        int[][] a = {
                {10, 17, 13},
                {17, 29, 16},
                {24, 28, 29}
        };
        System.out.println(isMongeArray(a));
    }
}
