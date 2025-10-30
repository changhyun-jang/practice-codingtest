import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> queue = new PriorityQueue<Integer>((o1,o2) -> o1-o2);
        k = k > enemy.length ? enemy.length : k;
         int answer = 0;
        for(int i = 0; i < k; i++) {
            queue.offer(enemy[i]);
            answer++;
        }
        for(int i = k; i < enemy.length; i++) {
            queue.offer(enemy[i]);
            int tmp = queue.poll();
            if(tmp > n) {
                break;
            }
            n-=tmp;
            answer++;
        }
       
        return answer;
    }
}