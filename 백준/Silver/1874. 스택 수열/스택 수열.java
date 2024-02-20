import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //수열안 숫자 개수
        int N = sc.nextInt();
        //수들을 저장할 배열
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int value = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();
        boolean check = true;

        for (int i = 0; i < N; i++) {
            if (value <= A[i]) {
                while (value <= A[i]) {
                    stack.push(value++);
                    buffer.append("+\n");
                }
                stack.pop();
                buffer.append("-\n");
            } else {
                int n = stack.pop();
                if(n > A[i]) {
                    System.out.println("NO");
                    check = false;
                    break;
                }
                else{
                    buffer.append("-\n");
                }
            }
        }
        if(check) System.out.println(buffer);
    }
}
