import java.util.*;

public class Main {
    /*
    --문제 읽기
    알파벳 소문자 여러 개와 별표(*) 하나로 이루어진 문자열
    패턴과 파일이름이 모두 주어졌을때 각각의 파일이름이
     패턴과 일치하는지 아닌지를 구하는 프로그램

    파일의 개수 N <=100
    둘째줄 패턴 알파벳 소문자와 별표 한개로 아루어짐
    문자열의 길이는 100을 넘지 않으며, 별표는 문자열의 시작과 끝에 있지않음
    N개의 줄에는 파일이름이 주어짐 
    
    i번째 파일이름이 패턴과 일치하면 DA 아니면 NE를 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String pattern = sc.next();
        String[] S = pattern.split("\\*");
        for (int i = 0; i < N; i++) {
            String problem = sc.next();
            if (problem.length() < S[1].length()+S[0].length()) {
                System.out.println("NE");
                continue;
            }
            String substring1 = problem.substring(0, S[0].length());
            String substring2 = problem.substring(problem.length() - S[1].length(), problem.length());
            if (substring1.equals(S[0]) && substring2.equals(S[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
