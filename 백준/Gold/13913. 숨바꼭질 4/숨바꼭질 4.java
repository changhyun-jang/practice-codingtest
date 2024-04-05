import java.util.*;
import java.io.*;

public class Main {
    static int N, K;

    static class Count {
        int num;
        int count;
        ArrayList<Integer> history = new ArrayList<>();

        Count(int num, int count, ArrayList history) {
            this.num = num;
            this.count = count;
            this.history = history;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        if (K < N) {
            System.out.println(N - K);
            while (K - 1 != N) {
                System.out.print(N + " ");
                N = N - 1;
            }
        } else if (K == N) {
            System.out.println(0);
            System.out.println(K);
        } else {
            ArrayList<Integer> history = new ArrayList<>();
            Count bfs = BFS(N, 0, history);
            System.out.println(bfs.count);
            for (int i : bfs.history) {
                System.out.print(i + " ");
            }
        }
    }

    private static Count BFS(int n, int cnt, ArrayList<Integer> history) {
        Queue<Count> queue = new LinkedList<Count>();
        history.add(n);
        Count answer = null;
        queue.add(new Count(n, cnt, history));
        while (!queue.isEmpty()) {
            Count now = queue.poll();
            answer = now;
            int tempNum = now.num;
            if (tempNum == K) {
                break;
            }
            int tempCount = now.count;
            if (tempNum - 1 >= 0) {
                if (!visited[tempNum - 1]) {
                    ArrayList<Integer> tempMinusHistory = new ArrayList<>(now.history);
                    tempMinusHistory.add(tempNum - 1);
                    visited[tempNum - 1] = true;
                    queue.add(new Count(tempNum - 1, tempCount + 1, tempMinusHistory));
                }
            }
            if (tempNum + 1 <= 100000) {
                if (!visited[tempNum + 1]) {
                    ArrayList<Integer> tempPlusHistory = new ArrayList<>(now.history);
                    tempPlusHistory.add(tempNum + 1);
                    visited[tempNum + 1] = true;
                    queue.add(new Count(tempNum + 1, tempCount + 1, tempPlusHistory));
                }
            }
            if (tempNum * 2 <= 100000) {
                if (!visited[tempNum * 2]) {
                    ArrayList<Integer> tempMultipleHistory = new ArrayList<>(now.history);
                    tempMultipleHistory.add(tempNum * 2);
                    visited[tempNum * 2] = true;
                    queue.add(new Count(tempNum * 2, tempCount + 1, tempMultipleHistory));
                }
            }
        }
        return answer;
    }
}
