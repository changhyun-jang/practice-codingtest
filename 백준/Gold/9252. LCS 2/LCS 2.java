import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        str2 = sc.next();
        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        for (int i = 1; i <= str1.length(); i++) {
//            for (int j = 1; j <= str2.length(); j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        if (dp[str1.length()][str2.length()] == 0) {
            System.out.println(dp[str1.length()][str2.length()]);
        } else {
            System.out.println(dp[str1.length()][str2.length()]);
            getStr();
        }
    }

    private static void getStr() {
        Stack<String> stack = new Stack<>();
        int temp = dp[str1.length()][str2.length()];
        int col = str1.length();
        int row = str2.length();
        while (col >= 1 && row >= 1) {
            if (temp == dp[col - 1][row]) {
                col -= 1;
            } else if (temp == dp[col][row - 1]) {
                row -= 1;
            } else {
                stack.add(String.valueOf(str2.charAt(row - 1)));
                row -= 1;
                temp = dp[col][row];
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}