import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[M+1];
        boolean[] visited = new boolean[M+1];
        for (int i = 1; i < M+1; i++) {
            A[i] = i;
        }
        visited[1] = true;
        for (int i = 2; i < M+1; i++) {
            //visited[i]가 false면은 실행
            if (visited[i] == false) {
                //temp에 A[i]를 넣고
                int temp = A[i];
                //visited[i]는 true
                visited[i] = true;
                //multiple에는 항상 2를 넣음
                int multiple = 2;
                while(true) {
                    int multiResult = temp * multiple;
                    multiple ++;
                    if(multiResult > M) break;
                    visited[multiResult] = true;
                }
                if(A[i] >= N) {
                    System.out.println(A[i]);
                }
            }
        }
    }
}
