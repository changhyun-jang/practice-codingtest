import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str = sc.next();
            int num = sc.nextInt();
            if (num != 1) {
                HashMap<String, ArrayList<Integer>> count = new HashMap<>();
                int maxLength = 0;
                int minLength = Integer.MAX_VALUE;
                String[] split = str.split("");
                for (int j = 0; j < str.length(); j++) {
                    if (!count.containsKey(split[j])) {
                        ArrayList<Integer> temp = new ArrayList();
                        temp.add(j);
                        count.put(split[j], temp);
                    } else {
                        ArrayList<Integer> temp = count.get(split[j]);
                        temp.add(j);
                        count.put(split[j], temp);
                    }
                }

                for (String temp : count.keySet()) {
//                    System.out.println();
//                    System.out.print( temp + " : " + count.get(temp));
                    if (count.get(temp).size() < num) continue;
                    for (int j = 0; j + num <= count.get(temp).size(); j++) {
                        int nm = count.get(temp).get(j + num - 1) - count.get(temp).get(j) + 1;
                        if (maxLength < nm) maxLength = nm;
                        if (minLength > nm) minLength = nm;
                    }
                }
                if (maxLength == 0 && minLength == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(minLength + " " + maxLength);
                }
            } else {
                System.out.println(1 + " " + 1);
            }
        }
    }

}
