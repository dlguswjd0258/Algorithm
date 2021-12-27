/**
* 메모리: 14964 KB, 시간: 96 ms
* 2021.12.27
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getCnt());
	}

	private static int getCnt() {
		// 0 : 배치 안함, 1: 왼쪽 배치, 2: 오른쪽 배치
		int[][] dp = new int[N + 1][3];

		// 초기화 : 0*2 우리에 사자를 배치하지 않을 경우의 수 = 1
		dp[0][0] = 1;

		// 경우의 수를 저장할 때 9901로 나눈 나머지 저장하기
		for (int i = 1; i <= N; i++) {
			// 현재 줄에 사자 배치 안하는 경우의 수는 이전에 구한 모든 경우의 수를 더한 값
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;

			// 현재 줄에 왼쪽에 사자를 배치하는 경우의 수는 이전에 왼쪽에 사자를 배치한 경우의 수를 제외하고 더한 값
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;

			// 오른쪽 배치도 왼쪽과 마찬가지
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}

		// N번째의 모든 경우의 수 더하기
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			cnt = (cnt + dp[N][i]) % 9901;
		}
		return cnt;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}