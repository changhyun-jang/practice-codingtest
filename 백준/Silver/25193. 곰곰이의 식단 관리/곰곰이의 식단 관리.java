import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int countC = 0;
        int countO = 0;
        for (int i = 0; i < N; i++) {
            if (str[i].equals("C")) {
                countC++;
            } else {
                countO++;
            }
        }
        countO++;
        int answer = countC / countO;
        if (countC % countO != 0) {
            answer++;
        }
        System.out.println(answer);
    }
}
