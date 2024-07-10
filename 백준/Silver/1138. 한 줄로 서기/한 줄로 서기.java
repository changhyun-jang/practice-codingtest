import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] order = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        arr.add(N);
        for (int i = N - 1; i >= 1; i--) {
            int temp = order[i];
            int size = arr.size();
            while (temp != size) {
                size--;
            }
            arr.add(size, i);
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}