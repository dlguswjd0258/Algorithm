package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ gold4 1987 알파벳
public class B1987_알파벳 {

	static int R, C, max;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 }; // 하,우,상,좌
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];

		// flag 계산하기 편하게 숫자로 치환해서 저장
		String s = null;
		for (int i = 0; i < R; i++) {
			s = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j) - 'A';
			}
		}

		// 0,0부터 말이 이동할 수 있는 칸수를 dfs로 확인
		dfs(1, 0, 0, 1 << board[0][0]);
		System.out.println(max);
	}

	/**
	 * 현재 위치에서 다음 위치로 이동하면서 말이 지나간 칸 수를 최대
	 * 
	 * @param cnt  지나온 칸 수
	 * @param r    현재 행
	 * @param c    현재 열
	 * @param flag 선택된 알파벳을 체크한 변수
	 */
	private static void dfs(int cnt, int r, int c, int flag) {

		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			// 범위를 벗어났거나 이미 선택된 알파벳이라면 continue
			if (!isIn(nr, nc) || (flag & 1 << board[nr][nc]) != 0)
				continue;

			dfs(cnt + 1, nr, nc, flag | 1 << board[nr][nc]);
		}

		max = Math.max(max, cnt);
	}

	/**
	 * 좌표 범위 체크
	 * 
	 * @param nr 행
	 * @param nc 열
	 * @return 배열 안에 있는 좌표면 true, 아니면 false
	 */
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
