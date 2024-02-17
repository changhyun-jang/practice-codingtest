import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Arr = new int[N];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] > max) max = Arr[i];
            sum = sum + Arr[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}