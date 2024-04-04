import java.util.*;

public class Main {
    static int T, K;
    static int[] novel;
    static PriorityQueue<Long> queue;
    static long sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            sum=0;
            queue = new PriorityQueue<>((o1, o2) -> (int) (o1 - o2));
            K = sc.nextInt();
            novel = new int[K];
            for (int j = 0; j < K; j++) {
                queue.add(sc.nextLong());
            }
            cal();
            System.out.println(sum);
        }
    }

    private static void cal() {
        while(queue.size()!=1){
            long min1 = queue.poll();
            long min2 = queue.poll();
            long temp = min1 + min2;
            sum += temp;
            queue.add(temp);
        }
    }
}
