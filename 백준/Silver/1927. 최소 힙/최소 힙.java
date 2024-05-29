import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp == 0) {
                if (queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            } else {
                queue.add(temp);
            }
        }

    }
}
