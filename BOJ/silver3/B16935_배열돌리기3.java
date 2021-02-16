package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ silver3 16935 배열 돌리기 3
public class B16935_배열돌리기3 {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵 그리기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산하기
		st = new StringTokenizer(in.readLine());
		while (st.hasMoreTokens()) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				operation1();
				break;
			case 2:
				operation2();
				break;
			case 3:
				operation3();
				break;
			case 4:
				operation4();
				break;
			case 5:
				operation5();
				break;
			case 6:
				operation6();
				break;
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	/**
	 * 상하 반전 시키기
	 */
	private static void operation1() {
		int temp;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				temp = map[i][j];
				map[i][j] = map[N - i - 1][j];
				map[N - i - 1][j] = temp;
			}
		}
	}

	/**
	 * 좌우 반전 시키기
	 */
	private static void operation2() {
		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp = map[i][j];
				map[i][j] = map[i][M - j - 1];
				map[i][M - j - 1] = temp;
			}
		}
	}

	/**
	 * 오른쪽 90도 회전 시키기
	 */
	private static void operation3() {
		// 행, 열 크기 바꿔주기
		int temp = N;
		N = M;
		M = temp;
		
		// 바꾼 행, 열 크기에 맞게 배열 하나 생성
		int[][] map2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[M - j - 1][i];
			}
		}

		
		map = map2;
	}

	/**
	 * 왼쪽 90도 회전 시키기
	 */
	private static void operation4() {
		int temp = N;
		N = M;
		M = temp;
		int[][] map2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[j][N - i - 1];
			}
		}

		map = map2;
	}

	/**
	 * 4 그룹으로 나눠 오른쪽으로 회전
	 */
	private static void operation5() {
		int temp;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp = map[i][j];
				map[i][j] = map[i + N / 2][j];
				map[i + N / 2][j] = map[i + N / 2][j + M / 2];
				map[i + N / 2][j + M / 2] = map[i][j + M / 2];
				map[i][j + M / 2] = temp;
			}
		}
	}

	/**
	 * 4 그룹으로 나눠 왼쪽으로 회전
	 */
	private static void operation6() {
		int temp;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp = map[i][j];
				map[i][j] = map[i][j + M / 2];
				map[i][j + M / 2] = map[i + N / 2][j + M / 2];
				map[i + N / 2][j + M / 2] = map[i + N / 2][j];
				map[i + N / 2][j] = temp;
			}
		}
	}

}
