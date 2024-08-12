package S04_AdvancedDesignAndAnalysisTechniques.Chapter15;

public class LCS {

  public static int lcsTD(char[] x, char[] y, int m, int n, int[][] r){
    if (m == 0 || n == 0)
      return 0 ;

    if (r[m][n] > 0)
      return r[m][n] ;

    if (x[m] == y[n]){
      int p = lcsTD(x, y, m-1, n-1, r) + 1 ;
      r[m][n] = p ;
      return p ;
    } else {
      int p = lcsTD(x, y, m, n-1, r) ;
      int q = lcsTD(x, y, m -1, n, r) ;
      int max = Math.max(p,q) ;
      r[m][n] = max ;
      return max ;
    }
  }

  public static int lcsBU(char[] x, char[] y, int m, int n){
    int[][] c = new int[m+1][n+1] ;
    for(int i=0 ; i<=m ; i++)
      c[i][0] = 0 ;

    for(int j=0 ; j<=n ; j++)
      c[0][j] = 0 ;

    for(int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          c[i][j] = 0 ;
        else if (x[i-1] == y[j-1])
          c[i][j] = c[i - 1][j - 1] + 1 ;
        else
          c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]) ;
      }
    }
    return c[m][n] ;
  }

  public static void main(String[] args){
    // string should start with space
    char[] x = " ahmadreza".toCharArray();
    char[] y = " mohammadreza".toCharArray();
    int m = x.length ;
    int n = y.length ;
    int[][] r = new int[m][n] ;
    System.out.println("Top Down: Longest common subsequence is: " + lcsTD(x, y, m-1, n-1, r)) ;
    System.out.println("Bottom Up: Longest common subsequence is: " + lcsBU(x, y, m-1, n-1)) ;
  }
}