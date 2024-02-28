import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) {
                return o1 > o2 ? 1: -1;
            } else {
                return first_abs - second_abs;
            }
        });
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if(queue.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(x);
            }
        }
    }
}
