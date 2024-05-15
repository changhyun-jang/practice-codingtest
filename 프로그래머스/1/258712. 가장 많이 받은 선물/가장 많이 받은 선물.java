class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 받는 선물 카운트 배열
        int[] getGift = new int[friends.length];
        
        // 지수 배열
        int[] totalCount = new int[friends.length];
        
        // 몇개 보냈는지 계산
        int[][] count = new int[friends.length][friends.length];
        
        // 주고 받은 선물과 지수를 표로 나타내기
        // gifts 배열에서 하나씩 꺼내오기
        for(int i = 0 ; i <gifts.length; i++) {
            // 띄어쓰기 기준으로 나누기
            String[] split = gifts[i].split(" ");
            int sender = 0;
            int reciever = 0;
            for(int k=0; k<friends.length; k++) {
                if(split[0].equals(friends[k])) {
                    sender = k;
                    totalCount[k]++ ;
                }
                if(split[1].equals(friends[k])){
                    reciever = k;
                    totalCount[k]-- ;
                }
            }
            count[sender][reciever] ++;
        }
//          for(int i = 0 ; i <friends.length; i++) {
//              for(int j = 0 ;j <friends.length; j++) {
//                  System.out.print(count[i][j]);
//              }
//              System.out.println();
//          }
        
        for(int i = 0 ; i <friends.length; i++) {
             for(int j = 0 ;j <friends.length; j++) {
                if(count[i][j] < count[j][i]) {
                    getGift[j] ++;
                }else if(count[i][j] == count[j][i]){
                    if(totalCount[i] < totalCount[j]) {
                        getGift[j] ++;
                    } else if(totalCount[i] > totalCount[j]){
                        getGift[i] ++;
                    }
                }else{
                    getGift[i] ++;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < getGift.length; i++) {
            answer = Math.max(getGift[i]/2,answer);
        }
        
        return answer;
    }
}