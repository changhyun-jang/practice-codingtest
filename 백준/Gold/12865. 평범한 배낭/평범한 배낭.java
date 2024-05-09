import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] DP;
    static int[] W;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        DP = new int[K + 1][N + 1];
        W = new int[N + 1];
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                // 가방 무게 : i, 현재 결정해야하는 물건 j
                // W[j], 즉 물건의 무게가 현재 가방이 버틸 수 있는 무게 i보다 크면 못넣으므로
                if (W[j] > i) {
                    DP[i][j] = DP[i][j - 1];
                }
                // W[j],즉 물건의 무게가 현재 가방이 버틸 수 있는 무게 i보다 작거나 같으면 넣을 수 있다.
                // 근데 이떄 넣을 수 도 있고 안넣을 수도 있다.
                if (W[j] <= i) {
                    // 안넣을떄는 앞에 있는값을 가져오고
                    // 넣을떄는 현재 선택된 물건의 가치 + (총 배낭 무게 - 현재 선택된 물건의 무게)에서 넣을 수 있는 최대값
                    // 이둘을 비교했을때 큰 값이 DP에 들어간다.
                    DP[i][j] = Math.max(DP[i][j - 1], V[j] + DP[i - W[j]][j-1]);
                }
            }
        }
        
        System.out.println(DP[K][N]);
    }
}
