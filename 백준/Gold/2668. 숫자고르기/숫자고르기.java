import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static ArrayList<Integer> answer;
    static int startNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            A[i].add(sc.nextInt());
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            startNum = i;
            dfs(i);
        }
        System.out.println(answer.size());
        for(int i : answer) {
            System.out.println(i);
        }
    }

    private static void dfs(int num) {
        visited[num]= true;
        for (int i : A[num]) {
            if (i == startNum) {
                answer.add(startNum);
                return;
            }
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
