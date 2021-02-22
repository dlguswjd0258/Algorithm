package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1992_쿼드트리 {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];

		// 영상 정보 읽어 오기
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		// 분할 정복을 활용해 압축
		divide(0, 0, N);

		System.out.println(sb.toString());
	}

	/**
	 * 압축이 가능하다면 값을 담고, 가능하지 않다면 분할하기
	 * 
	 * @param x 압축 확인할 시작 좌표, 행
	 * @param y 압축 확인할 시작 좌표, 열
	 * @param n 압축 범위의 크기
	 */
	private static void divide(int x, int y, int n) {
		// 확인할 범위가 1이라면 하나뿐이므로 현재 좌표의 map 추가
		if (n == 1) {
			sb.append(map[x][y]);
			return;
		}

		// map을 탐색하면서 영상을 4분할 해야할지 확인
		if (checkMap(x, y, n)) {
			// 압축 가능하다면 현재 좌표의 값으로 압축
			sb.append(map[x][y]);
		} else {
			// 압축 불가능 하다면 4분할 해서 다시 확인
			sb.append('(');

			// 4분할할 때 범위 2로 나누기
			n /= 2;
			divide(x, y, n); // 왼쪽 위
			divide(x, y + n, n); // 오른쪽 위
			divide(x + n, y, n); // 왼쪽 아래
			divide(x + n, y + n, n); // 오른쪽 아래

			sb.append(')');
		}
	}

	/**
	 * 주어진 범위에서 map의 정보를 확인
	 * 
	 * @param x 확인할 시작 좌표, 행
	 * @param y 확인할 시작 좌표, 열
	 * @param n 확인할 범위의 크기
	 * @return 0이나 1만 있다면 true, 섞여 있다면 false
	 */
	private static boolean checkMap(int x, int y, int n) {
		char check = map[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[i][j] == check)
					continue;
				return false;
			}
		}
		return true;
	}

}
