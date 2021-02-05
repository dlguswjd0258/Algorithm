package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 지도 칠하기
public class S7208_지도칠하기 {

	static int T, N, min;
	static int[] color, map[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine());
			color = new int[N];
			map = new int[N][N];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			recursive(0, 0);

			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void recursive(int idx, int cnt) {
		if (idx == N) {
			if (isOk())
				min = Math.min(min, cnt);
			return;
		}

		int c;
		for (int i = 1; i <= 4; i++) {
			if (color[idx] == i) {
				recursive(idx + 1, cnt);
			} else {
				c = color[idx];
				color[idx] = i;
				recursive(idx + 1, cnt + 1);
				color[idx] = c;
			}
		}
	}

	private static boolean isOk() {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (map[i][j] == 1 && color[i] == color[j]) {
					return false;
				}
			}
		}
		return true;
	}

}
