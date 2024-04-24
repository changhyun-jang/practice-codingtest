import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static class lesson {
        long start;
        long end;

        lesson(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    static lesson[] time;
    static PriorityQueue<Long> queue = new PriorityQueue<>((o1, o2) -> (int) (o1 - o2));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        time = new lesson[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            time[i] = new lesson(start, end);
        }
        Arrays.sort(time, (o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start == o2.start) {
                if (o1.end < o2.end) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        queue.add(time[0].end);
        for (int i = 1; i < N; i++) {
            if (queue.peek() <= time[i].start) {
                queue.poll();
            }
            queue.add(time[i].end);
        }
        System.out.println(queue.size());
    }
}
