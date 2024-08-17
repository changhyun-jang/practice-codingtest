import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;

    static class Schedule {
        double arrive;
        double leave;

        Schedule(double arrive, double leave) {
            this.arrive = arrive;
            this.leave = leave;
        }
    }

    static PriorityQueue<Double> queue = new PriorityQueue();
    static Schedule[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new Schedule[N];
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] arriveTime = st.nextToken().split(":");
            double arriveNum = convertNumber(arriveTime);
            String[] leaveTime = st.nextToken().split(":");
            double leaveNum = convertNumber(leaveTime);
            table[i] = new Schedule(arriveNum, leaveNum);
        }

        Arrays.sort(table, (o1, o2) -> {
            if (o1.arrive < o2.arrive) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < N; i++) {
            queue.add(table[i].leave);
            while (true) {
                double temp = queue.poll();
                if (temp > table[i].arrive) {
                    queue.add(temp);
                    break;
                }
            }
            answer = Math.max(answer, queue.size());
        }
        System.out.println(answer);
    }

    private static double convertNumber(String[] time) {
        double total = 0;
        total += (Double.parseDouble(time[0]) * 60 * 60);
        total += (Double.parseDouble(time[1]) * 60);
        total += Double.parseDouble(time[2]);
        return total;
    }
}

