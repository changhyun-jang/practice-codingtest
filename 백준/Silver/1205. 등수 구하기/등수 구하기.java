import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, score, P;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        if(N==0){
            System.out.println(1);
        }else{
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
                if (deque.size() > P) {
                    deque.pollFirst();
                }
            }
            if (deque.peekFirst() >= score && deque.size() == P) {
                System.out.println(-1);
            }  else {
                int tempRank = 0;
                int range = deque.size();
                for (int i = 0; i < range; i++) {
                    if (deque.pollLast() > score) tempRank++;
                    else break;
                }
                System.out.println(tempRank + 1);
            }
        }

    }
}
