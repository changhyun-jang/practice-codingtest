import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        -- 문제 분석 --
        더하기를 먼저 진행하고 빼기를 진행
         */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] splitMinus = str.split("-");
        int result = 0;
        for (int i = 0; i < splitMinus.length; i++) {
            int temp = splitplus(splitMinus[i]);
            if(i == 0 ){
                result += temp;
            }else {
                result -= temp;
            }
        }
        System.out.println(result);
    }

    private static int splitplus(String splitMinus) {
        int sum = 0;
        String[] temp = splitMinus.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;

    }

}
