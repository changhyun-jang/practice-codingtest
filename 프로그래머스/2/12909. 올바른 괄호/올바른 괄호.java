class Solution {
    boolean solution(String s) {
       boolean answer = true;
        int count =0;
       for(char c:s.toCharArray()){
           if(count<0) return false;
            if(c=='(') count+=1;
            else count-=1;
        }
       if(count!=0) return false;

        return answer;
    }
}