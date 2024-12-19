import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] charArr = br.readLine().toCharArray();
        int countC = 0;
        int countO = 0;
        for (int i = 0; i < N; i++) {
            if (charArr[i] == 'C') {
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
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
