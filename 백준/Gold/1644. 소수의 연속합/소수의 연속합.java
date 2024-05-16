import java.util.*;
import java.io.*;

public class Main {
    /*
     에라토스테네스의 체를 이용한 소수 구하기
     부분합 구하기
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] arr = new boolean[N + 1];
        boolean[] visitedE = new boolean[N + 1];
        boolean[] visitedS = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == true) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = false;
                }
            }
        }
        int count = 0;
        long sum = 0;
        int start = 0;
        int end = 1;
        while (start < end && end <= N) {
            if (arr[end] && !visitedE[end]) {
                visitedE[end] = true;
                sum += end;
                if (sum == N) {
                    count++;
                }
            }
            if (arr[start] && !visitedS[start]) {
                visitedS[start] = true;
                sum -= start;
                if (sum == N) {
                    count++;
                }
            }

            if (sum > N) {
                start++;
            } else if (sum < N) {
                end++;
            } else {
                end++;
            }

        }
        System.out.println(count);
    }
}
