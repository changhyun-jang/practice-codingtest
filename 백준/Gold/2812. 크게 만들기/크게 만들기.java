import java.util.*;
import java.io.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] temp = st.nextToken().split("");
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temp.length; i++) {
            while (K > 0 && !stack.isEmpty() && stack.getLast() < Integer.parseInt(temp[i])) {
                stack.removeLast();
                K--;
            }
            stack.addLast(Integer.parseInt(temp[i]));
        }
        while (stack.size() > K) {
            System.out.print(stack.removeFirst());
        }
    }
}
