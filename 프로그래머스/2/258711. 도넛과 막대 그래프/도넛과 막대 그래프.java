import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int num, donutNum, stickNum, eightNum;
    static int node, edge, remember, M;
    static Set set = new HashSet<Integer>();
    
    public int[] solution(int[][] edges) {
        M = 0;
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            set.add(edges[i][1]);
            M = Math.max(Math.max(start, M), end);
        }
        // 가장 높은 수 만큼 그래프 선언
        A = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            A[i] = new ArrayList<>();
        }
        // 그래프에 값 입력
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            A[start].add(end);
        }
        // 정점 번호 구하기
        for (int i = 1; i <= M; i++) {
            if (A[i].size() >= 2 && !set.contains(i)) {
                num = i;
                break;
            }
        }

        // 정점과 연결된 특정 점 가져오기
        for (Integer temp : A[num]) {
            remember = temp;
            visited = new boolean[M+1];
            node = 0;
            edge = 0;
            visited[temp] = true;
            checkGraph(temp);
            if (edge == node) {
                donutNum += 1;
            } else if (edge == node - 1) {
                stickNum += 1;
            } else {
                eightNum += 1;
            }
        }
        int[] answer = {num,donutNum,stickNum,eightNum};
        return answer;
    }
    private static void checkGraph(int temp) {
        node += 1;
        for (Integer tmp : A[temp]) {
            edge += 1;
            if (!visited[tmp]) {
                visited[tmp] = true;
                checkGraph(tmp);
            }
        }
    }
}