import java.util.*;

public class Main {
    static int N, M;
    static int[][] A;
    static int[][] B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N][M];
        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            String[] temp = str.split("");
            for (int j = 0; j < temp.length; j++) {
                A[i][j] = Integer.parseInt(temp[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            String[] temp = str.split("");
            for (int j = 0; j < temp.length; j++) {
                B[i][j] = Integer.parseInt(temp[j]);
            }
        }
        if (N < 3 || M < 3) {
            boolean check = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] != B[i][j]) check = false;
                }
            }
            if (check == false) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }

        } else {

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] != B[i][j] && i + 3 <= N && j + 3 <= M) {
                        for (int k = i; k < i + 3; k++) {
                            for (int t = j; t < j + 3; t++) {
                                if (A[k][t] == 0) A[k][t] = 1;
                                else A[k][t] = 0;
                            }
                        }
                        count++;
                    }
                }
            }

            boolean check = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (A[i][j] != B[i][j]) check = false;
                }
            }
            if (check == false) {
                System.out.println(-1);
            } else {
                System.out.println(count);
            }
        }
    }
}
