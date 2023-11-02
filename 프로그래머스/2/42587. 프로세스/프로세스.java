import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        int[] priority_arr = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int order = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            boolean higherPriorityExists = false;

            for (int i : queue) {
                if (priorities[i] > priorities[current]) {
                    higherPriorityExists = true;
                    break;
                }
            }

            if (higherPriorityExists) {
                queue.add(current);
            } else {
                priority_arr[current] = order;
                order++;
            }
        }

        return priority_arr[location];
    }
}
