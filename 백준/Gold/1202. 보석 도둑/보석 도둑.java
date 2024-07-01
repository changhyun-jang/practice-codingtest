import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static long answer;
    static Integer[] bag;

    static class Jewelry {
        int weight;
        int value;

        Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static boolean[] visited;
    static Jewelry[] J;
    //    static PriorityQueue<Jewelry> J = new PriorityQueue<>((o1, o2) -> {
//        if (o1.value < o2.value) {
//            return 1;
//        } else if (o1.value == o2.value) {
//            if (o1.weight < o2.weight) return -1;
//            return 1;
//        } else return -1;
//    });
    static Queue<Jewelry> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new Integer[K];
        visited = new boolean[K];
        J = new Jewelry[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tempW = Integer.parseInt(st.nextToken());
            int tempV = Integer.parseInt(st.nextToken());
            J[i] = new Jewelry(tempW, tempV);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bag);
        Arrays.sort(J, (o1, o2) -> {
            if(o1.weight == o2.weight)
                return o1.value- o2.value;
            return o1.weight - o2.weight;
        });


        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.value == o2.value)
                return o1.weight- o2.weight;
            return o2.value - o1.value;
        });

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && J[j].weight <= bag[i]) {
                pq.offer(J[j++]);
            }
            if(!pq.isEmpty()) {
                answer += pq.poll().value;
            }
        }

        System.out.println(answer);

    }
}
