/**
* 메모리: 12908 KB, 시간: 112 ms
* 2021.12.11
* by Alub
*/
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) {
		init();

		System.out.println(getCnt());
	}

	private static int getCnt() {
		int[][] dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; i++) {
			// j = 맨 앞자리가 될 숫자 0~9
			for (int j = 0; j < 10; j++) {
				// k = 이전 자리수에서 맨 앞자리였던 숫자 0~9
				// j가 앞에 올 수 있는 k들의 합 구하기 
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
				}
			}
		}

		
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			cnt = (cnt + dp[N][i]) % 10007;
		}

		return cnt;
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	}
}