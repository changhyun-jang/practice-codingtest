import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        Stack<String> subStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            stack.add(String.valueOf(str.charAt(i)));
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if (temp.equals("L") && !stack.isEmpty()) {
                subStack.add(stack.pop());
            } else if (temp.equals("D") && !subStack.isEmpty()) {
                stack.add(subStack.pop());
            } else if (temp.equals("B") && !stack.isEmpty()) {
                stack.pop();
            } else if(temp.equals("P")){
                String s = st.nextToken();
                stack.add(s);
            }
        }
        while (!subStack.isEmpty()){
            stack.add(subStack.pop());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : stack) {
            bw.append(s);
        }
        bw.flush();
        bw.close();
    }
}
