package S04_AdvancedDesignAndAnalysisTechniques.Chapter15;

public class LPS {

  public static int lpsBU(char[] x){
    int n = x.length ;
    int[][] c = new int[n][n] ;
    for(int i=0 ; i<n ; i++) {
      c[i][i] = 1 ;
    }

    for(int i=n-1 ; i>=0 ; i--) {
      for(int j=i+1 ; j<n-i ; j++){
        if (i > j)
          c[i][j] = 0 ;
        else if (x[i] == x[j])
          c[i][j] = c[i+1][j-1] + 2 ;
        else
          c[i][j] = Math.max(c[i+1][j], c[i][j-1]) ;
      }
    }
    return c[0][n-1] ;
  }

  public static int lpsTD(char[] x, int i, int j, int[][] r) {
    if (i > j) {
      return 0 ;
    }
    if (i == j) {
      return 1 ;
    }
    if (r[i][j] > 0) {
      return r[i][j] ;
    }
    if (x[i] == x[j]) {
      int p = lpsTD(x, i+1, j-1, r) + 2 ;
      r[i][j] = p ;
      return p ;
    } else {
      int p = lpsTD(x, i, j-1, r) ;
      int q = lpsTD(x, i+1, j, r) ;
      int max = Math.max(p, q) ;
      r[i][j] = max ;
      return r[i][j] ;
    }
  }

  public static void main(String[] args) {
    char[] x = "ahamdreza".toCharArray() ;
    int length = x.length ;
    int[][] r = new int[length][length] ;
    System.out.println("Bottom Up: Longest palindromic substring is: " + lpsBU(x)) ;
    System.out.println("Top Down: Longest palindromic substring is: " + lpsTD(x, 0, length-1, r)) ;
  }
}