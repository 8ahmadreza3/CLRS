package S04_AdvancedDesignAndAnalysisTechniques.Chapter15;

class MatrixChain{

  static int matrixChainBU(int[] p, int n, int[][] s){
    int[][] r = new int[n][n] ;
    for (int i = 1; i < n; i++)
      r[i][i] = 0;
    for(int l=2 ; l<n ; ++l){
      for(int i=1 ; i < n-l+1 ; i++){
        int j = i + l - 1 ;
        if (j == n)
          continue;
        int min = Integer.MAX_VALUE ;
        for(int k=i ; k<j ; ++k){
          int q = r[i][k] + r[k+1][j] + p[i-1] * p[k] * p[j] ;
          if(q < min){
            min = q ;
            s[i][j] = k ;
          }
        }
        r[i][j] = min ;
      }
    }
    return r[1][n-1] ;
  }

  static int matrixChainTD(int[] p, int i, int j, int[][] r, int[][] s){
    if(j <= i)
      return 0;
    if(r[i][j] > 0)
      return r[i][j] ;

    int min = Integer.MAX_VALUE ;
    for(int k=i ; k<j ; ++k){
      int q = matrixChainTD(p, i, k, r, s) + matrixChainTD(p, k+1, j, r, s) + p[i-1] * p[k] * p[j] ;
      if(q < min){
        s[i][j] = k ;
        min = q ;
      }
    }
    r[i][j] = min ;
    return min ;
  }

  void printOptimalParents(int[][] s, int i, int j){
    if(i == j)
      System.out.print("A");
    else {
      System.out.print("(");
      printOptimalParents(s, i, s[i][j]);
      printOptimalParents(s, s[i][j]+1, j);
      System.out.print(")");
    }
  }

  public static void main(String[] args){
    int[] p = {4, 5, 11, 17, 6, 7} ;
    int size = p.length ;
    int[][] r = new int[size][size] ;
    int[][] s = new int[size][size] ;
    System.out.println("Top Down: Minimum Cost is " + matrixChainTD(p, 1 , size-1, r, s)) ;
    System.out.println("Bottom Up: Minimum Cost is " + matrixChainBU(p, size, s)) ;
  }
}