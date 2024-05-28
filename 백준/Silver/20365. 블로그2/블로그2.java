import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 500001;
        int temp = 1;
        String[] color = sc.next().split("");
        //앞에서부터 칠해간경우
        for (int i = 1; i < N; i++) {
            if (!color[i - 1].equals(color[i])) {
                temp++;
            }
        }
        answer = Math.min(answer, temp);

        // 파랑으로 먼저 칠한 후, 빨강을 칠한 경우
        temp = 1;
        for (int i = 0; i < N; i++) {
            if (color[i].equals("R") && (i == 0 || !color[i - 1].equals(color[i]))) {
                temp++;
            }
        }
        answer = Math.min(answer, temp);
        // 빨강으로 먼저 칠한 후, 파랑을 칠한 경우
        temp = 1;
        for (int i = 0; i < N; i++) {
            if (color[i].equals("B") && (i == 0 || !color[i - 1].equals(color[i]))) {
                temp++;
            }
        }
        answer = Math.min(answer, temp);
        System.out.println(answer);
    }
}
