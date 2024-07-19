import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int K = Integer.parseInt(br.readLine());
        if (str.equals("annyong")) {
            if (K % 2 == 1) {
                System.out.println(K);
            } else {
                System.out.println(K - 1);
            }
        } else {
            if (K % 2 == 0) {
                System.out.println(K);
            } else if (1 == K) {
                System.out.println(K + 1);
            } else {
                System.out.println(K - 1);
            }
        }
    }
}
