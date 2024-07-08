import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Info {
        long place;
        long people;

        Info(long place, long people) {
            this.place = place;
            this.people = people;
        }
    }

    static Info[] info;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        info = new Info[N];
        long totalPopulation = 0;
        for (int i = 0; i < N; i++) {
            long tempPlace = sc.nextLong();
            long tempPopulation = sc.nextLong();
            info[i] = new Info(tempPlace, tempPopulation);
            totalPopulation += tempPopulation;
        }
        Arrays.sort(info, (o1, o2) -> {
            return (int) (o1.place - o2.place);
        });
        long median = (totalPopulation + 1) / 2;
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += info[i].people;
            if (median <= temp) {
                System.out.println(info[i].place);
                break;
            }
        }
    }
}
