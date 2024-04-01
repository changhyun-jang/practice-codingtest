import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    N개의로프 -> 물체를 들어올릴 수 있음, 굵기나 길이가 달라 
    들 수 있는 물체의 중량이 서로 다를 수 있음
    
    병렬 연결하면 중량을나눌 수 있음
    K개 로프를 사용하여 w중량인 물체를 들어 올릴때 각 로프에 w/k만큼의 중량이 걸리게됨 
    로프들에 대한정보가 주어졌을때 들어올릴 수있는 무체의 최대 중량을 구해야함
    모든로프를 사용할 필요없음 몇개의로프를 골라서사용해도됨

    --문제풀이
    선택한 로프의 최소 중량*선택한 로프의 갯수 만큼이 들 수 있는 중량이다.
    내림차순으로 배열을 정렬하고, 하나씩 선택하면서 최대 중량을 구하다 크면 추가하고 작으면 멈추고 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A, Collections.reverseOrder());
        long maxWeight = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] * (i + 1) >= maxWeight) maxWeight = A[i] * (i + 1);
        }
        System.out.println(maxWeight);
    }
}
