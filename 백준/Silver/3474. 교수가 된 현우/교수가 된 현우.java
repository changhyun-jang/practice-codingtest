import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int answer = 0;
            while (num >= 5) {
                answer += num / 5;
                num /= 5;
            }
            System.out.println(answer);
        }
    }
}
