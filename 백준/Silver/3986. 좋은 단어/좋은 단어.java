import java.util.*;

public class Main {
    /*
    --문제읽기
    같은글자끼리 쌍을 짓기로 함
    선끼리 교차하지 않으면서 각 글자를 정확히 한개의 다른 위치에 있는 
    같은 글자와 짝지을 수 있으면 좋은 단어다
    --문제풀이
    문자열을 쪼갠뒤

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.next();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            String[] split = A[i].split("");
            Stack<String> stack = new Stack<>();
            stack.add(split[0]);
            for (int j = 1; j < split.length; j++) {
                if(stack.isEmpty()) stack.add(split[j]);
                else{
                    if(split[j].equals(stack.peek())){
                        stack.pop();
                    }else {
                        stack.add(split[j]);
                    }
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
