import java.util.*;
class Solution {
    static ArrayList<Node>[] graph;
    static int n, k;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        n = N;
        k = K;
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int tmp1 = road[i][0];
            int tmp2 = road[i][1];
            int tmp3 = road[i][2];
            graph[tmp1].add(new Node(tmp2, tmp3));
            graph[tmp2].add(new Node(tmp1, tmp3));
        }
        
        int answer = dijkstra();
        
        return answer;
    }
    
    public int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(1,0));
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            for(Node next : graph[now.end]) {
                if(dist[now.end] + next.weight < dist[next.end]) {
                    dist[next.end] = dist[now.end] + next.weight;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        int answer = 0;
        for(int i :dist) {
            if(i <= k) answer++;
        }
        return answer;
    }
}

class Node implements Comparable<Node>{
    public int end;
    public int weight;
    
    Node (int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}