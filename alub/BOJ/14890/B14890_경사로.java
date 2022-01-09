/**
* 메모리: 12780 KB, 시간: 104 ms
* 2022.01.09
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, L, map[][];

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(countWay());
	}

	private static int countWay() {
		return getColumnWay() + getRowWay();
	}

	private static int getRowWay() {
		int way = 0;
		for (int r = 0; r < N; r++) {
			boolean possible = true;
			for (int c = 0; c < N; c++) {
				// 현재와 같은 값을 같는 위치가 어디까지 있는지 idx를 찾는다.
				int endC = c;
				while (endC < N && map[r][c] == map[r][endC]) {
					endC++;
				}

				// 옆 칸 확인하면서 경사로를 놓을 수 있는지 확인
				if (!isPossibleWay(r, c, r, endC - 1, 0, 1)) {
					possible = false;
					break;
				}

				c = endC - 1;
			}

			if (possible) {
				way++;
			}
		}

		return way;
	}

	private static boolean isPossibleWay(int r1, int c1, int r2, int c2, int dr, int dc) {
		int need = 0;
		// 왼쪽 확인
		need += countNeed(r1, c1, -dr, -dc);
		// 오른쪽 확인
		need += countNeed(r2, c2, dr, dc);

		// 같은 값을 갖는 칸의 수가 경사로가 차지하는 칸의 수보다 작으면 갈 수 없는 길
		int cnt = r2 - r1 + c2 - c1 + 1;
		
		// need가 마이너스면 불가능한 경로라는 의미
		return need >= 0 && cnt >= need * L;
	}

	private static int countNeed(int r, int c, int dr, int dc) {
		int diff = 0;
		if (isIn(r + dr, c + dc)) {
			diff = map[r + dr][c + dc] - map[r][c];
			if (Math.abs(diff) > 1) {
				return -3;
			}
		}
		return diff > 0 ? 1 : 0;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static int getColumnWay() {
		int way = 0;
		for (int c = 0; c < N; c++) {
			boolean possible = true;
			for (int r = 0; r < N; r++) {
				// 현재와 같은 값을 같는 위치가 어디까지 있는지 idx를 찾는다.
				int endR = r;
				while (endR < N && map[r][c] == map[endR][c]) {
					endR++;
				}

				// 옆 칸 확인하면서 경사로를 놓을 수 있는지 확인
				if (!isPossibleWay(r, c, endR - 1, c, 1, 0)) {
					possible = false;
					break;
				}

				r = endR - 1;
			}

			if (possible) {
				way++;
			}
		}

		return way;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}