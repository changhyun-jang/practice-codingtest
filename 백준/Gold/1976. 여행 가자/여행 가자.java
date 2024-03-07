import java.util.*;
import java.io.*;

public class Main {
    /*
    --문제읽기
    한국에는 N개의 도시, 두 도시 사이에 길이 있을 수도 없을 수도 있음
    여행일정이 주어졌을때,여행이 가능한 경로인지 알아보기.
    중간에 다른 도시를 경유해서 여행할 수 있음.
    같은 도시를 여러 번 방문하는 것 가능
    N <= 200
    M <= 1000
    i번째 줄의 j번쨰 수는 i와 j번 도시의 연결 정보를 의미
    
    --문제풀이
     */
    static int[] city;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        city = new int[N+1];
        for(int i = 1; i <= N; i++) {
            city[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] road = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
                if( road[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue= new LinkedList<>();
        int[] tour = new int [M+1];
        for(int i = 0; i < M; i++) {
            tour[i] = Integer.parseInt(st.nextToken());
            queue.offer(find(tour[i]));
        }
        int temp = queue.poll();
        String answer = "YES";
        while(!queue.isEmpty()) {
            int check = queue.poll();
            if(temp != check) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);
        if(i != j) {
            city[j] = i;
        }
    }

    private static int find(int i) {
        if(i == city[i]) {
            return i;
        } else {
            //거리 압축
            return city[i] = find(city[i]);
        }
    }

}
