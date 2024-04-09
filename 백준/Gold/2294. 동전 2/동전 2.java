import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static ArrayList<Integer> coin;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sum = new int[10001];
        Arrays.fill(sum, 10001);
        coin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if (coin.contains(temp)) {
                continue;
            }
            coin.add(temp);
        }
        Collections.sort(coin);

        for (int i = 0; i < coin.size(); i++) {
            if (coin.get(i) <= K) sum[coin.get(i)] = 1;
        }

        for (int i = 1; i <= K; i++) {
            if (sum[i] == 1) continue;
            for (int j = 1; j <= i / 2; j++) {
                sum[i] = Math.min(sum[i], sum[j] + sum[i - j]);
            }
        }
//        for (int i = 0; i < sum.length; i++) {
//            System.out.println(i + " : " + sum[i]);
//        }
        if (sum[K] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(sum[K]);
        }

    }
}
