package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//SWEA 1954 달팽이 숫자
public class S1954_달팽이숫자 {

	static int N;
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 }; // 우, 하, 좌, 상
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");

			// 1. 데이터 받기
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			// 2. map에 숫자 넣기
			int r = 0, c = 0, nr, nc, d = 0;
			for (int i = 1; i <= N * N; i++) { // map에 넣을 숫자
				// 2-1. 현재 위치에 숫자 넣기
				map[r][c] = i;

				nr = r + dr[d];
				nc = c + dc[d];

				// 2-2. 다음 위치가 벽이거나 map이 0이 아니라면 방향 바꾸기
				if (!isIn(nr, nc) || map[nr][nc] != 0) {
					d = (d + 1) % 4;
					// 다시 값 설정
					r += dr[d];
					c += dc[d];
				} else {
					r = nr;
					c = nc;
				}
			}

			// 3. 맵 그리기
			for (int[] arr : map) {
				for (int a : arr) {
					sb.append(a).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	/**
	 * 주어진 위치가 map 안에 있는지 판단 여부
	 * 
	 * @param nr 행
	 * @param nc 열
	 * @return map 안이면 true, 밖이면 false
	 */
	private static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}
