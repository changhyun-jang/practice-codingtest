import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            deque.add(str);
            for (int j = 0; j < N-1; j++) {
                String temp = st.nextToken();
                if (temp.compareTo(str) <= 0) {
                    deque.addFirst(temp);
                    str = temp;
                } else {
                    deque.addLast(temp);
                }
            }
            while(!deque.isEmpty()) {
                System.out.print(deque.pollFirst());
            }
            System.out.println();
        }
    }
}
