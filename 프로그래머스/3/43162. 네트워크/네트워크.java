/*
    -- 문제읽기
    A-B, B-C, A-C도 간접연결, A-B-C 모두 같은 네트워크
    컴퓨터 n입력, 연결정보가 담긴 2차원 배열 매개변수
    네트워크의 개수를 return 하도록
    
    -- 문제 풀이
    DFS 사용하여 총 몇개의 네트워크가 있는지확인하기
    
    -- sudo코드
    visited 배열에 n+1 크기 입력
    dfs(0,0)
    
*/
class Solution {
    //방문 기록 배열 선언
    static boolean[] visited;
    //정답을 갖는 변수 선언
    static int answer;
    //computers저장 배열
    static int[][] temp;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n+1];
        temp = computers;
        answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i+1]) {
                dfs(i,n);
                answer ++;
            }
        }
        return answer;
    }
    
    public void dfs(int x, int n) {
        visited[x+1] = true;
        
        for(int j = 0; j < n; j++) {
            if(visited[j+1]==false && temp[x][j] == 1) {
                dfs(j,n);
            }
        }
    }
}