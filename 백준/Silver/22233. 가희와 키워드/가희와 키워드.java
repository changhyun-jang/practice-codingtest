import java.util.*;
import java.io.*;

public class Main {
    /*
    -- 문제 읽기
        메모장에 써진 키워드 N개 존재
        최대 10개의 키워드에 대해 글을 작성
        메모장에 있었던 키워드는 글을 쓴 후, 지워짐.

        가희가 메모장에 적은 키워드 N
        블로그에쓴 글 개수 M


     */
    static int N, M;
    static HashMap<String, Integer> A = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A.put(st.nextToken(),1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String[] arr = st.nextToken().split(",");
            for (String word : arr) {
                if(A.containsKey(word) && A.get(word)==1) {
                    N--;
                    A.put(word,0);
                }
            }
            System.out.println(N);
        }
    }
}
