/**
* 메모리:  KB, 시간:  ms
* 2022.01.20
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static final int MAX = 200;
	static int N;
	static boolean[] prime, special;

	public static void main(String[] args) throws Exception {
		input();
		// 소수 찾기
		initPrime();
		// 특별한 수 찾
		initSpecialNum();
		System.out.println(findSpecialNum());
	}

	private static int findSpecialNum() {
		int num = N + 1;
		while(true) {
			if(special[num]) {
				return num;
			}
			
			num++;
		}
	}

	private static void initSpecialNum() {
		special = new boolean[MAX*MAX + 1];
		int pre = 2;
		for (int i = 3; i <= MAX; i++) {
			if(!prime[i]) {
				continue;
			}
			
			special[pre*i] = true;
			pre = i;
		}
	}

	private static void initPrime() {
		// 소수 구하기
		prime = new boolean[MAX + 1];
		Arrays.fill(prime, true);
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (!prime[i]) {
				continue;
			}

			for (int j = 2; i * j <= MAX; j++) {
				prime[i * j] = false;
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}
