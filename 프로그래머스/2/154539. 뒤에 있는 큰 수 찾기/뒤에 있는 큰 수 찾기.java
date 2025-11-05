import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        answer[len-1] = -1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(numbers[len-1]);
        for (int i = len-2; i >= 0; i--) {
            while(!stack.empty()) {
                int tmp = stack.pop();
                if(tmp > numbers[i]) {
                    answer[i] = tmp;
                    stack.push(tmp);
                    stack.push(numbers[i]);
                    break;
                }
            }
            if(stack.empty()) {
                answer[i] = -1;
                stack.push(numbers[i]);
            }
        }
        return answer;
    }
}