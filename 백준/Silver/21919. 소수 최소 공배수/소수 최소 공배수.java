import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static boolean[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        arr = new boolean[1000001];
        for (int i = 2; i < Math.sqrt(1000000); i++) {
            if (arr[i]) continue;
            for (int j = i * i; j < 1000001; j += i) {
                arr[j] = true;
            }
        }
        answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!arr[temp]) set.add(temp);
        }
        if (set.isEmpty()) answer = -1;
        else {
            for (int i : set) {
                answer *= i;
            }
        }
        System.out.println(answer);
    }
}
