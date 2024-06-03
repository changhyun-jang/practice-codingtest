import java.util.*;
import java.io.*;
/*
  자주나오는 단어일수록 앞에 배치
  단어의 길이가 길수록 앞에 배치
  알파벳 사전 순으로 앞에 있는 단어일 수록 앞에 배치
  M보다 짧은 길이의 단어 경우 읽는 것만으로 외울 수 있음.
  M보다 길이 이상인 단어들만 외움
  
  
  단어들을 입력받는데 만약 단어의 길이가 M이상인 경우만 고려
 */
public class Main {
    static int N, M;
    static HashMap<String, Integer> word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        word = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if (temp.length() < M) continue;
            if (word.containsKey(temp)) {
                word.put(temp, word.get(temp) + 1);
            } else {
                word.put(temp, 1);
            }
        }
        ArrayList<String> answer = new ArrayList();
        for (String s : word.keySet()) {
            answer.add(s);
        }

        Collections.sort(answer, (o1, o2) -> {
            if (word.get(o1) != word.get(o2)) {
                return word.get(o2) - word.get(o1);
            } else {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : answer) {
            bw.append(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
