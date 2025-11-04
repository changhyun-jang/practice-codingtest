class Solution {
    public int solution(int n) {
        int stt = 1;
        int end = 2;
        int res = n;
        
        if(n % 2 == 1) {
            n  =  (int) (n / 2);
            n++;
        } else {
            n  =  (int) (n / 2);
        }
        
        int[] check = new int[n+2];
        for(int i = 0 ; i < n+1; i++) {
            check[i] = i;
        }
        
        int answer = 1;
        int result = 3;
        if(res == 1 || res == 2) {
            return 1;
        } else {
            while (stt < end && end <= n) {
                if(result < res) {
                    result += check[++end];
                } else if(result == res) {
                    answer++;
                    result -= check[stt++];
                } else if(result > res) {
                    result -= check[stt++];
                }
            }
        } 
        
        return answer;
    }
}