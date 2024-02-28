import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        -- 문제 접근하기 --
        그리디 알고리즘을 통해 항상 최선의 선택을 할 것
        주어진 금액보다 같거나 작은 동전을 선택하기
         */
        Scanner sc = new Scanner(System.in);
        //N 입력 받기
        int N = sc.nextInt();
        //K 입력 받기
        int K = sc.nextInt();
        //동전의 가격을 저장할 배열
        int[] A = new int[N];

        //동전의 가격을 배열에 저장하기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        //동전의 개수
        int result = 0;

        // N이 0보다 클동안 계속 반복
        while (K > 0) {
            for (int i = N - 1; i > -1; i--) {
                if (A[i] <= K) {
                    int count = K / A[i];
                    K = K - A[i] * count;
                    result += count;
                }
            }
        }
        System.out.println(result);
    }
}
