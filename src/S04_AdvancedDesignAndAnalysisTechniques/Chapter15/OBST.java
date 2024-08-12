package S04_AdvancedDesignAndAnalysisTechniques.Chapter15;

import java.util.Arrays;

public class OBST {
    static double optCost(double[] prop, int i, int j, double[][] m) {
        if (j < i)
            return 0;
        if (j == i) {
            m[i][j+1] = i+1 ;
            return prop[i];
        }
        double sum = sum(prop, i, j);
        double min = Integer.MAX_VALUE;
        for (int r=i ; r<=j; ++r) {
            double cost = optCost(prop, i, r-1, m) + optCost(prop, r+1, j, m) + sum ;
            if (cost < min) {
                min = cost;
                m[i][j+1] = r+1 ;
            }
        }
        return min ;
    }

    static double sum(double[] prop, int i, int j) {
        double sum = 0;
        for (int k = i; k <=j; k++)
            sum += prop[k];
        return sum;
    }

    public static void main(String[] args) {
        int[] keys = {0, 1, 2, 3, 4, 5};
        double[] prop = {0, 0.25, 0.35, 0.25, 0.1 , 0.05};
        int n = prop.length;
        double[][] m = new double[n][n+1];
        System.out.println("Cost of Optimal BST is " + optCost(prop, 0, n-1, m));
        System.out.println(Arrays.deepToString(m));
    }
}