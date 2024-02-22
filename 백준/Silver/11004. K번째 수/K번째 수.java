import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // A : 배열
        // S : 투포인터 중 작은값
        // E : 투포인터 중 큰값
        // K : 정답 인덱스
        quicksort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void quicksort(int[] a, int S, int E, int K) {
        if (S < E) {
            //기준점의 인덱스
            int pivot = partition(a, S, E);
            if (pivot == K) {
                return;
            }
            else if (pivot < K) {
                quicksort(a, pivot+1, E, K);
            } else {
                quicksort(a, S, pivot-1, K);
            }

        }
    }

    public static int partition(int[] a, int S, int E) {
        if (S + 1 == E) {
            if (a[S] > a[E]) swap(a, S, E);
            return E;
        }
        int M = (S + E) / 2;
        swap(a, S, M);
        int pivot = a[S];
        int i = S + 1;
        int j = E;
        while (i <= j) {
            while (a[i] < pivot && i <= E) {
                i++;
            }
            while (a[j] > pivot && j >= S + 1) {
                j--;
            }
            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        a[S] = a[j];
        a[j] = pivot;
        return j;
    }

    public static void swap(int[] a, int s, int e) {
        int temp = a[e];
        a[e] = a[s];
        a[s] = temp;
    }

}
