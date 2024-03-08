import java.util.*;
import java.io.*;

public class Main {
    /*
    사람수 N, 이야기의 진실을 아는 사람 M.
    파티에 오는 사람마다 번호가 주어짐, 지민이는 모든 파티에 참가
    이때 지민이가 거짓말 쟁이로 알려지지 않으면서, 과장된 이야기를 할 수
    있는 파티의 개수의 최댓값
    
    진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들이 번호가 주어짐
    사람들의 번호는 1부터 N까지의 수
    N,M은 50이하 자연수
    진실을 아는 사람의 수는 0~50이상
    파티에오는 사람수도 1~50이상

    --sudo코드
    사람 수 N과 파티수 M입력
    int[] parent = int[N+1];
    for(N만큼) {
        i = i;
    }
    이야기의 진실을 아는 사람 수factNum
    if(factNum!=0) {
        int[] factPeople = int[facctNum+1];
        for(factNum) {
            들어오는 값들 유니온하여 parent의 값이 다 똑같게 만들기
        }
        for(M만큼) {
            partyNum 파티인원수 입력
            for(partyNum) {
                만약 들어오는 값이 factPeople이 있으면 union하기
                배열에 저장하기       
            }
            배열에서 하나하나 꺼내면서 확인하면서 count
            sout countc출력
        }
    }else {
       M 출력
    }
    
     */
    static int N, M, factNum, partyNum;
    static int[] parent;
    static int[] factPeople;
    static int[][] partyPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        partyPeople = new int[M][N];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        factNum = Integer.parseInt(st.nextToken());
        if (factNum != 0) {
            factPeople = new int[factNum];

            for (int i = 0; i < factNum; i++) {
                factPeople[i] = Integer.parseInt(st.nextToken());
                if (i > 0) {
                    union(factPeople[i-1], factPeople[i]);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            partyNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyNum; j++) {
                partyPeople[i][j] = Integer.parseInt(st.nextToken());
                if (j > 0) {
                    union(partyPeople[i][j-1], partyPeople[i][j]);
                }
            }
        }

        if(factNum==0) {
            System.out.println(M);
        } else {
            //거짓말쟁이가 안되는 파티는 몇개인가
            int count = 0;
            for (int i = 0; i < M; i++) {
                boolean tempcheck= true;
                for (int j = 0; j < N; j++) {
                    if(partyPeople[i][j]==0){
                        if(tempcheck == true) count++;
                        break;
                    }
                    tempcheck = check(factPeople[0],partyPeople[i][j]);
                }
            }
            System.out.println(count);
        }
    }

    private static boolean check(int checkA, int checkB) {
        checkA = find(checkA);
        checkB = find(checkB);
        if(checkA == checkB) {
            return false;
        } else {
            return true;
        }
    }

    private static void union(int A, int B) {
        A = find(A);
        B = find(B);
        if (A != B) {
            parent[B] = A;
        }
    }

    private static int find(int K) {
        if (parent[K] == K) {
            return K;
        } else {
            return parent[K] = find(parent[K]);
        }
    }
}
