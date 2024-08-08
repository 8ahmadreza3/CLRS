import java.util.Arrays;

class Rodcut {

  static int rodcutBU(int[] price, int n, int[] s){
    int[] r = new int[n+1];
    r[0] = 0 ;
    r[1] = price[1] ;
    for(int i=2 ; i<=n ; ++i){
      int max = -1 ;
      for(int k=1 ; k<=i ; ++k){
        int p = price[k] + r[i-k];
        if(p > max){
          max = p ;
          s[i] = k ;
        }
      }
      r[i] = max ;
    }
    return r[n] ;
  }

  static int rodcutTD(int[] price, int index, int[] r, int[]s){
    if (index <= 1) {
      return price[index];
    }
    if( r[index] > 0){
      return r[index];
    }
    int max = Integer.MIN_VALUE;
    for(int k=1 ; k<=index ; ++k){
      int p = price[k] + rodcutTD(price, index - k, r, s);
      if(p > max){
        max = p ;
        s[index] = k ;
      }
    }
    r[index] = max ;
    return max ;
    }

    static void printRodcut(int[] s, int n){
      if(n <= 1){
        System.out.println("No Cut");
        return ;
      }
      System.out.println("Cut:" + s[n]);
      printRodcut(s, n-s[n]);
    }

  public static void main(String[] args){
    int[] price = { 0, 5, 11 };
    int size = price.length;
    int[] r = new int[size];
    int[] s = new int[size];
    System.out.println("Top Down: Maximum Value is " + rodcutTD(price, size - 1, r, s));
    printRodcut(s, size-1);
    System.out.println("Bottom Up: Maximum Value is " + rodcutBU(price, size - 1, s));
    printRodcut(s, size-1);
  }
}