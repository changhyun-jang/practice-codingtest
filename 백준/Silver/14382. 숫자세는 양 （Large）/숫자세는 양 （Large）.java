import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            Set<Character> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 1; j <= 100; j++) {
                int temp = j * N;
                String s = String.valueOf(temp);
                for (int k = 0; k < s.length(); k++) {
                    if (!set.contains(s.charAt(k))) {
                        set.add(s.charAt(k));
                    }
                }
                if (set.size() == 10) {
                    N = temp;
                    break;
                }
            }
            if (set.size() == 10) {
                System.out.println("Case #" + i + ": " + N);
            }else{
                System.out.println("Case #" + i + ": INSOMNIA");
            }
        }
    }
}
