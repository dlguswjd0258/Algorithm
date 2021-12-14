/**
* 메모리: 60648 KB, 시간: 184 ms
* 2021.12.14
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int aLen, bLen;
	static char[] A, B;
	static String[][] lcs;

	public static void main(String[] args) throws Exception {
		init();

		getLcs();

		System.out.println(lcs[aLen][bLen].length() + "\n" + lcs[aLen][bLen]);
	}

	private static void getLcs() {

		int a, b;
		for (int i = 1; i <= aLen; i++) {
			for (int j = 1; j <= bLen; j++) {

				// 문자가 다르면 이전 문자들 중 긴 문자 저장
				if (A[i - 1] != B[j - 1]) {
					a = lcs[i - 1][j].length();
					b = lcs[i][j - 1].length();

					lcs[i][j] = a > b ? lcs[i - 1][j] : lcs[i][j - 1];
				} else {
					lcs[i][j] = lcs[i - 1][j - 1] + B[j - 1];
				}
			}
		}
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		A = in.readLine().toCharArray();
		B = in.readLine().toCharArray();

		aLen = A.length;
		bLen = B.length;

		lcs = new String[aLen + 1][bLen + 1];

		// lcs 0행, 0열 초기화
		Arrays.fill(lcs[0], "");
		for (int i = 1; i <= aLen; i++) {
			lcs[i][0] = "";
		}
	}
}