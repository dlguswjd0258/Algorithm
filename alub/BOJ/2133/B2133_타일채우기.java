/**
* 메모리: 12828 KB, 시간: 108 ms
* 2021.12.22
* by Alub
*/
import java.util.Scanner;

public class Main {

	static int N;

	public static void main(String[] args) {
		input();
		System.out.println(getCnt());
	}

	private static int getCnt() {
		int[] dp = new int[N + 1];

		dp[0] = 1;

		// 홀수는 모두 0;
		for (int i = 2; i <= N; i += 2) {
			// 1*2 3개를 추가로 붙일 때 만들 수 있는 경우의 수는 i-2의 수
			dp[i] = dp[i-2];
			
			// i보다 작은 수 중 짝수에서 유니크한 방법(?)을 얹을 때 만들 수 있는 경우의 수 
			for (int j = 0; j < i; j += 2) {
				dp[i] += dp[j] * 2;
			}
		}

		return dp[N];
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	}
}