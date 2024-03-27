import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제 읽기
    어떤 지역의 높이 정보를 파악
    그지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇개
    만들어 지는지를 조사
    장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠김
    
    행과 열의 크기가 각각 N인 2차원 배열 형태로 높이가 주어짐
     */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;
    static int[][] A;
    static boolean[][] visited;
    static int min;
    static int max;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        min = 0;
        max = 0;
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] > max) max = A[i][j];
            }
        }


        for (int height = min; height <= max; height++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && A[i][j] > height) {
                        dfs(i, j, height);
                        count += 1;
                    }
                }
            }
            if (answer < count) answer = count;
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int tempX = x + dx[k];
            int tempY = y + dy[k];
            if (tempX > -1 && tempY > -1 && tempX < N && tempY < N && !visited[tempX][tempY] &&A[tempX][tempY] > height ) {
                dfs(tempX, tempY, height);
            }
        }
    }
}
