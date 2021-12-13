/**
* 메모리: 13996 KB, 시간: 116 ms
* 2021.12.13
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static int T, N, M, K, cabbage[][];
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean map[][];
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			init();

			sb.append(getCnt()).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int getCnt() {
		int cnt = 0;

		boolean[][] visited = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			if (visited[cabbage[i][0]][cabbage[i][1]])
				continue;

			cnt++;
			// 주변 1 방문 체크하기
			checkAroundCabbage(cabbage[i][0], cabbage[i][1], visited);

		}

		return cnt;
	}

	private static void checkAroundCabbage(int a, int b, boolean[][] visited) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { a, b });
		visited[a][b] = true;

		int r, c, nr, nc;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.poll()[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				if (!isIn(nr, nc) || !map[nr][nc] || visited[nr][nc]) {
					continue;
				}

				visited[nr][nc] = true;
				que.offer(new int[] { nr, nc });
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}

	private static void init() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		K = Integer.parseInt(st.nextToken()); // 배추의 위치의 개수

		cabbage = new int[K][2];
		map = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			cabbage[i][0] = Integer.parseInt(st.nextToken());
			cabbage[i][1] = Integer.parseInt(st.nextToken());

			map[cabbage[i][0]][cabbage[i][1]] = true;
		}

	}
}