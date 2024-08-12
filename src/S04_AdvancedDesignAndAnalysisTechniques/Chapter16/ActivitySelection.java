package S04_AdvancedDesignAndAnalysisTechniques.Chapter16;

import java.util.*;

class Activity {
    String name;
    int deadline;
    int benefit;

    public Activity(String name, int deadline, int benefit) {
        this.name = name;
        this.deadline = deadline;
        this.benefit = benefit;
    }
    public String toString(){
        return name + " - Deadline: " + deadline + ", Benefit: " + benefit ;
    }
}

public class ActivitySelection {
    public static ArrayList<Activity> greedyActivitySelection(ArrayList<Activity> activities) {
        activities.sort((a1, a2) -> Integer.compare(a1.deadline, a2.deadline));
        ArrayList<Activity> result = new ArrayList<>();
        int n = activities.getLast().deadline ;
        for (int i=1 ; i<=n ; ++i) {
            Activity max = new Activity("0", 0, 0);
            int j = 0 ;
            for( ; j<activities.size() ; ++j){
                Activity a = activities.get(j);
                if(a.deadline >= i && a.benefit> max.benefit){
                    max = a ;
                }
            }
            if(max.benefit > 0){
                activities.remove(max);
                result.add(max);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();

        activities.add(new Activity("1", 3, 40));
        activities.add(new Activity("2", 2, 30));
        activities.add(new Activity("3", 3, 50));
        activities.add(new Activity("4", 1, 20));
        activities.add(new Activity("5", 3, 35));
        activities.add(new Activity("6", 2, 45));
        activities.add(new Activity("7", 4, 10));
        activities.add(new Activity("8", 4, 15));

        List<Activity> result = greedyActivitySelection(activities);
        int benefit = 0 ;
        System.out.println("Selected Activities:");
        for (Activity activity : result) {
            System.out.println(activity);
            benefit += activity.benefit ;
        }
        System.out.println("Your benefit is:" + benefit);
    }
}