import java.util.*;
import java.io.*;

public class Main {
    static int N, M, answer;
    static int[] crain;
    static ArrayList<Integer> box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 크레인 갯수 입력
        N = Integer.parseInt(st.nextToken());
        // 크레인 제한무게 배열 선언
        crain = new int[N];
        st = new StringTokenizer(br.readLine());
        //크레인 제한무게 입력
        for (int i = 0; i < N; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        // 박스 갯수 입력
        M = Integer.parseInt(st.nextToken());
        // 박스 무게 저장 리스트 선언
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        // 박스 무게 입력
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(crain);
        Collections.sort(box);
        //모든 박스를 못옮기는 경우
        answer = 0;
        if (crain[crain.length - 1] < box.get(box.size() - 1)) System.out.println(-1);
            // 옮길 수 있는 경우
        else {
            while (!box.isEmpty()) {
                answer++;
                for (int i = crain.length-1; i > -1 ; i--) {
                    if(box.isEmpty()) break;
                    if (crain[i] < box.get(0)) break;
                    for (int j = box.size() - 1; j > -1; j--) {
                        if (crain[i] >= box.get(j)) {
                            box.remove(j);
                            break;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
