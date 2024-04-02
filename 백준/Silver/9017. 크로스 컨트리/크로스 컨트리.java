import java.util.*;

public class Main {
    /*
    -- 문제풀이
    하나씩 입력받으면서 등수와 해당 팀이 몇명인지도 체크해야되고, 5번째 친구의 등수도 알아야됨.
     */
    static int T;
    // 등수 입력 받을 배열;
    static int[] P;
    //몇명인지 체크할 배열
    static int[] count;
    //다섯번째 친구를 저장할 배열
    static int[] fifth;
    //점수를 구할 배열
    static int[] result;
    //점수 구할때 4번쨰 까지만 더해야하는걸 체크하는 배열
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //테스트 케이스 갯수 입력 받기
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            // 몇명인지 입력받기
            int pNum = sc.nextInt();
            //사람들을 저장할배열
            P = new int[pNum];
            //팀이 총 몇개인지 구하는 변수
            int teamNum = 0;
            // 사람들 정보 입력받기
            for (int j = 0; j < pNum; j++) {
                P[j] = sc.nextInt();
                if (teamNum < P[j]) teamNum = P[j];
            }
            //배열 초기화
            count = new int[teamNum + 1];
            fifth = new int[teamNum + 1];
            result = new int[teamNum + 1];
            check = new int[teamNum + 1];

            //count 배열에 각팀 인원이 몇명인지 저장하기
            for (int j = 0; j < pNum; j++) {
                count[P[j]] += 1;
            }
            //점수 
            int score = 1;
            
            for (int j = 0; j < P.length; j++) {
                //몇명의 점수를 계산했는지 확인
                check[P[j]] += 1;
                //전체 인원이 6명이 아니면 계산하지 않음
                if (count[P[j]] != 6) {
                    result[P[j]] = Integer.MAX_VALUE;
                    continue;
                }
                // 4명을 초과한경우 그냥 score ++ 만 진행 5번째 친구의 점수 넣기
                if (check[P[j]] > 4) {
                    if (check[P[j]] == 5) fifth[P[j]] = score;
                    score++;
                    continue;
                }
                result[P[j]] += score;
                score++;
            }
            //우승팀 점수
            int winner = Integer.MAX_VALUE;
            //우승팀 번호
            int team = 0;
            for (int j = 1; j < result.length; j++) {
                if (result[j] < winner) {
                    winner = result[j];
                    team = j;
                } else if (result[j] == winner) {
                    if (fifth[team] > fifth[j]) team = j;
                }
            }

            System.out.println(team);
        }
    }
}
