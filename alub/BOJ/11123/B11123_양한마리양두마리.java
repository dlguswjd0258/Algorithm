/**
* 메모리: 17856 KB, 시간: 156 ms
* 2021.12.29
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] map;
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			// 입력 받기
			input();

			// 양무리 세기
			sb.append(countSheep()).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int countSheep() {
		int cnt = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 양이 아니거나 이미 체크한 양이면 pass
				if (map[i][j] != '#') {
					continue;
				}

				cnt++;
				checkSheep(i, j);
			}
		}

		return cnt;
	}

	private static void checkSheep(int r, int c) {
		if (!isIn(r, c) || map[r][c] != '#') {
			return;
		}

		// 방문 체크
		map[r][c] = 'v';

		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];

			checkSheep(nr, nc);
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][];
		for (int i = 0; i < H; i++) {
			map[i] = in.readLine().toCharArray();
		}
	}

}