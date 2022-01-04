/**
* 메모리: 14220 KB, 시간: 140 ms
* 2022.01.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M, T, map[][];

	public static void main(String[] args) throws Exception {
		input();

		int time = getMinTime();
		// T 시간내에 구출 할 수 없다면 fail
		if (time > T) {
			System.out.println("Fail");
		} else {
			System.out.println(time);
		}
	}

	private static int getMinTime() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0, 0 }); // r, c, 그람 소지 여부

		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;

		int r, c, nr, nc, gram, size, time = -1;
		while (!que.isEmpty() && time <= T) {
			size = que.size();
			time++;
			while (size-- > 0) {
				r = que.peek()[0];
				c = que.peek()[1];
				gram = que.poll()[2];

				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];

					if (!isIn(nr, nc) || visited[nr][nc][gram] || !canGo(nr, nc, gram)) {
						continue;
					}

					// 도착했는지 확인
					if (nr == N - 1 && nc == M - 1) {
						return time + 1;
					}

					visited[nr][nc][gram] = true;
					// 이동했을 때 검이 있는지 확인하고 소지 여부 체크
					que.offer(new int[] { nr, nc, map[nr][nc] == 2 ? 1 : gram });
				}
			}
		}

		return T + 1;
	}

	private static boolean canGo(int r, int c, int gram) {
		// 검이 있으면 벽이 있어도 갈 수 있고 없으면 벽일 때 갈 수 없다!
		return gram == 1 ? true : map[r][c] != 1;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}