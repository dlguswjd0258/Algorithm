package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2638_치즈 {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M, cnt;
	static int[][] air;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵 정보 받기
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				if ("1".equals(st.nextToken())) {
					map[i][j] = true;
					cnt++;
				}
			}
		}

		int time = 0;
		while (cnt > 0) {
			time++;

			// 치즈에 닿는 공기 개수 세기
			countAir();

			// 치즈 녹이기
			removeCheese();
		}
		
		System.out.println(time);
	}

	private static void countAir() {
		air = new int[N][M];
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0 }); // 가장자리에서 시작

		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		int r, c, nr, nc;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				if(!isIn(nr,nc) || visited[nr][nc])
					continue;
				
				if(map[nr][nc]) {
					air[nr][nc]++;
					continue;
				}
				
				visited[nr][nc] = true;
				que.offer(new int[] {nr, nc});
			}
		}
	}

	private static void removeCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (air[i][j] < 2)
					continue;

				cnt--;
				map[i][j] = false;
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >=0 && c < M;
	}
}
