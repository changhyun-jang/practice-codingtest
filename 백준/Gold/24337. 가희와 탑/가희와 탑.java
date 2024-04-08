import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    --문제읽기
    다양한 높이 건물 N개가 존재
    가희는 건물들 왼쪽에 단비는 오른쪾에 있음
     1. 가희의 오른쪽에 1번 건물이 있음
     2. x가 1이상 N-1이하일때 x번 건물의 오른쪽에는 x+1이 있습니다.
     3. N번 건물의 오른쪽에는 단비가 있음

     가희는 1번 건물을 볼 수 있음
     k번 건물보다 왼쪽에 있는 건물이 모두 K번 건물보다 높이가 낮다면 k번 건물을 볼 수 있음
     단비는 N번 건물을 볼 수 있음
     k번 건물보다 오른쪾에 있는 건물이 모두 k번 건물보다 높이가 낮다면 k번 건물을 볼 수 있음

     가희와 단비 사이 건물 갯수 N개 가희가 볼 수 있는 건물의 개수 a, 단비가 볼 수 있는 건물의 개수 b
     사전순으로 가장 앞서는 N개의 건물높이 정보를 출력

     높이는 1도카 그거나 같은 정수 여야함
     문제의 조건에 맞는 건물의 높이정보가 존재하지 않으면 첫줄에 -1을 출력

    --문제풀이

     */
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        A = new int[N];
        int checkR = N - 1;

        for (int i = 0; i < N; i++) {
            A[i] = 1;
        }
        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        if (a <= b) {
            for (int i = N - 2; i > N - b; i--) {
                A[i] = A[i + 1] + 1;
            }
            if (a == 1) {
                A[0] = b;
            } else {
                A[N - b] = b;
                for (int i = N - b - (a - 2); i < N - b; i++) {
                    A[i] = A[i - 1] + 1;
                }
            }

        } else {
            checkR = N - b;
            A[checkR] = a;
            for (int i = N - 2; i > checkR; i--) {
                A[i] = A[i + 1] + 1;
            }
            for (int i = checkR - 1; i > checkR - a + 1; i--) {
                A[i] = A[i + 1] - 1;
            }
        }

        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
