import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static String S;
    static ArrayList<String> A;
    static String[] temp;
    static String[] temp2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        S = sc.next();
        A = new ArrayList<>();
        String[] split = S.split("");

        temp = new String[S.length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = split[i];
        }
        temp2 = new String[S.length()];
        A.add(S);
        if (S.length() % 2 == 0) {
            while (true) {
                for (int i = 0; i < split.length / 2; i++) {
                    temp2[i * 2] = temp[i];
                }
                int k = 1;
                for (int i = split.length - 1; i >= split.length / 2; i--) {
                    temp2[k] = temp[i];
                    k += 2;
                }
                String str = String.join("", temp2);
                if (A.contains(str)) break;
                else A.add(str);
                for (int i = 0; i < temp2.length; i++) {
                    temp[i] = temp2[i];
                }
            }
        } else {
            while (true) {
                for (int i = 0; i <= split.length / 2; i++) {
                    temp2[i * 2] = temp[i];
                }
                int k = 1;
                for (int i = split.length - 1; i > split.length / 2; i--) {
                    temp2[k] = temp[i];
                    k += 2;
                }
                String str = String.join("", temp2);
                if (A.contains(str)) break;
                else A.add(str);
                for (int i = 0; i < temp2.length; i++) {
                    temp[i] = temp2[i];
                }
            }
        }
        long k = N % A.size();
        String[] T = new String[A.size()];
        for (int i = 0; i < A.size(); i++) {
            T[(i + (int) k) % A.size()] = A.get(i);
        }
        System.out.println(T[0]);
    }
}
