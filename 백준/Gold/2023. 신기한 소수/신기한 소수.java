import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[]{2, 3, 5, 7};
        int[] candidate = {1, 3, 7, 9};
        answer = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            dfs(A[i], candidate, N);
        }
        for (int i = 0; i <answer.size() ; i++) {
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(int num, int[] candidate, int n) {
        if (!check(num)) {
            return;
        }
        if(n==1){
            answer.add(num);
            return;
        }
        num *= 10;
        for (int i = 0; i < candidate.length; i++) {
            dfs(num + candidate[i], candidate, n - 1);
        }
    }


    private static boolean check(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
