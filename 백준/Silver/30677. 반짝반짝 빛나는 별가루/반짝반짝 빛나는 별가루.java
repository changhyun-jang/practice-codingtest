import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, C, R, fatigability;
    static long answer;
    // i번 마법을 사용했을때 기본적으로 만들 수 있는 별가루 갯수
    static int[] base;

    // s 상숫값
    static int[] s;

    // 마법을 사용했을때 얻는 피로돈
    static int[] p;

    // 연속으로 마법을 사용한 횟수를 저장할 변수
    static int combo;
    static int[] workmanship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        base = new int[K + 1];
        s = new int[K + 1];
        p = new int[K + 1];
        workmanship = new int[K + 1];
        fatigability = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num != 0) {
                // 휴식이 아닐 때
                // 모으는 별조각 계산
                double stardust = base[num] * (1 + ((double) combo * C / (double) 100)) * (1 + ((double) workmanship[num] * s[num] / (double) 100));
                answer += stardust;
                // combo+1
                combo += 1;
                // 피로도 누적
                fatigability += p[num];
                // 숙련도 +1
                workmanship[num] += 1;

            } else {
                // 휴식일 때
                combo = 0;
                fatigability -= R;
                if (fatigability < 0) fatigability = 0;
            }
            if (fatigability > 100) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }
}
