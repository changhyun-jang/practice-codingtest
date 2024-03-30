import java.util.*;
import java.io.*;

public class Main {
    /*
    -- 문제 읽기
    모든 암호를 깨는 방법을 발견
    빈도를 조사하는 것
    숫자 N개로 이루어진 메시지를 획득
    숫자는 모두 C보다 작거나 같음
    등장하는 빈도순대로 정렬

    수열의 두수X와 Y가 있을떄, X가 Y보다 수열에서 많이 등장한 경우
    X가 Y보다 앞에 있어야한다.
    등장하는 횟수가 같다며, 먼저 나온 것이 앞에 있어야함
    
    빈도정렬하는 프로그램을 만드시오

     */
    static int N, C;

    static class CountInfo {
        int count;
        int order;

        CountInfo(int count, int order) {
            this.count = count;
            this.order = order;
        }
    }

    static HashMap<Long, CountInfo> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count = new HashMap<>();
        int order = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(st.nextToken());
            if (count.containsKey(temp)) {
                CountInfo countInfo = count.get(temp);
                count.put(temp, new CountInfo(countInfo.count + 1, countInfo.order));
            } else {
                count.put(temp, new CountInfo(1, order));
                order++;
            }
        }
        List<Long> keySet = new ArrayList<>(count.keySet());

        keySet.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (count.get(o1).count == count.get(o2).count) {
                    return count.get(o1).order - count.get(o2).order;
                } else {
                    return count.get(o2).count - count.get(o1).count;
                }
            }
        });

        for (long key : keySet) {
            for (int i = 0; i < count.get(key).count; i++) {
                System.out.print(key+ " ");
            }
        }
    }
}
