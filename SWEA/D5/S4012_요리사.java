package MockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4012_요리사 {

	static int T, N, min;
	static int[][] S;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			// 초기화
			min = Integer.MAX_VALUE;

			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine());
			S = new int[N + 1][N + 1];

			// 데이터를 받으면서 재료들의 시너지를 합친다. (1,2) (2,1) 의 시너지를 (1,2)에 합친다.
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; j++) {
					if (j < i) {
						S[j][i] += Integer.parseInt(st.nextToken());
						continue;
					}
					S[i][j] += Integer.parseInt(st.nextToken());
				}
			}

			// 1이 포함된 조합을(조합의 절반만) 구한다.
			combination(2, 1, 1 << 1);

			sb.append(min).append("\n");
		}

		System.out.println(sb.toString());

	}
	
	/**
	 * 조합을 만들어서 두 음식의 시너지 차이를 구하고 min값 갱신하기
	 * 
	 * @param idx  현재 선택된 idx
	 * @param cnt  선택된 숫자의 개수
	 * @param flag 앞서 선택된 idx의 정보
	 */
	private static void combination(int idx, int cnt, int flag) {
		if (cnt == N / 2) {
			// 재료의 절반을 선택했다면 두 음식의 시너지의 차이를 구하고 min값을 갱신
			min = Math.min(min, getDifference(flag));
			return;
		}

		for (int i = idx; i <= N; i++) {
			combination(i + 1, cnt + 1, flag | 1 << i);
		}
	}

	/**
	 * 조합으로선택된 재료들의 음식 맛과 선택되지 않은 재료들의 음식 맛의 차이 구하기
	 * 
	 * @param flag 조합으로 선택된 재료 idx의 정보
	 * @return 두 음식 맛 차이의 절댓값
	 */
	private static int getDifference(int flag) {
		// 1이 포함되지 않은 조합에서도 2개씩 조합을 구해서 시너지를 합친다.
		return Math.abs(getScore(flag) - getScore(~flag));
	}

	/**
	 * 선택된 재료들의 음식 맛 점수 구하기
	 * 
	 * @param selected 선택된 재료 idx의 정보
	 * @return 맛 점수
	 */
	private static int getScore(int selected) {

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if ((selected & 1 << i) == 0)
				continue;
			for (int j = i + 1; j <= N; j++) {
				if ((selected & 1 << j) == 0)
					continue;
				// 조합 안에서 2개씩 조합을 구하여 시너지 정보를 합친다.
				sum += S[i][j];
			}
		}

		return sum;
	}

}
