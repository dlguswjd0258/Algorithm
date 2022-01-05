/**
* 메모리: 15564 KB, 시간: 100 ms
* 2022.01.05
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

// DP
public class Main {

	static final int MOD = 1000000009;
	static int T, input[], dp[];

	public static void main(String[] args) throws Exception {
		int max = input();

		initDP(max);

		StringBuilder sb = new StringBuilder();
		for (int in : input) {
			sb.append(dp[in]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		input = new int[T];
		int max = 0;
		for (int i = 0; i < T; i++) {
			input[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, input[i]);
		}

		return max;
	}

	private static void initDP(int max) {
        dp = new int[max + 1];
        
		// 0과 1을 만드는 방법의 수는 1가지
		dp[0] = dp[1] = 1;

		// 2를 만드는 방법의 수는 2가지 ( 1+1, 2 )
		dp[2] = 2;

		for (int i = 3; i <= max; i++) {
			// 1을 더하기 전의 방법 수 + 2를 더하기 전의 방법 수 + 3을 더하기 전의 방법 수
			dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
		}
	}
}