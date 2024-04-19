import java.util.*;

public class Main {
    static String S;
    static String T;
    static boolean answer;
    //    static ArrayList<String> checkDuplication = new ArrayList<>();
    static StringBuffer sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();
        answer = false;
        dfs(T, T.length());
        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(String s, int len) {
        if (len == S.length()) {
            if (check(s)) answer = true;
            return;
        }
        if (s.charAt(s.length() - 1) == 'A') {
            String tempA = minusA(s);
            dfs(tempA, tempA.length());
        }
        if (s.charAt(0) == 'B') {
            String tempB = minusB(s);
            dfs(tempB, tempB.length());
        }
    }


    private static boolean check(String s) {
        if (S.equals(s)) return true;
        return false;
    }

    private static String minusB(String s) {
        String temp = s.substring(1);
        sb = new StringBuffer(temp);
        String reverse = sb.reverse().toString();
        return reverse;
    }

    private static String minusA(String s) {
        String temp = s.substring(0, s.length() - 1);
        return temp;
    }
}
