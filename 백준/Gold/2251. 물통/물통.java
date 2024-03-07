import java.util.*;
import java.io.*;

public class Main {
    /*
    -- 문제읽기
    부피가 A,B,C
    항상 처음에 앞의 두 물통은 비어 있고, 세 번째 물통은 가득 차 있음
    물을 부을 수 있는데 이때 다른 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지
    물을 부을 수 있음.

    이때 첫번째 물통이 비어있을때, 세 번째 무롱의 용량에 담겨 있을 수 있는 물의 양을 구하시오.

    -- 문제풀이
    일어날 수 있는 경우의 수는
    A -> C
    A -> B
    B -> C
    B -> A
    C -> A
    C -> B

    8 9 10

    처음
    0 0 10

    C->A
    8 0 2

    C->B
    0 9 1

    C->A, C->B, A->C
    0 2 8

    C->B, B->A, A->C
    0 1 9

    각 경우의 수를 돌면서 바뀌는 A가 비어있을때의 C의 값들을 저장하면 되지 않을까.
    -- sudo코드
    A,B,C의 값이 주어짐
    크기가 3인 배열 선언

     */
    static int A, B, C;
    static int[] result;
    static boolean[][][] visited;
    static ArrayList<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        result = new int[]{0, 0, C};
        visited = new boolean[A+1][B+1][C+1];
        answer = new ArrayList<>();

        BFS(result[0],result[1],result[2]);

        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static void BFS(int a, int b, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,b,c});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(visited[now[0]][now[1]][now[2]]) {
                continue;
            }
            visited[now[0]][now[1]][now[2]] = true;

            if(now[0] == 0) answer.add(now[2]);

            //C->A
            if(now[0]+now[2]<=A) {
                queue.add(new int[]{now[0]+now[2],now[1],0});
            }else {
                queue.add(new int[]{A,now[1],now[0]+now[2]-A});
            }

            //C->B
            if(now[1]+now[2]<=B) {
                queue.add(new int[]{now[0],now[1]+now[2],0});
            }else {
                queue.add(new int[]{now[0],B,now[1]+now[2]-B});
            }

            //B->A
            if(now[0]+now[1]<=A) {
                queue.add(new int[]{now[0]+now[1],0,now[2]});
            }else {
                queue.add(new int[]{A,now[0]+now[1]-A,now[2]});
            }
            //B->C
            if(now[2]+now[1]<=C) {
                queue.add(new int[]{now[0],0,now[2]+now[1]});
            }else {
                queue.add(new int[]{now[0],now[2]+now[1]-C,C});
            }

            //A->B
            if(now[0]+now[1]<=B) {
                queue.add(new int[]{0,now[0]+now[1],now[2]});
            }else {
                queue.add(new int[]{now[0]+now[1]-B,B,now[2]});
            }
            //A->C
            if(now[0]+now[2]<=C) {
                queue.add(new int[]{0,now[1],now[0]+now[2]});
            }else {
                queue.add(new int[]{now[0]+now[2]-C,now[1],C});
            }
        }
    }
}
