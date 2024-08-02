import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking("", 0, 0);
    }

    private static void backTracking(String temp, int cnt, int idx) {
        if (cnt == M) {
            if (!set.contains(temp)) {
                set.add(temp);
                System.out.println(temp.substring(1));
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            backTracking(temp + " " + arr[i], cnt + 1, i + 1);
        }
    }
}
