class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int left = 0;
        int right = 0;
        
       for(char c : s.toCharArray()){
           if(c=='(') left++;
           else if(c==')')right++;
           if(left<right){
               answer = false;
               return answer;
           }
       } 
        
        if(left==right) {
            if(s.charAt(0)==')'){
                answer=false;
                return answer;
            }
            return answer;
        }else {
            answer = false;
            return answer;
        }
    }
}