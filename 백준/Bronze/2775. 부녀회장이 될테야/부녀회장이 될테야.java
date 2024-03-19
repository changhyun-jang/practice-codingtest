import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    A[a][b] 살려면 A[a-1][1]+....A[a-1][b] 만큼데려와 살아야함
    비어있는집은 없고 모든 거주민들이 이계약 조건을 지킴
    양의정수 k와 n이 주어짐 k층n호에 몇명이 살까요?
    아파트는 0층 부터 있음
    각층에는 1호부터 있으며 0층의 i호에는 i명이 살고 있음
    
    --문제풀이
    A[i][j] = A[i][j-1] + A[i-1][j];
    */
    static int T;
    static int[][] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        A = new int[15][15];
        for (int i = 1; i < 15; i++) {
            A[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                A[i][j] = A[i][j - 1] + A[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(A[k][n]);
        }
    }
}
