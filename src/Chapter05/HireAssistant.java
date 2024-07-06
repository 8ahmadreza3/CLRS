package Chapter05;

public class HireAssistant {

    static int hireAssistant(int[] candidate, int[] commission , int cost){
        int maxCost = 0 ;
        int best = 0 ;
        for(int i=1 ; i<candidate.length ; ++i){
            if(candidate[i] > candidate[best]){
                maxCost = commission[best] + commission[i] ;
                best = i ;
                break;
            }
        }
        System.out.println("best is " + best);
        return (maxCost + best*cost) ;
    }


    public static void main(String[] args){
        int[] candidate = {27, 10, 23, 9, 12, 26, 27 , 30};
        int[] commission = {22, 10 , 34, 45, 56, 65, 33, 40};
        System.out.println(hireAssistant(candidate, commission, 10));
    }
}
