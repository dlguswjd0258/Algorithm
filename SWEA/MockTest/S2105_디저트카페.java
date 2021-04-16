package MockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 모의 2105 디저트 카페
public class S2105_디저트카페 {

	static int N, maxCnt, map[][], R, C;
	static int[] dr = { 1, 1, -1, -1 }, dc = { 1, -1, -1, 1 }; // 하우, 하좌, 상좌, 상우
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];

			// 맵 정보 입력 받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs로 갈 수 있는 경로 확인하면서 먹은 디저트 수 세기
			// 어느 방향으로 돌아도 경로는 같으므로 오른쪽 아래로 출발한다.
			maxCnt = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 0; j < N; j++) {
					// 출발지 지정
					R = i;
					C = j;
					getMaxCnt(R, C, 0, 1);
				}
			}

			sb.append(maxCnt != 0 ? maxCnt : -1).append("\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * 각 출발지에서 출발지로 도착했을 때 먹은 디저트수를 최대값으로 갱신한다.
	 * 
	 * @param r       현재 행 위치
	 * @param c       현재 열 위치
	 * @param cnt     먹은 디저트 수
	 * @param visited 먹은 디저트 체크
	 */
	private static void getMaxCnt(int r, int c, int dir, int cnt) {

		// 방문 체크
		visited[map[r][c]] = true;

		// 같은 방향으로 가거나 다음 방향으로 가기
		int nr, nc;
		for (int i = 0; i < 2; i++) {
			// 한바퀴 다 돌았다면 그만 하기
			if (dir == 3 && i == 1)
				break;

			nr = r + dr[dir + i];
			nc = c + dc[dir + i];

			if (nr == R && nc == C) {
				maxCnt = Math.max(maxCnt, cnt);
				continue;
			}

			// 맵 밖으로 나가거나 이미 선택된 디저트라면 pass
			if (!isIn(nr, nc) || visited[map[nr][nc]])
				continue;

			getMaxCnt(nr, nc, dir + i, cnt + 1);
		}

		// 다시 돌려놓기
		visited[map[r][c]] = false;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
