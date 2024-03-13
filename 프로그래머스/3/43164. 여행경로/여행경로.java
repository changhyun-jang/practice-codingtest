import java.io.*;
import java.util.*;

class Solution {
    /*
    --문제 읽기
    ICN에서 시작해야함
    가능한 경로가 2개이상일 겨우 알파벳 순서가 앞서는 경로를 return
    모두 사용하여 방문하기
    
    --문제 풀이
    
    */
    //방문확인배열
    static boolean[] visited;
    //정답을 가지고 있을 리스트
    static ArrayList<String> answerTemp;
    public String[] solution(String[][] tickets) {
        //방문확인배열 초기화 
        visited = new boolean [tickets.length];
        //정답을 가지고 있을 리스트 초기화
        answerTemp = new ArrayList<>();
        //dfs돌리기
        dfs("ICN","ICN",tickets,0);
        Collections.sort(answerTemp);
        String[] answer = answerTemp.get(0).split(" ");
        return answer;
    }
    public static void dfs(String airport,String route, String[][] tickets, int count){
        if(count==tickets.length) {
            answerTemp.add(route);
            return;
        }
        for(int i = 0; i<tickets.length; i++) {
            if(airport.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " +tickets[i][1], tickets,count+1);
                visited[i] = false;
            }
        }
    }
}