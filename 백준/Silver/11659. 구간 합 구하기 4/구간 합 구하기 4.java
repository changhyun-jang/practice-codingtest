import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int sumCount = scanner.nextInt();
        int[] arr = new int[count];
        int[] sumArr = new int[count+1];
        sumArr[0]=0;
        for (int i = 0; i < count ; i++) {
            arr[i] = scanner.nextInt();
            sumArr[i+1] = sumArr[i] + arr[i];
        }
        for (int i = 0; i < sumCount ; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            System.out.println(sumArr[end] - sumArr[start-1]);
        }
    }
}