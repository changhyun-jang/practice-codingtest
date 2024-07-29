import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    static String L, S, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // lighter 처음 내는 거 입력
        L = br.readLine();
        // smallant가 결승에서 내는 거
        S = br.readLine();
        total = L + S;
        checkAvailable();
        System.out.println(answer);

    }

    private static void checkAvailable() {
        Queue<String> queue = new LinkedList<>();
        queue.add(L);
        for (int i = 1; i < total.length(); i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String poll = queue.poll();
                String s = poll + total.charAt(i);
                queue.add(s);
                queue.add(poll);
            }
        }
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.contains("RSS") || poll.contains("PRR") || poll.contains("SPP") || poll.equals(L)) {
                continue;
            } else {
                answer++;
            }
        }
    }
}
