import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] score;
    static boolean[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        temp = new boolean[1000001];
        score = new int[1000001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp[arr[i]] = true;
        }

        for (int i : arr) {
            for (int j = i * 2; j < 1000001; j += i) {
                if (temp[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }
        for (int i : arr) {
            System.out.print(score[i] + " ");
        }

    }
}
