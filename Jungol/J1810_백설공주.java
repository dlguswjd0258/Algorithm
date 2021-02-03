

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J1810_백설공주 {

	static final int N = 9;
	static final int R = 7;
	static int[] guest = new int[N];
	static int[] nangang = new int[R];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 데이터 입력 받기
		for (int i = 0; i < N; i++) {
			guest[i] = Integer.parseInt(br.readLine());
		}

		// 2. 조합으로 출력 뽑아내기
		combination(0, 0, 0);
	}

	private static void combination(int cnt, int idx, int sum) {
		if (cnt == R) {
			if (sum == 100) {
				printNangang();
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			// guest idx 저장
			nangang[cnt] = i;
			combination(cnt + 1, i + 1, sum + guest[i]);
		}
	}

	private static void printNangang() {
		for (int n : nangang) {
			System.out.println(guest[n]);
		}
	}

}
