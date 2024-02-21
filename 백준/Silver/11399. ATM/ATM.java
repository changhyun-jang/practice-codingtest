import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        sum[0] = A[0];
        int total = sum[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + A[i];
            total += sum[i];
        }
        System.out.println(total);
    }
}