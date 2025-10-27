import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 정답배열
        String[] result = new String[plans.length];
        List<String> answer = new ArrayList<String>();
        // 시간들을 숫자로 변경
        for(int i = 0; i < plans.length; i++) {
            String[] tmpPlan = plans[i][1].split(":");
            plans[i][1] = String.valueOf(Integer.parseInt(tmpPlan[0]) * 60 +  Integer.parseInt(tmpPlan[1]));
        }
        
        // 나중에 꺼낼 스택
        Deque<String[]> deque = new ArrayDeque<String[]>();
        // 시간순 정렬
        Arrays.sort(plans, (o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        String time = plans[0][1];
        // plans 순회
        for(int i = 0; i < plans.length; i++) {
            // 현재 시간이 현재 plans보다 작은동안
            while(Integer.parseInt(time) < Integer.parseInt(plans[i][1])) {
                 // 데크가 비어있다면 현재 시간에 plans의시간을 넣음
                if(deque.isEmpty()) {
                    time = plans[i][1];
                    break;
                } else {
                    // 데크에 있는걸 꺼내서 수행
                    String[] tmp = deque.pollFirst();
                    if(Integer.parseInt(time) + Integer.parseInt(tmp[1]) > Integer.parseInt(plans[i][1])) {
                        tmp[1] = String.valueOf(Integer.parseInt(time) + Integer.parseInt(tmp[1]) - Integer.parseInt(plans[i][1]));
                        time = plans[i][1];
                        deque.offerFirst(tmp);
                        break;
                    } else if(Integer.parseInt(time) + Integer.parseInt(tmp[1]) < Integer.parseInt(plans[i][1])){
                        time = String.valueOf(Integer.parseInt(time) + Integer.parseInt(tmp[1]));
                        answer.add(tmp[0]);
                    } else {
                        time = plans[i][1];
                        answer.add(tmp[0]);
                        break;
                    }
                }
            }
            if(i == plans.length-1){
                break;
            }
            if(Integer.parseInt(time) + Integer.parseInt(plans[i][2]) > Integer.parseInt(plans[i+1][1])) {
                String[] tmp = new String[2];
                tmp[0] = plans[i][0];
                tmp[1] = String.valueOf(Integer.parseInt(time) + Integer.parseInt(plans[i][2]) - Integer.parseInt(plans[i+1][1]));
                time = String.valueOf(Integer.parseInt(plans[i+1][1]));
                deque.offerFirst(tmp);
            } else {
                time = String.valueOf(Integer.parseInt(time) + Integer.parseInt(plans[i][2]));
                answer.add(plans[i][0]);
            }
                // 데크에 있는걸 꺼내서 수행
                    //데크 꺼내서 시간을 남은 수행시간을 더했을때가 현재 수행해야되는 시간을 넘어가면
                        // 수행시간 더한거 - 현재 수행시작시간 하여 다시 넣기.
                    // 수행시간보다 작으면
                        // 현재시간에 더한값 넣기
                    // 같으면 
                        //현재시간에 더한값너호 나가기
            // 현재시간이 plasn시간과 동일해짐
                //  현재꺼를 이후꺼 시작시간 전까지 수행후 남은시간 데크에 넣기  
        }
        
        answer.add(plans[plans.length-1][0]);
        
        while(!deque.isEmpty()) {
            answer.add(deque.pollFirst()[0]);
        }
        
        
        int i = 0;
        for(String tmp : answer) {
           result[i++] = tmp;
        }
        return result;
    }
}