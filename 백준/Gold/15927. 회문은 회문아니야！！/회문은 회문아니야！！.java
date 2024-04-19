import java.util.*;

public class Main {
    static String str;
    static String[] split;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        split = str.split("");
        if (check()) {
            System.out.println(-1);
        } else {
            if (checkPalindrome()) {
                System.out.println(split.length - 1);
            } else {
                System.out.println(split.length);
            }
        }
    }

    private static boolean checkPalindrome() {
        int left = 0;
        int right = 0;
        if (split.length % 2 == 1) {
            left = (split.length / 2) - 1;
            right = left + 2;
        } else {
            left = (split.length / 2) - 1;
            right = left + 1;
        }
        while (left >= 0) {
            if (!split[left].equals(split[right])) return false;
            left--;
            right++;
        }
        return true;
    }

    private static boolean check() {
        for (int i = 1; i < split.length; i++) {
            if (!split[0].equals(split[i])) return false;
        }
        return true;
    }
}
