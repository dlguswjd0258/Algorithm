/**
* 메모리: 292992 KB, 시간: 492 ms
* 2022.01.02
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int H, W;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getMaxDistance());
	}

	private static int getMaxDistance() {
		int dis = 0;

		boolean[][] visited = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'W' || visited[i][j]) {
					continue;
				}

				visited[i][j] = true;
				dis = Math.max(dis, getDistance(i, j));
			}
		}

		return dis;
	}

	private static int getDistance(int r, int c) {
		// 거리 구하기
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { r, c });
		
		boolean[][] visited = new boolean[H][W];
		visited[r][c] = true;

		int nr, nc, size, time = -1;
		while (!que.isEmpty()) {
			size = que.size();
			time++;
			while (size-- > 0) {
				r = que.peek()[0];
				c = que.poll()[1];
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];

					if (!isIn(nr, nc) || map[nr][nc] == 'W' || visited[nr][nc]) {
						continue;
					}

					que.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}

		return time;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = in.readLine().toCharArray();
		}
	}
}