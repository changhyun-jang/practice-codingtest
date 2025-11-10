import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int answer = 0;
        int cnt = 0;
        for(int i = len-1; i >= 0; i--) {
            cnt++;
            if( cnt <= citations[i]) {
                answer = cnt;
            }
        }
        
        return answer;
    }
}