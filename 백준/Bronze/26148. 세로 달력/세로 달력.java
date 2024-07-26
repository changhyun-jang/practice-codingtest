import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] count;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        if ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) {
            year[1]++;
        }
        for (int i = 0; i < year.length; i++) {
            count = new int[8];
            while (year[i] != 0) {
                if (day == 8) {
                    day = 1;
                }
                count[day++]++;
                year[i]--;
            }
            for (int j = 1; j < count.length; j++) {
                if (count[j] == 5) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
