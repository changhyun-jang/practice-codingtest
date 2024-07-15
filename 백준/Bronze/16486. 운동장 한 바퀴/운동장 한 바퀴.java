import java.util.Scanner;

public class Main {
    static double PI = 3.141592;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        System.out.println(d1 * 2 + 2 * PI * d2);

    }
}
