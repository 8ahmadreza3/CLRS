package S04_AdvancedDesignAndAnalysisTechniques.Chapter17;

import java.util.*;

public class AmortizedAnalysis {

    void multiPop(Stack s, int k){
        while(!s.isEmpty()){
            s.pop();
        }
    }

    void increment(String s){
        char[] str = s.toCharArray();
        int length = s.length();

        for(int i=length-1 ; i>=0 ; --i){
            if (str[i] == '0') {
                str[i] = '1';
                break;
            }
            str[i] = '0';
            i--;
        }

        System.out.print(str);
    }

    void decrement(String s){
        char[] str = s.toCharArray();
        int length = s.length();

        for(int i=length-1 ; i>=0 ; --i){
            if (str[i] == '1') {
                str[i] = '0';
                break;
            }
            str[i] = '1';
            i--;
        }

        System.out.print(str);
    }
}
