import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strArr = new String[N + 1];
        int answerCount = 0;
        HashMap<Character, ArrayList<String>> hashMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strArr[i] = sc.next();
        }
        String S = strArr[0];
        String T = strArr[1];
        for (int i = N - 1; i >= 0; i--) {
            String str = strArr[i];
            if (!set.contains(str)) {
                set.add(str);
                if (hashMap.containsKey(str.charAt(0))) {
                    for (String temp : hashMap.get(str.charAt(0))) {
                        int count = 0;
                        if (temp.length() < str.length()) {
                            for (int j = 0; j < temp.length(); j++) {
                                if (temp.charAt(j) == str.charAt(j)) {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            for (int j = 0; j < str.length(); j++) {
                                if (temp.charAt(j) == str.charAt(j)) {
                                    count++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (count >= answerCount) {
                            answerCount = count;
                            S = temp;
                            T = str;
                        }
                    }
                    hashMap.get(str.charAt(0)).add(str);
                } else {
                    hashMap.put(str.charAt(0), new ArrayList<>());
                    hashMap.get(str.charAt(0)).add(str);
                }
            }
        }
        System.out.println(T);
        System.out.println(S);
    }
}
