import java.util.*;
class Solution {
   public static int[] solution(int[] progresses, int[] speeds) {
        List <Integer>t_answer = new ArrayList();
        List <Integer>arr=new ArrayList<>();
        List <Integer> arr2=new ArrayList<>();

        for (int i=0; i<progresses.length; i++){
            arr.add(progresses[i]);
            arr2.add(speeds[i]);
        }

        int start=0;
        while(!arr.isEmpty()){
            int count=0;
            System.out.println(arr);
            for(int i=0; i<arr.size(); i++){
                if(!(arr.get(i)>=100)){
                    break;
                }
                if(arr.get(i)>=100){
                    count++;
                }

            }
            System.out.println(count);
            for(int j=0; j<count; j++){
                arr.remove(0);
                arr2.remove(0);
            }
            if(count!=0){
                t_answer.add(count);
            }
            for(int i=0; i<arr.size(); i++){
                arr.set(i, arr.get(i) + arr2.get(i));
            }

        }

        int [] answer= new int [t_answer.size()];

        for(int i=0;  i<t_answer.size();i++){
            answer[i]= t_answer.get(i);
        }

        return answer;
    }
}