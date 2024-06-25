import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, start, end, answer;

	static class Belt {
		int durability;
		boolean isRobot;

		Belt(int durability, boolean isRobot) {
			this.durability = durability;
			this.isRobot = isRobot;
		}
	}

	//컨베이어벨트 데크
	static Belt[] belt;
	static int count = 0;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new Belt[2 * N];
		answer = 1;
		start = 0;
		end = N - 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int tempDurability = Integer.parseInt(st.nextToken());
			belt[i] = new Belt(tempDurability, false);
			if (tempDurability == 0) {
				count++;
			}
		}
		if(count<K){
			while (count < K) {
				// 한칸씩 회전
				start = start == 0 ? (2 * N) - 1 : start - 1;
				end = end == 0 ? (2 * N) - 1 : end - 1;

				// 내리는곳에 위치한 로봇 내리기
				belt[end].isRobot = false;

				// 가장 먼저 벨트에 올라간 로봇 부터 이동, 이동할 수 없다면 가만히 있는다.
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int place = queue.poll();
					if (place == end) {
						//내리는 곳에 위치한 로봇이라면 넘어가기
						continue;
					}
					int nextPlace = place == (2 * N) - 1 ? 0 : place + 1;

					if (!belt[nextPlace].isRobot && belt[nextPlace].durability != 0) {
						// 기존에 있던칸 로봇 제거
						belt[place].isRobot = false;
						// +1 결과가 내리는곳이면 바로내리기
						if (nextPlace == end) {
							belt[nextPlace].durability--;
							if (belt[nextPlace].durability == 0)
								count++;
							continue;
						}
						// 아니면 다음칸 내구도 1감소
						belt[nextPlace].durability--;
						if (belt[nextPlace].durability == 0)
							count++;
						// 다음칸에 로봇 생성
						belt[nextPlace].isRobot = true;
						// 큐에 다음칸으로 옮긴채 넣기
						queue.offer(nextPlace);
					} else {
						queue.offer(place);
					}

				}

				//로봇 올리기
				if (!belt[start].isRobot && belt[start].durability != 0) {
					queue.add(start);
					belt[start].isRobot = true;
					belt[start].durability--;
					if (belt[start].durability == 0)
						count++;
				}
				answer++;
			}
			System.out.println(answer-1);
		}else{
			System.out.println(answer);
		}


	}
}
