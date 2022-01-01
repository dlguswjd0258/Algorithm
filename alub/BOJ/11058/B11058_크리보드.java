/**
* 메모리: 11512 KB, 시간: 76 ms
* 2022.01.01
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		input();
        
		// dp 방식
		System.out.println(countA());
	}

	private static long countA() {
		long[] dp = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			// A 출력
			dp[i] = dp[i - 1] + 1;

			if (i <= 6) {
				continue;
			}

			// 복붙한게 더 큰지 확인
			for (int j = 2; j <= 4; j++) {
				dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
			}

		}

		return dp[N];

	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}