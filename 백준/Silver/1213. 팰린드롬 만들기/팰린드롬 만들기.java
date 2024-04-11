import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> count = new HashMap<>();
        boolean impossible = false;
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String[] split = name.split("");
        Arrays.sort(split);
        for (int i = 0; i < split.length; i++) {
            if (count.containsKey(split[i])) {
                count.put(split[i], count.get(split[i]) + 1);
            } else {
                count.put(split[i], 1);
            }
        }
        ArrayList<String> tempKey = new ArrayList<>(count.keySet());
        Collections.sort(tempKey);
        ArrayList<String> answer = new ArrayList();
        for (String key : tempKey) {
            int num = count.get(key) / 2;
            for (int i = 0; i < num; i++) {
                answer.add(key);
            }
        }
        int tempSize = answer.size();

        Collections.reverse(tempKey);
        for (String key : tempKey) {
            int num = count.get(key) / 2;
            for (int i = 0; i < num; i++) {
                answer.add(key);
                count.put(key, count.get(key) - 2);
            }
        }
        int check = 0;
        for (String key : tempKey) {
            if (count.get(key) % 2 == 1) {
                answer.add(tempSize, key);
                check++;
            }
        }
        if (check > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for(String str : answer) {
                System.out.print(str);;
            }
        }
    }
}
