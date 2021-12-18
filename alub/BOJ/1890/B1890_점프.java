/**
* 메모리: 11812 KB, 시간: 80 ms
* 2021.12.18
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 0, 1 }, dc = { 1, 0 }; // 우 하
	static int N, map[][];
	static long cnt[][];

	public static void main(String[] args) throws Exception {
		// 입력 받기
		input();

		// 각 위치에 올 수 있는 경로의 수를 저장하며 경우의 수 구하기
		System.out.println(getCnt(0, 0));
	}

	private static long getCnt(int r, int c) {
		if (cnt[r][c] != -1) {
			return cnt[r][c];
		}

		cnt[r][c] = 0;

		int nr, nc;
		for (int i = 0; i < 2; i++) {
			nr = r + dr[i] * map[r][c];
			nc = c + dc[i] * map[r][c];

			if (!isIn(nr, nc)) {
				continue;
			}

			cnt[r][c] += getCnt(nr, nc);
		}

		return cnt[r][c];
	}

	private static boolean isIn(int r, int c) {
		return r < N && c < N;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = new long[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cnt[i], -1);
		}
		cnt[N - 1][N - 1] = 1;
	}
}