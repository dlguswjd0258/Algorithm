/**
* 메모리: 42472 KB, 시간: 396 ms
* 2022.01.12
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		init();
		System.out.println(getMinCnt());
	}

	private static int getMinCnt() {
		// 0, 0에서 출발
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0, 0 });

        // 방문체크 겸 벽 뚫은 개수 저장
		int[][] res = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(res[i], -1);
		}
        res[0][0] = 0;
        
		int r, c, nr, nc, cnt;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.peek()[1];
			cnt = que.poll()[2];

			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				// 이미 뚫은 벽의 수를 구했고 구한 수가 현재 + 뚫어야하는 벽 수보다 크거나 같으면 pass -> 의미가 없기 때문에 
				if (!isIn(nr, nc) || (res[nr][nc] != -1 && res[nr][nc] <= cnt + map[nr][nc])) {
					continue;
				}

				// 현재 벽을 뚫은 개수에 뚫어야하는 벽있다면 1 아니라면 0 더하기
				res[nr][nc] = cnt + map[nr][nc];
				que.offer(new int[] { nr, nc, res[nr][nc] });
			}
		}

		return res[N - 1][M - 1];
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().chars().map(x -> x - '0').toArray();
		}
	}
}