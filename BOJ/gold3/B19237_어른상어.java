package gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19237_어른상어 {

	static class Shark {
		int num, r, c, d;
		int[][] dir;

		public Shark(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
			dir = new int[4][4];
		}

		@Override
		public String toString() {
			return "Shark [num=" + num + ", r=" + r + ", c=" + c + ", d=" + d + ", dir=" + Arrays.toString(dir) + "]";
		}
	}

	static class Smell {
		int num, k;

		public Smell(int num, int k) {
			this.num = num;
			this.k = k;
		}

		@Override
		public String toString() {
			return "[" + num + "," + k + "]";
		}
	}

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N, M, K;
	static Smell[][] map;
	static Shark[] sharks;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Smell[N][N];
		sharks = new Shark[M + 1];

		// 상어 위치 구하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					continue;
				sharks[num] = new Shark(num, i, j);
				map[i][j] = new Smell(num, K);
			}
		}

		// 상어 방향 구하기
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= M; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken()) - 1;
		}

		// 각 상어들의 우선순위 구하기
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < 4; k++) {
					sharks[i].dir[j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}

		int turn = 0;
		while (M > 1) {
			if (turn > 1000) {
				turn = -1;
				break;
			}

			// 번호 순서대로 이동하기
			moveSharks();

			// map에 남은 냄새 기간 하루 빼기
			passADay();

			// 냄새 남기기
			spreadSmell();

			turn++;
		}

		System.out.println(turn);

	}

	private static void spreadSmell() {
		for (Shark shark : sharks) {
			if (shark == null)
				continue;

			map[shark.r][shark.c] = new Smell(shark.num, K);
		}
	}

	private static void moveSharks() {
		boolean mySmell;
		int d, r, c, nd, nr, nc;
		for (Shark shark : sharks) {
			if (shark == null)
				continue;

			mySmell = false;
			r = shark.r;
			c = shark.c;
			d = shark.d;
			// 우선 아무 냄새 없는 방향으로 가기
			for (int i = 0; i < 4; i++) {
				// 우선순위로 인한 다음 방향
				nd = shark.dir[d][i];
				nr = r + dr[nd];
				nc = c + dc[nd];

				if (!isIn(nr, nc))
					continue;

				// 아무 냄새가 없는 칸
				if (map[nr][nc] == null) {
					shark.r = nr;
					shark.c = nc;
					shark.d = nd;
					break;
				}

				// 자신의 냄새인 위치
				if (!mySmell && map[nr][nc].num == shark.num) {
					shark.r = nr;
					shark.c = nc;
					shark.d = nd;
					mySmell = true;
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static void passADay() {
		boolean[][] isShark = new boolean[N][N];
		for (Shark shark : sharks) {
			if (shark == null)
				continue;

			// 이전 이동에서 겹쳤다는 의미
			if (isShark[shark.r][shark.c]) {
				sharks[shark.num] = null;
				M--;
				continue;
			}

			isShark[shark.r][shark.c] = true;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == null)
					continue;

				map[i][j].k--;
				if (map[i][j].k == 0)
					map[i][j] = null;
			}
		}

	}
}
