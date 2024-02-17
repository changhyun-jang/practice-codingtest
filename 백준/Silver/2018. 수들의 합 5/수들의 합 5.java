import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        long sum = 1;
        int num = sc.nextInt();
        while(end_index != num){
            if(sum == num) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum < num) {
                end_index++;
                sum += end_index;
            } else {
                sum -= start_index;
                start_index ++;
            }
        }
        System.out.println(count);
    }
}