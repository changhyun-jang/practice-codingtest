import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("[,]");
        for (int i = 0; i < str.length; i++) {
            N += Integer.parseInt(str[i]);
        }
        System.out.println(N);

    }
}
