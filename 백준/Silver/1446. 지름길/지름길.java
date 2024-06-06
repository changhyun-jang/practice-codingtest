import java.util.*;
import java.io.*;

public class Main {
    static class Path {
        int start;
        int end;
        int value;

        Path(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    static boolean[] visited;
    static ArrayList<Path> path;
    static int N, distance, answer;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        path = new ArrayList<>();
        visited = new boolean[N];
        answer = distance;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (end - start <= value) continue;
            if (end > distance) continue;
            path.add(new Path(start, end, value));
        }

        Collections.sort(path, (o1, o2) -> {
            return o1.start - o2.start;
        });
        dp = new int[distance + 1];


        for (int i = 0; i < path.size(); i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = j;
            }
            backTracking(i, 0);
        }
        System.out.println(answer);
    }

    private static void backTracking(int i, int nowPlace) {
        Path temp = path.get(i);
        dp[temp.end] = dp[temp.start] + temp.value;
        for (int j = temp.end + 1; j <= distance; j++) {
            dp[j] = dp[j - 1] + 1;
        }
        nowPlace = temp.end;
        for (int j = i + 1; j < path.size(); j++) {
            if (nowPlace > path.get(j).start) continue;
            backTracking(j, nowPlace);
        }
        answer = Math.min(dp[distance], answer);
    }
}
