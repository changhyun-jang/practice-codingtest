import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer=new int [prices.length];
        Queue<Integer> stockQueue = new LinkedList<>();
        for(int i :prices){
            stockQueue.add(i);
        }
        int index=0;
        while(!stockQueue.isEmpty()){
            int num = stockQueue.poll();
            int time=0;
            for(int i=index+1; i<prices.length;i++){
                time+=1;
                if(num > prices[i]){
                    break;
                }
            }
            answer[index]=time;
            index+=1;
        }
        return answer;
    }
}