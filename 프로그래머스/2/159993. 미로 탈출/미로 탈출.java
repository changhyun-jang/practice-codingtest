import java.util.*;

class Solution {
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};  //동남서북
    static int[] dy = {0, -1, 0, 1};  //동남서북
    static int lenX = 0;
    static int lenY = 0;
    
    public int solution(String[] maps) {
        // 2차원배열에 옮기기
        int startX = 0;
        int startY = 0;
        lenY = maps.length;
        lenX = maps[0].length();
        map = new String[lenY][lenX];
        visited = new boolean[lenY][lenX];
        for(int i = 0; i < maps.length; i++) {
            String[] temp = maps[i].split("");
            for(int j = 0; j< temp.length; j++) {
                map[i][j] = temp[j];
                if(temp[j].equals("S")) {
                    startX = j;
                    startY = i; 
                }
            }
        }
        
        int[] temp = new int[3];
        temp[0] = startY;
        temp[1] = startX;
        temp[2] = 0;
        int[] temp2 = BFS(temp, "L");
        if(temp2 == null) {
            return -1;
        }
        visited = new boolean[maps.length][maps[0].length()];
        int[] temp3 = BFS(temp2,"E");
        if(temp3 == null) {
            return -1;
        }
        
        int answer = temp3[2];
        return answer;
    }
    
    static int[] BFS(int[] tmp, String flag) {
        int[] answer = new int[3];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(tmp);
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(map[temp[0]][temp[1]].equals(flag)) {
                answer[0] = temp[0];
                answer[1] = temp[1];
                answer[2] = temp[2];
                return answer;
            }
            for (int i = 0; i < 4; i++) {
                int tempY = temp[0] + dy[i];
                int tempX = temp[1] + dx[i];
                if(tempY >= 0 && tempY < lenY && tempX >= 0 && tempX < lenX
                   && !visited[tempY][tempX]) {    
                    if(!map[tempY][tempX].equals("X")) {
                        int[] temp2 = new int[3];
                        temp2[0] = tempY;
                        temp2[1] = tempX;
                        temp2[2] = temp[2]+1;
                        visited[tempY][tempX] = true;
                        queue.add(temp2);
                    }
                }
            }
        }
        return null;
    }
}