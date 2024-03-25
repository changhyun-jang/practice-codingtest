import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static boolean[] visited;
    static String[] command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            command = new String[10000];
            BFS(start, end);
            System.out.println(command[end]);
        }
    }

    private static void BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        command[start] = "";
        while (!queue.isEmpty()) {
            int nowNumber = queue.poll();
            if (nowNumber == end) break;
            visited[nowNumber] = true;

            int D = (nowNumber * 2) % 10000;
            int S = (nowNumber + 9999) % 10000;
            int L = (nowNumber % 1000) * 10 + nowNumber / 1000;
            int R = (nowNumber % 10) * 1000 + nowNumber / 10;

            if (!visited[D]) {
                visited[D] = true;
                command[D] = command[nowNumber] + "D";
                queue.offer(D);
            }
            if (!visited[S]) {
                visited[S] = true;
                command[S] = command[nowNumber] + "S";
                queue.offer(S);
            }
            if (!visited[L]) {
                visited[L] = true;
                command[L] = command[nowNumber] + "L";
                queue.offer(L);
            }
            if (!visited[R]) {
                visited[R] = true;
                command[R] = command[nowNumber] + "R";
                queue.offer(R);
            }
        }
    }
}
