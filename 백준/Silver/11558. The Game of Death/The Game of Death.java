import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] arr;
    static int N, answer, count;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //몇번의 테스트 케이스 인지 입력받기
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            // 몇번만에 N에 도달해야하는지 저장
            count = 0;
            answer = 0;
            // 총 몇명에서 진행하는지 체크
            N = sc.nextInt();

            // dfs를 수행하기 위한 그래프 구성
            A = new ArrayList[N + 1];
            // 각 번호에서 시작하면 N까지 얼마만에 도달하는지 저장하는 함수
            arr = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                A[i].add(sc.nextInt());
            }

            //dfs를 통해 각 N까지 도달을 언제 하는지 확인
            dfs(1, 0);
            System.out.println(answer);

        }
    }

    private static void dfs(int start, int cnt) {
        if (start == N) {
            answer = cnt;
            return;
        }
        for (Integer temp : A[start]) {
            if (!visited[temp]) {
                visited[temp] = true;
                dfs(temp, cnt + 1);
            }
        }
    }
}
