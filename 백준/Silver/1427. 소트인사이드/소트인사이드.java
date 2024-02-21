import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] A = N.toCharArray();
        for (int i = 0; i < A.length; i++) {
            int max = i;
            for (int j = i+1; j < A.length; j++) {
                if(A[max]-48 < A[j]-48) {
                    max = j;
                }
            }
            char temp = A[i];
            A[i] = A[max];
            A[max] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "");
        }
    }
}