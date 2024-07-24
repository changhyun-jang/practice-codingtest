import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] train = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int tempT = Integer.parseInt(st.nextToken());
            tempT -= 1;
            if (command == 1) {
                int chair = Integer.parseInt(st.nextToken());
                train[tempT] |= (1 <<  (chair - 1));
            } else if (command == 2) {
                int chair = Integer.parseInt(st.nextToken());
                train[tempT] &= ~(1 << (chair - 1));
            } else if (command == 3) {
                train[tempT] = train[tempT] << 1;
                train[tempT] &= ((1 << 20) - 1);
            } else {
                train[tempT] = train[tempT] >> 1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(train[i]);
        }
        System.out.println(set.size());
    }
}
