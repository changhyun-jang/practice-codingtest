import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static boolean[][] visited;
    //줄 개수
    static int N;
    //칸 개수
    static int M;
    static int[][] A;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        A = maps;
        int answer = 0;
        BFS(0,0);
        if(A[N-1][M-1] == 1) {
            answer = -1;
        } else {
            answer = A[N-1][M-1];
        }
        return answer;
    }
    static void BFS(int X, int Y) {
        Queue <int[]> queue = new LinkedList<>();
        queue.offer(new int[] {X,Y});
        visited[X][Y] = true;
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x >= 0 && x < N && y >= 0 && y < M) {
                    if(visited[x][y]==false && A[x][y]!=0){
                        visited[x][y] = true;                        
                        A[x][y] = A[now[0]][now[1]]+1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}