class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int checkDay = 7 - startday;
        
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int startHh = schedules[i] / 100;
            int startMm = schedules[i] % 100;
            boolean check = false;
            for (int j = 0; j < 7; j++) {
                if( checkDay != 0 && (j == checkDay || j == checkDay - 1)) {
                    continue;
                } else if(checkDay == 0 &&(j == checkDay || j == 6)) {
                    continue;
                } else {
                    int hh = timelogs[i][j] / 100;
                    int mm = timelogs[i][j] % 100;
                    if (startHh == hh && mm-startMm > 10) {
                         check = true; 
                    }  else if((startHh + 1 == hh && mm + 60 - startMm > 10)|| startHh+1 < hh){
                        check = true;
                    } 
                    if(check) {
                        break;
                    }
                }
            }
            if(!check) answer++;
        }
    
        return answer;
    }
}