import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<BigDecimal> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String s = str.replaceAll("[a-z]", " ");
            s = s.replaceAll("\\s+", " ");
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j++) {
                if(split[j].equals("")) continue;
                arr.add(new BigDecimal(split[j]));
            }
        }
        Collections.sort(arr);
        for (BigDecimal temp : arr) {
            System.out.println(temp);
        }
    }
}
