import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            int now = Integer.parseInt(st.nextToken());
            sb.append(now + " ");
            for (int test_case = 0; test_case < N - 1; test_case++) {
                int num = Integer.parseInt(st.nextToken());
                if (now != num) {
                    sb.append(num + " ");
                    now = num;
                }
            }
            sb.append("$\n");
        }
        System.out.print(sb);
    }
}
