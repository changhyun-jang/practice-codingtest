import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*
    --문제 읽기
    NxN 도시
    각 칸은 빈칸, 치킨집, 집 중 하나
    (r,c) 와 같은 형태로나타내고, r행 c열 또는 위에서 부터 r번째 칸,
    왼쪽부터 c번째 칸을 의미한다. r과 c는 1부터 시작

    치킨거리 = 집과 가장 가까운 치킨집 거리
    각각의 집은 치킨거리를 가짐
    도시의 치킨거리는 모든 치킨거리의 합
    임의의 두칸

    가장수익을 많이 낼 수 있는 치킨집의 개수는 최대 M개
    어떻게 고르면 도시의 치킨 거리가 가장 작게 될지 구하시오.

    --문제 풀이
    1. 각집에서 치킨거리를 구하고 치킨거리를 구할때 각 치킨집이 몇번 쓰였는지 카운트 한다음
    가장 적게 쓰인 치킨집들은 제외한다 -> 틀림

    2. 각 치킨집마다 집까지의 거리합을 구한다. 그다음 가장 큰애들은 뺸다.

    3. 조합을 이용한뒤 각 케이스 별로 모두 치킨거리 구하기 -> 시간초과

    4. dp형식으로 집이 최대 100 개 M은 최대 13이니까 2차원 배열로 만들어보자

     */
    static int N, M, answer;
    static int[][] A;
    static ArrayList<Place> home = new ArrayList<>();
    static ArrayList<Place> chicken = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;
    static int[] countC;

    static class Place {
        int x;
        int y;

        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1) {
                    home.add(new Place(i, j));
                } else if (A[i][j] == 2) {
                    chicken.add(new Place(i, j));
                }
            }
        }
        dp = new int[home.size()][chicken.size()];
        for (int i = 0; i < home.size(); i++) {
            Place homeInfo = home.get(i);
            for (int j = 0; j < chicken.size(); j++) {
                Place chickenInfo = chicken.get(j);
                dp[i][j] = Math.abs(homeInfo.x - chickenInfo.x) + Math.abs(homeInfo.y - chickenInfo.y);
            }
        }
        countC = new int[chicken.size()];
        for (int i = 0; i < countC.length; i++) {
            countC[i] = i;
        }


        visited = new boolean[chicken.size()];
        dfs(0, 0, new int[M]);
        System.out.println(answer);
    }

    //조합
    private static void dfs(int start, int depth, int[] pickedChicken) {
        if (depth == M) {
            int temp = calChicken(pickedChicken);
            answer = Math.min(answer, temp);
            return;
        }
        for (int i = start; i < countC.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pickedChicken[depth] = countC[i];
                dfs(start + 1, depth + 1, pickedChicken);
                visited[i] = false;
            }
        }
    }

    private static int calChicken(int[] pickedChicken) {
        int chickenDistance = 0;
        for (int i = 0; i < home.size(); i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < pickedChicken.length; j++) {
                temp = Math.min(temp, dp[i][pickedChicken[j]]);
            }
            chickenDistance += temp;
        }
        return chickenDistance;
    }
}

