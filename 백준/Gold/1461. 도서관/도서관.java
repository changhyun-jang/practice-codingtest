import java.util.*;
import java.io.*;

public class Main {
    static int N, M, answer;
    static int[] books;
    static ArrayList<Integer> A;
    static Queue<Integer> minus = new LinkedList<>();
    static Deque<Integer> plus = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        A = new ArrayList<>();
        books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(books);
        for (int i = 0; i < N; i++) {
            if (books[i] < 0) minus.offer(books[i]);
            else plus.offerFirst(books[i]);
        }
        int temp = 0;
        int cnt = 0;
        while (!minus.isEmpty()) {
            temp = Math.max(Math.abs(temp), Math.abs(minus.poll()));
            cnt += 1;
            if (cnt == M || minus.isEmpty()) {
                cnt = 0;
                A.add(temp);
                temp = 0;
            }
        }
        while (!plus.isEmpty()) {
            temp = Math.max(Math.abs(temp), plus.poll());
            cnt += 1;
            if (cnt == M || plus.isEmpty()) {
                cnt = 0;
                A.add(temp);
                temp = 0;
            }
        }
        Collections.sort(A);

//        for(int i :A){
//            System.out.println(i);
//        }
        for (int i = 0; i < A.size(); i++) {
            if (i == A.size() - 1) {
                answer += A.get(i);
                break;
            }
            answer += A.get(i) * 2;
        }
        System.out.println(answer);
    }
}
