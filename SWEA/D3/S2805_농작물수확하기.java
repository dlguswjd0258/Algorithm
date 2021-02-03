package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S2805_농작물수확하기 {

	static int T, N, half, sum;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		String s;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			// 1. 데이터 받기
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			half = N / 2;
			sum = 0;

			// 1번) 수확 가능한 가치 구하기 - 마름모 위치에 있는지 확인
//			int dif = 0;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					dif = Math.abs(half - i);
//					dif += Math.abs(half - j);
//					if (dif >= -half && dif <= half)
//						sum += map[i][j];
//				}
//			}

			// 2번) 수확 가능한 가치 구하기 - 대칭 이용하기
			for (int i = 0; i <= half; i++) {
				for (int j = half - i; j <= half + i; j++) {
					sum += map[i][j];
					if (i == half)
						continue;
					sum += map[N - i - 1][j];
				}
			}

			sb.append(sum).append("\n");
		}

		System.out.println(sb.toString());
	}

}
