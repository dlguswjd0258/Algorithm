/**
* 메모리: 123468 KB, 시간: 336 ms
* 2022.01.10
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M, map[][], safe;
	static List<int[]> viruses = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getMaxSafeArea(0, 0, 0));
	}

	private static int getMaxSafeArea(int r, int c, int cnt) {
		if (cnt == 3) {
			// 초기 안전영역에 퍼진 바이러스 수 빼기
			return safe - countAddedViruses();
		}

		if (r == N) {
			return 0;
		}

		if (c == M) {
			return getMaxSafeArea(r + 1, 0, cnt);
		}

		int max = 0;
		// 벽 설치
		for (int i = r; i < N; i++) {
			int j = i == r? c : 0;
			for (; j < M; j++) {
				// 벽이 있거나 바이러스가 있는 곳은 벽을 놓을 수 없음
				if (map[i][j] != 0) {
					continue;
				}

				map[i][j] = 1;
				max = Math.max(max, getMaxSafeArea(i, j + 1, cnt + 1));
				map[i][j] = 0;
			}
		}

		return max;
	}

	private static int countAddedViruses() {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		// 초기 바이러스 위치 담기
		for (int[] virus : viruses) {
			que.offer(virus);
			visited[virus[0]][virus[1]] = true;
		}

		int r, c, nr, nc, added = 0;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.poll()[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				if (!canGo(nr, nc) || visited[nr][nc]) {
					continue;
				}

				added++;
				que.offer(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

		return added;
	}

	private static boolean canGo(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] == 0;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					viruses.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					safe++;
				}
			}
		}
		
		// 설치할 벽 수 빼기
		safe -= 3;
	}
}