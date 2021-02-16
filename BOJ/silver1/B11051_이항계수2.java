package silver1;

import java.util.Scanner;

public class B11051_이항계수2 {

	static int N, K;
	static long[][] pask;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		pask = new long[N + 1][K + 1];
		pask[0][0] = 1;
		System.out.println(paskal(N, K));
	}

	private static long paskal(int n, int k) {
		if (n < k || k < 0)
			return 0;
//
//		if (n == k || n <= 1) {
//			return 1;
//		}

		if (pask[n][k] == 0)
			pask[n][k] = (paskal(n - 1, k - 1) + paskal(n - 1, k)) % 10007;
		
		return pask[n][k];
	}
}
