package bronze1;

import java.util.Scanner;

public class B11050_이항계수1 {

	static int N, K;
	static long[][] pask;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		long resN = 1, resK = 1;
		while (K > 0) {
			resN *= N--;
			resK *= K--;
		}
		System.out.println(resN / resK);
	}
}
