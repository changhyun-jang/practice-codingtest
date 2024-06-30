import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] arr = br.readLine().split(" ");
        for (String temp : arr) {
            if (Integer.parseInt(temp) > 0) answer++;
        }
        System.out.println(answer);
    }
}
