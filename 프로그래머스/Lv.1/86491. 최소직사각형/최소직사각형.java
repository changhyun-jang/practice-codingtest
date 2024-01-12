class Solution {
    public int solution(int[][] sizes) {
        for(int i =0; i<sizes.length; i++){
            if(sizes[i][0]>sizes[i][1]){
                continue;
            }else{
               int temp=sizes[i][0];
               sizes[i][0]=sizes[i][1];
               sizes[i][1]=temp;
            }
        }
        int w=0;
        int h=0;
         for(int i =0; i<sizes.length; i++){
           if(w<sizes[i][0]){
               w=sizes[i][0];
           }
             if(h<sizes[i][1]){
               h=sizes[i][1];
           }
         }
        int answer=w*h;
        return answer;
    }
}