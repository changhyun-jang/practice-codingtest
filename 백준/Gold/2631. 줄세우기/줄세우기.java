import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] A;
	static int[] length;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N + 1];
		length = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			length[i] = 1;
			for (int j = 1; j < i; j++) {
				if (A[j] < A[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
					max = Math.max(length[i], max);
				}
			}
		}
		System.out.println(N - max);
	}
}
