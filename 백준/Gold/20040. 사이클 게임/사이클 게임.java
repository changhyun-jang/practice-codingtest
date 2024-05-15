import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (union(start, end)) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);

    }

    private static boolean union(int start, int end) {
        int tempS = find(start);
        int tempE = find(end);

        if (tempS == tempE) return true;
        if (tempS < tempE) arr[tempE] = tempS;
        else arr[tempS] = tempE;
        return false;
    }

    private static int find(int start) {
        if (arr[start] == start) return start;
        return find(arr[start]);
    }
}
