package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1926_그림 {

	static int N, M, cnt, max;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; // 상하좌우
	static int[][] width;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		width = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().charAt(0) == '1') {
					map[i][j] = true;
				}
			}
		}

		// map을 탐색하면서 1의 위치에서 DFS로 넓이 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					// 그림 한개 찾음
					cnt++;
					// 그림의 넓이 구하고 max와 비교
					max = Math.max(max, getWidth(i, j, 1));
				}
			}
		}
		
		System.out.println(cnt + "\n" + max);

	}

	private static int getWidth(int r, int c, int w) {
		// 방문했다는 표시
		map[r][c] = false;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (!isIn(nr, nc) || !map[nr][nc])
				continue;
			w = getWidth(nr, nc, w + 1);
		}

		return w;
	}

	private static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		return false;
	}

}
