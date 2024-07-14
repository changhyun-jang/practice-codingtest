import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    -- 문제 분석하기
    상하좌우 선택할 수 있는 상황에서 5번 이동해서 만들 수 있는 가장 큰 블록의 값
    4의 5승 이므로 2의 10승 즉, 1024개의 경우의 수가 존재한다.
    1초에 메모리 제한 512이므로 Queue에 넣어서 해보면 가능할 수 도 있을것 같음.
     */
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulate(arr, 0);
        System.out.println(answer);
    }

    private static void simulate(int[][] arr, int time) {
        if (time == 5) {
            checkMaxValue(arr);
            return;
        }
        int[][] temp = new int[N][N];
        // 오른쪽으로 모두 밀착하기
        for (int i = 0; i < N; i++) {
            int tempValue = -1, nextIdx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (arr[i][j] == tempValue) {
                    temp[i][nextIdx--] = tempValue + arr[i][j];
                    tempValue = -1;
                } else {
                    if (tempValue != -1) {
                        temp[i][nextIdx--] = tempValue;
                    }
                    tempValue = arr[i][j];
                }
            }
            if (tempValue != -1) {
                temp[i][nextIdx--] = tempValue;
            }
        }
        simulate(temp, time + 1);

        temp = new int[N][N];
        // 왼쪽으로 모두 밀착하기
        for (int i = 0; i < N; i++) {
            int tempValue = -1, nextIdx = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (arr[i][j] == tempValue) {
                    temp[i][nextIdx++] = tempValue + arr[i][j];
                    tempValue = -1;
                } else {
                    if (tempValue != -1) {
                        temp[i][nextIdx++] = tempValue;
                    }
                    tempValue = arr[i][j];
                }
            }
            if (tempValue != -1) {
                temp[i][nextIdx++] = tempValue;
            }
        }
        simulate(temp, time + 1);

        temp = new int[N][N];
        // 아래로 모두 밀착하기
        for (int i = 0; i < N; i++) {
            int tempValue = -1, nextIdx = N-1;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j][i] == 0) {
                    continue;
                }
                if (arr[j][i] == tempValue) {
                    temp[nextIdx--][i] = tempValue + arr[j][i];
                    tempValue = -1;
                } else {
                    if (tempValue != -1) {
                        temp[nextIdx--][i] = tempValue;
                    }
                    tempValue = arr[j][i];
                }
            }
            if (tempValue != -1) {
                temp[nextIdx--][i] = tempValue;
            }
        }
        simulate(temp, time + 1);

        temp = new int[N][N];
        // 위로 모두 밀착하기
        for (int i = 0; i < N; i++) {
            int tempValue = -1, nextIdx = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
                if (arr[j][i] == tempValue) {
                    temp[nextIdx++][i] = tempValue + arr[j][i];
                    tempValue = -1;
                } else {
                    if (tempValue != -1) {
                        temp[nextIdx++][i] = tempValue;
                    }
                    tempValue = arr[j][i];
                }
            }
            if (tempValue != -1) {
                temp[nextIdx++][i] = tempValue;
            }
        }
        simulate(temp, time + 1);
    }

    private static void checkMaxValue(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, arr[i][j]);
            }
        }
    }
}
