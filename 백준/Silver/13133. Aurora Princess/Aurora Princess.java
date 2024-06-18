import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int mom = Integer.parseInt(st.nextToken());
            int father = Integer.parseInt(st.nextToken());
            if (mom != 0 && father != 0) {
                A[i].add(mom);
                A[i].add(father);
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        check = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            check.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= N; i++) {
            boolean C = true;
            if (!A[i].isEmpty() && !check.contains(i)) {
                for (int temp : A[i]) {
                    if (check.contains(temp)) C = false;
                }
            }else{
                C = false;
            }
            if (C) answer++;
        }
        System.out.println(answer);
    }
}
