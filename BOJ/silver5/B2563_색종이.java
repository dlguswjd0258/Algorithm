package silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ silver5 2563 색종이
public class B2563_색종이 {

	static int N, x, y, cnt;
	static boolean[][] map = new boolean[100][100];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// 입력 받기
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			// 색종이 시작 좌표값 큐에 넣기
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			// 현재 검은 색종이 넓이 구하기 : 시작 위치부터 10 * 10을 돌면서 map이 false일 때만 cnt++
			for (int r = x; r < x + 10; r++) {
				for (int c = y; c < y + 10; c++) {
					if (map[r][c])
						continue;
					map[r][c] = true;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
