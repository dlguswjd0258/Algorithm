/**
* 메모리: 87656 KB, 시간: 240 ms
* 2022.01.21
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int R, C, N, map[][];

	public static void main(String[] args) throws Exception {
		input();
		getMapAfterN();
        System.out.println(printMap());
	}

	private static void getMapAfterN() {	
//		// N초 동안 설치, 폭발 반복
		while (N > 0) {
			// 폭탄 설치 & 1초 더 지나기
			List<int[]> three = installBomb();
			N--;
			
			if(N <= 0) {
				break;
			}
			
			// 3초된 폭탄 폭발
			N--;
			for (int[] bomb : three) {
				explodeBomb(bomb[0], bomb[1]);
			}
		}
	}

	private static void explodeBomb(int r, int c) {
		map[r][c] = 0;

		// 터지는 폭탄 사방에 있는 폭탄 파괴
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];

			if (!isIn(nr, nc)) {
				continue;
			}

			map[nr][nc] = 0;
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static List<int[]> installBomb() {
		List<int[]> three = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 2;
				}else {
					map[i][j]++;
				}
				
				if (map[i][j] == 3) {
					three.add(new int[] { i, j });
				}
			}
		}

		return three;
	}

	private static String printMap() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j] == 0 ? '.' : 'O');
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// 초기 1초동안 아무 것도 안하므로 -1
		N = Integer.parseInt(st.nextToken()) - 1;

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine().trim();
			for (int j = 0; j < C; j++) {
				// 폭탄 없는 곳
				if (s.charAt(j) == '.') {
					continue;
				}
				// 폭탄 설치 초기화
				map[i][j] = 2;
			}
		}
	}
}