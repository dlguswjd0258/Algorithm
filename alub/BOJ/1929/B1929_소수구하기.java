/**
* 메모리: 21292 KB, 시간: 216 ms
* 2021.12.17
* by Alub
*/
import java.util.Arrays;
import java.util.Scanner;

/*
M <= x <= N 사이의 소수 구하기 
에스테라토스의 체로 소수 먼저 구하고 
 */
public class Main {

	static int M, N;
	static final int MAX = 1000000;
	static boolean[] prime = new boolean[MAX + 1];

	public static void main(String[] args) {
		input();
		getPrimeNumbers();

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if(!prime[i]) {
				continue;
			}
			
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void getPrimeNumbers() {
		Arrays.fill(prime, true);
		prime[1] = false;

		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			// 소수가 아니면 pass
			if (!prime[i]) {
				continue;
			}

			// 소수의 배수 체크
			for (int j = 2; i * j < MAX; j++) {
				prime[i * j] = false;
			}
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
	}
}