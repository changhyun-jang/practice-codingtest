import java.io.*;
import java.util.*;
 
public class Main {
    static int[] code = new int[400_001];   // 재난 코드 저장
    static ArrayList<Edge>[] list;   // 연결 노드, 시간 저장
    static boolean[] prime = new boolean[10_000_001];   // 소수 판별
    static long[] time;     // 최소 시간 저장
    static int n, m;    // 노드, 도로 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n;i++){
            code[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(prime, true);
        for (int i = 2; i<=Math.sqrt(10000000);i++){
            if (!prime[i]) {
                continue;
            }
            for (int j = i * i; j <= 10000000; j += i) {
                prime[j] = false;
            }
        }
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
 
        time = new long[n + 1];
 
        for (int i = 0; i <= n;i++) time[i] = Long.MAX_VALUE;
 
        // 리스트에 시작 노드 + 도착 노드 + 가중치 저장
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());
 
            if (!prime[code[s] + code[e]]) continue;    // 소수가 아니라면 저장하지 않고 넘어감
 
            list[s].add(new Edge(e, plus));     // 시작 노드 위치에 끝 노드, 시간 저장
            list[e].add(new Edge(s, plus));     // 끝 노드 위치에 시작노드, 시간 저장
        }
        // 시작 버정
        dijkstra(1);
 
        System.out.println((time[n] == Long.MAX_VALUE) ? "Now where are you?" : time[n]);
 
    }
    static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        time[start] = 0;
        q.offer(new Edge(start, 0));
 
        while (!q.isEmpty()){
            Edge now = q.poll();
            if (time[now.node] < now.plus) continue;
 
            for (Edge i : list[now.node]) {
                int e = i.node;
                long p = i.plus;
 
                if (now.plus + p < time[e]) {
                    time[e] = now.plus + p;
                    q.offer(new Edge(e, time[e]));
                }
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int node;
        long plus;
 
        public Edge(int node, long plus) {
            this.node = node;
            this.plus = plus;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Long.compare(plus, o.plus);
        }
    }}