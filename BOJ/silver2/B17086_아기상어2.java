package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs로
public class B17086_아기상어2 {

	static int N, M;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }, dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵 정보 받기
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		System.out.println(getMaxSafeDist());
	}

	private static int getMaxSafeDist() {
		int r, c, nr, nc, size, cnt = -1;
		while (!que.isEmpty()) {
			size = que.size();
			cnt++;
			
			while(size-- > 0) {
				r = que.peek()[0];
				c = que.poll()[1];
				
				for (int i = 0; i < 8; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					
					if(!isIn(nr,nc) || visited[nr][nc])
						continue;
					
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});
				}
			}
		}

		return cnt;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
