import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static Deque<Integer> block = new LinkedList<>();
    static int nextFirst, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int blockHeight = Integer.parseInt(st.nextToken());
            if (block.isEmpty()) {
                if (blockHeight != 0) {
                    block.addLast(blockHeight);
                }
            } else {
                if (block.peekFirst() > blockHeight) block.addLast(blockHeight);
                else {
                    nextFirst = blockHeight;
                    while (!block.isEmpty()) {
                        answer += block.peekFirst() - block.pollLast();
                    }
                    block.add(nextFirst);
                }
            }
        }
        if (block.size() != 1) {
            int standard = block.pollLast();
            while (!block.isEmpty()) {
                if (block.peekLast() >= standard) standard = block.pollLast();
                else {
                    answer += standard - block.pollLast();
                }
            }
        }
        System.out.println(answer);
    }
}
