class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int discountLen = discount.length;
        int wantLen = want.length;
        
        int answer = 0;
        // 정현이가 사야되는 모든 제품의 수
        int total = 0;
        for(int tmp : number) {
            total += tmp;
        }
        
        // discount Loop
        for(int i = 0; i <= discountLen - total; i++) {
            boolean breakFlag = false;
            int[] tmpNum = new int[10];
            for(int z = 0; z <wantLen; z++ ) {
                tmpNum[z] = number[z];
            }
            
            for(int j =0; j< total; j++) {
                for(int z = 0; z <wantLen; z++ ) {
                    if(discount[i+j].equals(want[z])) {
                        if(tmpNum[z] == 0) {
                            breakFlag = true;
                            break;
                        } else {
                            tmpNum[z]-=1;
                        }
                    } else {
                        continue;
                    }
                }
                
                if(breakFlag) {
                    break;
                }
            }
            
            int result = 0;
            for(int z = 0; z <wantLen; z++ ) {
                result += tmpNum[z];
            }
            
            if(result == 0) {
                answer+=1;
            }
        }
        

        return answer;
    }
}