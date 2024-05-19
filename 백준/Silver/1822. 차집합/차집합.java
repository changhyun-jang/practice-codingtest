import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] Arr1, Arr2;
    static ArrayList<Integer> arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Arr1 = new int[N];
        Arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Arr1);
        Arrays.sort(Arr2);
        count = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < Arr1.length; i++) {
            if (binarySearch(Arr1[i])) {
                arr.add(Arr1[i]);
                count++;
            }
        }
        if (arr.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(count);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
    }

    private static boolean binarySearch(int num) {
        int start = 0;
        int end = Arr2.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num == Arr2[mid]) {
                return false;
            } else if (num < Arr2[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return true;
    }
}
