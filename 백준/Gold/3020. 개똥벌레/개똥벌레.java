import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, H, answerC, answerR;
    static int[] up;
    static int[] down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        answerC = Integer.MAX_VALUE;
        answerR = 0;

        up = new int[(N + 1) / 2];
        down = new int[N - up.length];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i % 2 == 0) {
                up[i / 2] = Integer.parseInt(st.nextToken());
            } else {
                down[i / 2] = H - Integer.parseInt(st.nextToken()) + 1;
            }
        }
        Arrays.sort(down);
        Arrays.sort(up);

        for (int i = 1; i <= H; i++) {
            int temp = 0;
            int upCount = binarySearch(i, up);
            temp += up.length - upCount;
            int downCount = binarySearch2(i, down);
            temp += downCount;

//            System.out.println(i + " : " + temp);
//            System.out.println(downCount);
            if (answerC > temp) {
                answerC = temp;
                answerR = 1;
            } else if (answerC == temp) {
                answerR++;
            }
        }
        System.out.println(answerC + " " + answerR);

    }

    private static int binarySearch(int num, int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static int binarySearch2(int num, int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }


}
