/**
* 메모리: 13264 KB, 시간: 112 ms
* 2021.12.02
* by Alub
*/
import java.io.*;

public class Main {

	static int N, amount[];

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(getMaxAmount());

	}

	private static int getMaxAmount() {
		int dp[][] = new int[N + 1][3]; // 2번 연속 먹었을 때 양, 1번 연속 먹었을 때 양, 안먹었을 때의 양

		for (int i = 1; i <= N; i++) {
			// 2번 연속으로 먹는다는 것은 이전 포도주에서는 1번 연속으로 먹었다는 의미
			dp[i][0] = dp[i - 1][1] + amount[i];

			// 1번 연속으로 먹는다는 것은 이전 포도주에서는 안먹었다는 의미
			dp[i][1] = dp[i - 1][2] + amount[i];

			// 안먹는 다는 것은 이전에 2번 연속으로 먹었다는 의미
			dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));

		}
		int max = 0;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[N][i]);
		}

		return max;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		amount = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			amount[i] = Integer.parseInt(in.readLine());
		}
	}
}