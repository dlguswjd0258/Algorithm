package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10448_유레카이론 {

	static int T, K, range;
	static int[] DP = new int[45]; // 45까지 Tn 구해 놓기 - T45 > 1000이기 때문
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		// 삼각수 구해 놓기
		getTn();

		while (T-- > 0) {
			K = Integer.parseInt(in.readLine());

			// K보다 작은 삼각수까지가 범위
			range = Arrays.binarySearch(DP, K);

			// DP에 없는 숫자면 있어야 할 자리의 음수 -1이므로
			if (range < 0) {
				range = -range - 1;
			}

			if (checkEureka(range - 1, 0, 0))
				sb.append("1\n");
			else
				sb.append("0\n");

		}

		System.out.println(sb.toString());

	}

	// 조합으로 백트래킹해보자..
	// cnt가 3이 넘거나 sum이 K를 넘으면 return;
	private static boolean checkEureka(int idx, int cnt, int sum) {
		if (cnt > 3 || sum > K) {
			return false;
		}

		if (cnt == 3 && sum == K)
			return true;

		for (int i = idx; i >= 1; i--) {
			if (checkEureka(i, cnt + 1, sum + DP[i])) {
				return true;
			}
		}

		return false;
	}

	// Tn 구하기
	private static void getTn() {
		for (int i = 1; i < 45; i++) {
			DP[i] = DP[i - 1] + i;
		}
	}

}
