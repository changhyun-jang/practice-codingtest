import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제풀이

     */
    static int N, L;

    static class Info {
        long start;
        long end;

        Info(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    static ArrayList<Info> A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            A.add(new Info(start, end));
        }
        Collections.sort(A, (o1, o2) -> (int) (o1.start - o2.start));
        long count = 0;
        long nowCover = 0;
        for (Info temp : A) {
            long start = temp.start;
            long end = temp.end;
            if (nowCover >= end) continue;
            if (nowCover >= temp.start) start = nowCover;
            if ((end - start) % L == 0) {
                long tempCount = (end - start) / L;
                count += tempCount;
                nowCover = start + L * tempCount;
            } else {
                long tempCount = (end - start) / L + 1;
                count += tempCount;
                nowCover = start + L * tempCount;
            }
        }
        System.out.println(count);
    }
}
