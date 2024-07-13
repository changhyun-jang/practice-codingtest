import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(Integer.parseInt(st.nextToken()));
            for (int test_case = 0; test_case < N-1; test_case++) {
                int temp = arr.size();
                int num = Integer.parseInt(st.nextToken());
                if (arr.get(temp - 1) != num) {
                    arr.add(num);
                }
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.print("$");
            System.out.println();
        }
    }
}
