import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] answer = new ArrayList[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            answer[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            answer[start].add(end);
            arr[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            if(answer[now]!=null) {
                for (int K : answer[now]) {
                    arr[K]--;
                    if(arr[K]==0) queue.offer(K);
                }
            }

        }
    }
}
