import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fibo = new int[N + 1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= N; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        if (N % 3 == 2) {
            A.add(1);
            B.add(2);
            for (int i = N; i >= 3; i -= 3) {
                A.add(i);
                B.add(i-1);
                B.add(i-2);
            }
        } else {
            for (int i = N; i > N % 3; i -= 3) {
                A.add(i);
                B.add(i-1);
                B.add(i-2);
            }
        }

        System.out.println(A.size());
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
        System.out.println();
        System.out.println(B.size());
        for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }
    }
}
