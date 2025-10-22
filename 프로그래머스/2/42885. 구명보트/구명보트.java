import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] visited = new boolean[people.length];
        int answer = 0;
        int r = 0;
        for(int i = people.length-1; i >= 0; i--) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            int tmp = limit - people[i];
            for(int j = r; j < i; j++) {
                if(people[j] <= tmp) {
                    visited[j] = true;
                    r = j + 1;
                    break;
                } else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}