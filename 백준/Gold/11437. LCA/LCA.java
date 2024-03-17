import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int parent;
        int depth;

        Node(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    static int N, M;
    static ArrayList<Integer>[] A;
    static Node[] Arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        Arr = new Node[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        Arr[1] = new Node(0, 0);
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            A[P].add(C);
            A[C].add(P);
        }
        dfs(1);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> answer = new ArrayList();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            checkParent(num1, num2);
            int result = checkParent(num1, num2);
            answer.add(result);
        }
        for(int temp:answer){
            System.out.println(temp);
        }

    }

    private static int checkParent(int num1, int num2) {
        int temp1 = num1;
        int temp2 = num2;
        //depth 맞추기
        while (Arr[temp1].depth != Arr[temp2].depth) {
            int num1Depth = Arr[temp1].depth;
            int num2Depth = Arr[temp2].depth;
            if (num1Depth > num2Depth) {
                temp1 = Arr[temp1].parent;
            } else {
                temp2 = Arr[temp2].parent;
            }
        }
        if(temp1 == temp2){
            return temp1;
        }
        int num1Parent = Arr[temp1].parent;
        int num2Parent = Arr[temp2].parent;
        int result = 0;

        if (num1Parent == num2Parent) {
            result = num1Parent;
        } else {
            result = checkParent(num1Parent, num2Parent);
        }
        return result;
    }

    private static void dfs(int i) {
        Node nowNode = Arr[i];
        visited[i] = true;
        for (int temp : A[i]) {
            if (visited[temp] == false) {
                Arr[temp] = new Node(i, nowNode.depth + 1);
                dfs(temp);
                visited[temp] = false;
            }
        }
    }
}
