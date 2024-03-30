import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 666;
        while (true) {
            String temp = Integer.toString(i);
            if (temp.contains("666")) {
                arr.add(i);
            }
            if (arr.size() == N) break;
            i++;
        }
        Collections.sort(arr);
        System.out.println(arr.get(N - 1));
    }
}
