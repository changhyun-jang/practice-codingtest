import java.util.*;

public class Main {
    /*
    --문제풀이
    N명중 몇등할 것 인지 예상등수 
    예상등수를 바탕으로 임의로 등수를 매기기로함
    A등으로 예상했는데 실제 등수가 B일경우 불만도는 A와 B차이
    |A-B|로 수치화
    불만도의 총합을 최소로하며 등수를 매기려고함
    
    각예상등수가 주어졌을때 불만도의 합을 최소로하는 프로그램을 작성
     */
    static int N;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer = answer + Math.abs(A[i]-(i+1));
        }
        System.out.println(answer);
    }
}
