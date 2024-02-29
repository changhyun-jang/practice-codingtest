import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        -- 문제읽기
        1개의 회의실
        N개의 회의
        각회의에 대해 시작시간과 끝나는 시간이 주어짐
        각회의가 겹치지 않게 하면서 
        회의의 최대개수
        N <= 100000

        -- 문제해석
        임의의 시간을 선택했을떄 이후에 가능한 회의가 몇개인지를 체크하여 
        가장 갯수가 많은 시간을 선택
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
        //2차원 배열 정렬하기(끝나는 시간 순서로)
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int result = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            if(A[i][0] >= endTime) {
                endTime = A[i][1];
                result++;
            }
        }
        System.out.println(result);


    }
}
