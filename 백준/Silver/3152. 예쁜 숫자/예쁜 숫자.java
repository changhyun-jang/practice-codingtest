import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int p;
    static long n1, n2, n3, n4;
    static HashMap<Long, Integer> map = new HashMap<>();
    static ArrayList<Long> arr = new ArrayList<>();
    static Queue<Long> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        n1 = Long.parseLong(st.nextToken());
        n2 = Long.parseLong(st.nextToken());
        n3 = Long.parseLong(st.nextToken());
        n4 = Long.parseLong(st.nextToken());
        long maxN = Math.max(n1, Math.max(n2, Math.max(n3, n4)));
        queue.add(1L);
        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            if (poll >= maxN) {
                break;
            }
            for (Long l : arr) {
                if (map.containsKey(l + poll)) {
                    map.put(l + poll, map.get(l + poll) + 1);
                } else {
                    map.put(l + poll, 1);
                }
            }
            arr.add(poll);
            queue.offer(poll * p);
            queue.offer(poll * p + 1);
        }
        if(map.containsKey(n1) && map.get(n1)==1) {
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }
        if(map.containsKey(n2) && map.get(n2)==1) {
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }
        if(map.containsKey(n3) && map.get(n3)==1) {
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }
        if(map.containsKey(n4) && map.get(n4)==1) {
            System.out.print(1+" ");
        }else{
            System.out.print(0+" ");
        }
    }
}
