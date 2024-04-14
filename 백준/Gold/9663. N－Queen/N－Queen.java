import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N + 1];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            board[cnt + 1] = i;
            if (checkPlace(cnt+1)) {
                dfs(cnt + 1);
            }
        }
    }

    private static boolean checkPlace(int row) {
        for (int i = 1; i < row; i++) {
            if (board[i] == board[row]) return false;
            else if (Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
}
