import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static HashMap<String, Integer> clothe;
    static ArrayList<String> keyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            answer = 1;
            clothe = new HashMap<>();
            int C = Integer.parseInt(st.nextToken());
            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                if (clothe.containsKey(kind)) {
                    clothe.put(kind, clothe.get(kind) + 1);
                } else {
                    clothe.put(kind, 1);
                }
            }
            keyArr = new ArrayList();
            for (String str : clothe.keySet()) {
                keyArr.add(str);
            }
            for (String str : keyArr) {
                answer *= (clothe.get(str) + 1);
            }
            System.out.println(answer - 1);
        }

    }
}
