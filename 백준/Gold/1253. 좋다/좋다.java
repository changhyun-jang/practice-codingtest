import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		answer = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while (left < right) {
				if (left == i){
					left++;
					continue;
				}else if (right == i){
					right--;
					continue;
				}
				if (arr[left] + arr[right] == arr[i]) {
					answer++;
					break;
				} else if (arr[left] + arr[right] > arr[i])
					right--;
				else
					left++;
			}
		}
		System.out.println(answer);

	}
}
