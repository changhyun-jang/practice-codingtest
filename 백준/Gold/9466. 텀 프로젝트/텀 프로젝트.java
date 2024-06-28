import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N, answer;
    static int[] P;
    static boolean[] visited;
    static boolean flag;

    static Deque<Integer> deque;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            // 사람 수 입력받기
            N = Integer.parseInt(br.readLine());
            // 사람 담을 배열 선언
            P = new int[N + 1];
            // 방문 확인 배열
            visited = new boolean[N + 1];
            answer = 0;
            // 누구를 지목했는지 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    flag = false;
                    deque = new LinkedList<>();
                    set = new HashSet<>();
                    check(i);
                    if (flag) {
                        int start = deque.pollLast();
                        while (true) {
                            int temp = deque.pollLast();
                            answer++;
                            if (temp == start) {
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(N - answer);
        }
    }

    private static void check(int num) {
        if (set.contains(num)) {
            deque.addLast(num);
            flag = true;
            return;
        }
        if (!visited[num]) {
            visited[num] = true;
            deque.addLast(num);
            set.add(num);
            check(P[num]);
        }
    }
}
