import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Country {
        int number;
        int gold;
        int silver;
        int bronze;
        int rank;

        Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    static int N, K, rank, answer;
    static Country[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new Country[N];
        rank = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            C[i] = new Country(num, gold, silver, bronze);
        }
        Arrays.sort(C, (o1, o2) -> {
            if (o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            } else {
                if (o1.silver != o2.silver) {
                    return o2.silver - o1.silver;
                } else {
                    if (o1.bronze != o2.bronze) {
                        return o2.bronze - o1.bronze;
                    } else return 0;
                }
            }
        });

        C[0].rank = 1;
        answer = C[0].rank;
        for (int i = 1; i < N; i++) {
            if (C[i - 1].gold == C[i].gold && C[i - 1].silver == C[i].silver && C[i - 1].bronze == C[i].bronze) {
                C[i].rank = C[i - 1].rank;
            } else {
                C[i].rank = i + 1;
            }
            if (C[i].number == K) {
                answer = C[i].rank;
                break;
            }
        }
        System.out.println(answer);

    }
}
