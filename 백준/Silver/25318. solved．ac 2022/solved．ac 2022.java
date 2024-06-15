import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static String[][] str;
    static int answer;
    static double sumP, sumPL;

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        str = new String[N][2];
        answer = 0;
        sumP = 0;
        sumPL = 0;
        if (N != 0) {
            for (int i = 0; i < N; i++) {
                String date = sc.next();
                String time = sc.next();
                String rank = sc.next();
                str[i][0] = date + " " + time;
                str[i][1] = rank;
            }
            Date parse = simpleDateFormat.parse(str[N - 1][0]);
            for (int i = 0; i < N; i++) {
                Date tempParse = simpleDateFormat.parse(str[i][0]);
                double T = ((double) parse.getTime() - tempParse.getTime()) / (double) 1000 / (double) (24 * 60 * 60*365);
                double P = Math.max(Math.pow(0.5, T), Math.pow(0.9, N - (i + 1)));
                sumP += P;
                sumPL += P * Integer.parseInt(str[i][1]);
            }
            double result = sumPL / sumP;
            answer = (int) Math.round(result);

        }
        System.out.println(answer);
    }
}
