import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static int[] distance;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        A = new ArrayList[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <=n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i< edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            A[start].add(end);
            A[end].add(start);
        }
        distance[1] = 0;
        BFS(1);
        int count = 0;
        int max = 0;
        for(int i = 1; i<= n;i++){
            if(distance[i] > max) {
                max = distance[i];
                count = 1;
            } else if(distance[i] == max) {
                count+=1;
            } else {
                continue;
            }
        }

        return count;
    }
    public void BFS(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(num);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            int tempDepth = distance[now];
            for(int temp: A[now]) {
                if(visited[temp]==false) {
                    if(distance[temp]>tempDepth+1) {
                        distance[temp] = tempDepth+1;
                        queue.offer(temp);
                    }
                }
            }
        }
    }
}