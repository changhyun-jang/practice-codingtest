import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pipe {
		int x;
		int y;
		int type;

		Pipe(int y, int x, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static Queue<Pipe> queue = new LinkedList<>();
	static int N, answer;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (map[N - 1][N - 1] != 1) {
			queue.add(new Pipe(0, 1, 1));
			while (!queue.isEmpty()) {
				Pipe poll = queue.poll();
				int x = poll.x;
				int y = poll.y;
				if (x == N - 1 && y == N - 1) {
					answer++;
					continue;
				}
				int type = poll.type;
				checkType(x, y, type);
			}
		}

		System.out.println(answer);

	}

	private static void checkType(final int x, final int y, final int type) {
		if (type == 1) {
			checkAvailable(x, y, 1);
			checkAvailable(x, y, 3);
		} else if (type == 2) {
			checkAvailable(x, y, 2);
			checkAvailable(x, y, 3);
		} else {
			checkAvailable(x, y, 1);
			checkAvailable(x, y, 2);
			checkAvailable(x, y, 3);
		}
	}

	private static void checkAvailable(final int x, final int y, final int num) {
		if (num == 1) {
			if (x + 1 < N && y < N && map[y][x + 1] != 1) {
				queue.add(new Pipe(y, x + 1, 1));
			}
		} else if (num == 2) {
			if (x < N && y + 1 < N && map[y + 1][x] != 1) {
				queue.add(new Pipe(y + 1, x, 2));
			}
		} else {
			if (x + 1 < N && y + 1 < N && map[y + 1][x + 1] != 1 && map[y + 1][x] != 1 && map[y][x + 1] != 1) {
				queue.add(new Pipe(y + 1, x + 1, 3));
			}
		}
	}

}
