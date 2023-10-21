import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int prev_num=-1;
        
        Queue <Integer> num_queue=  new LinkedList<>();
        for(int i=0; i< arr.length; i++){
            if(i==0 || prev_num!=arr[i]){
                num_queue.add(arr[i]);
                prev_num=arr[i];
            }
            continue;
        }
        
        int[] answer = new int [num_queue.size()];
        for ( int i =0; i < answer.length; i++){
            answer[i] = num_queue.poll();
        }
        
       
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}