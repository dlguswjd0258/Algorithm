/**
* 메모리: 11524 KB, 시간: 80 ms
* 2021.12.05
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(getCnt());
	}

	private static int getCnt() {
		// 행에는 자리수, 열에는 idx로 끝나는 숫자의 개수
		int[][] dp = new int[N + 1][10];

		// 1자리 수는 0을 제외하고 모두 한개로 초기화
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		// i자리수의 j로 끝나는 수 = i-1 자리수의 j+1로 끝나는 수와 j-1로 끝나는 수의 개수를 합한 값
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				// 0을 제외한 나머지 수는 j-1로 끝나는 개수 더하기
				if (j > 0) {
					dp[i][j] = dp[i - 1][j - 1];
				}

				// 9를 제외한 나머지 수는 j+1로 끝나느 개수 더하기
				if (j < 9) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			cnt = (cnt + dp[N][i]) % 1000000000;
		}

		return cnt;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}
