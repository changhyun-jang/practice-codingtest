import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문자열을 K기준으로 자르면 최대,
         아니면 K는 한글자씩, M은 연속되면 계속 최소
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String max = "";
        String min = "";
        // 최댓값 구하기
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'K') {
                max += "5";
                for (int j = 0; j < temp.length(); j++) {
                    max += "0";
                }
                temp = "";
            } else if (i == str.length() - 1) {
                max += 1;
                for (int j = 0; j < temp.length(); j++) {
                    max += "1";
                }
                temp = "";
            } else {
                temp += String.valueOf(str.charAt(i));
            }
        }

        // 최댓값 구하기
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'K') {
                if (temp.length() >= 1) {
                    min += "1";
                    for (int j = 0; j < temp.length()-1; j++) {
                        min += "0";
                    }
                }
                min += "5";
                temp = "";
            } else if (i == str.length() - 1) {
                min += "1";
                for (int j = 0; j < temp.length(); j++) {
                    min += "0";
                }
            } else {
                temp += String.valueOf(str.charAt(i));
            }
        }
        System.out.println(max);
        System.out.println(min);

    }
}
