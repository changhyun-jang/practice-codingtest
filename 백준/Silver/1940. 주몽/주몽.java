import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ingredientCount = sc.nextInt();
        int armorSum = sc.nextInt();
        int[] Arr = new int[ingredientCount];

        for (int i = 0; i < ingredientCount; i++) {
            Arr[i] = sc.nextInt();
        }
        Arrays.sort(Arr);
        int start_index = 0;
        int end_index = ingredientCount - 1;
        int sum = Arr[start_index] + Arr[end_index];
        int count = 0;

        while (start_index < end_index) {
            if (sum == armorSum) {
                count++;
                sum -= Arr[start_index];
                start_index++;
                sum += Arr[start_index];
            } else if (sum < armorSum) {
                sum -= Arr[start_index];
                start_index++;
                sum += Arr[start_index];
            } else {
                sum -= Arr[end_index];
                end_index--;
                sum += Arr[end_index];
            }
        }
        System.out.println(count);
    }
}
