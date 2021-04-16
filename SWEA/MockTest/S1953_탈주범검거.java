package MockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 탈주점 검거
public class S1953_탈주범검거 {

	static int N, M, R, C, L;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 }; // 0:상, 1:좌 , 2:하, 3:우

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];

			// 터널 구조 세팅
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			sb.append(getCnt()).append("\n");
		}

		System.out.println(sb.toString());
	}


	// Queue를 이용해 L시간 동안 갈 수 있는 위치 수 세기
	private static int getCnt() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { R, C, map[R][C] });
		map[R][C] = 0; // 방문체크

		// 맨홀에 들어갔으니까 시간은 1부터
		int r, c, nr, nc, dir, size, time = 1, cnt = 1; // 맨홀뚜겅이 있는 지점 포함
		while (time < L && !que.isEmpty()) {
			size = que.size();
			time++;
			while (size-- > 0) {
				r = que.peek()[0];
				c = que.peek()[1];
				dir = que.poll()[2];

				for (int i = 0; i < 4; i++) {
					// 터널구조상 갈 수 없는 방향이라면 다음 방향 확인
					if (!canGo(i, dir))
						continue;
					nr = r + dr[i];
					nc = c + dc[i];

					// 맵 밖이거나
					// 갈 수 있는 방향에 터널이 없거나 갈 수 있는 방향의 터널 구조가 맞지 않을 때 pass
					if (!isIn(nr, nc) || map[nr][nc] == 0 || !canGo((i + 2) % 4, map[nr][nc]))
						continue;

					que.offer(new int[] { nr, nc, map[nr][nc] });
					map[nr][nc] = 0;
					cnt++;
				}
			}
		}

		return cnt;
	}

	/**
	 * 터널 구조가 가려고 하는 방향으로 갈 수 있는지 여부
	 * @param dir 가려는 방향
	 * @param struc 터널 구조
	 * @return
	 */
	private static boolean canGo(int dir, int struc) {
		switch (struc) {
		case 1:
			return true; // 어느 방향이든 갈 수 있다.
		case 2: // 상 하
			return dir % 2 == 0;
		case 3: // 좌 우
			return dir % 2 != 0;
		case 4: // 상 우
			return dir == 0 || dir == 3;
		case 5: // 하 우
			return dir == 2 || dir == 3;
		case 6: // 하 좌
			return dir == 1 || dir == 2;
		default: // 상 좌
			return dir == 0 || dir == 1;
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
