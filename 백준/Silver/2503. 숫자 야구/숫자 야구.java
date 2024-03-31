import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (i != j) {
                    for (int k = 0; k < num.length; k++) {
                        if (i != k && j != k) {
                            queue.offer(num[i] + num[j] + num[k]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            String[] split1 = number.split("");

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String now = queue.poll();
                String[] split2 = now.split("");
                int tempStrike = 0;
                int tempBall = 0;

                for (int n = 0; n < 3; n++) {
                    for (int m = 0; m < 3; m++) {
                        if (split1[n].equals(split2[m])) {
                            if (n == m) {
                                tempStrike += 1;
                            } else {
                                tempBall += 1;
                            }
                        }
                    }
                }
                if (tempStrike == strike && tempBall == ball) {
                    queue.offer(now);
                }
            }
        }

        System.out.println(queue.size());
    }
}
