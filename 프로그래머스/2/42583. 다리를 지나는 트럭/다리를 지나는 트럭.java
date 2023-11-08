import java.util.*;
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        //현재 다리를 나타내는 큐
        Queue<Integer> bridge= new LinkedList();
        //다리 길이만큼 0을 채워넣음
        for(int i=0; i<bridge_length;i++){
            bridge.add(0);
        }
        //truch_weight을 하나하나 순회할 index
        int index=0;
        //현재 다리에 올라가있는 자동차들의 무게
        int current_weight = 0;
        int answer=0;
        while(index<truck_weights.length){
            answer+=1;
            current_weight-=bridge.poll();
            if(current_weight+truck_weights[index]<=weight){
                bridge.offer(truck_weights[index]);
                current_weight+=truck_weights[index];
                index+=1;
            }else{
                bridge.offer(0);
            }
        }
        answer+=bridge_length;
        return answer;
    }
}