package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// BOJ B2 3040 백설공주와 일곱 난쟁이
public class B3040_백설공주와일곱난쟁이 {

	static int[] guest = new int[9];
	static int[] nangang = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 데이터 입력
		for (int i = 0; i < 9; i++) {
			guest[i] = Integer.parseInt(in.readLine());
		}

		// 조합으로 구하면서 합이 100인 조합 구하기
		comb(0, 0, 0);
	}

	// 결과 출력
	private static void print() {
		for (int n : nangang) {
			System.out.println(guest[n]);
		}

		// 프로그램 끝내기 ( 100인 경우는 유일하기 때문에 )
		System.exit(0);
	}

	private static void comb(int idx, int cnt, int sum) {
		if (cnt == 7) {
			if (sum == 100)
				print();
			return;
		}

		for (int i = idx; i < 9; i++) {
			nangang[cnt] = i;
			comb(i+1, cnt + 1, sum + guest[i]);
		}
	}
}
