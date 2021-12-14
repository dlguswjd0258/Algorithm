/**
* 메모리: 15800 KB, 시간: 100 ms
* 2021.12.14
* by Alub
*/
import java.io.*;

public class Main {

	static int aLen, bLen;
	static char[] A, B;
	static int[][] len;

	public static void main(String[] args) throws Exception {
		init();

		int resLen = getLcsLen();
		System.out.println(resLen);

		if (resLen > 0) {
			System.out.println(getLcs());
		}
	}

	private static String getLcs() {
		StringBuilder sb = new StringBuilder();

		int c = bLen;
		for (int r = aLen; r > 0; r--) {
			if (len[r][c] == 0) {
				break;
			}

			// 현재 위치에서 같은 열중에서 길이가 다를때까지 열을 감소
			while (c > 0 && len[r][c] == len[r][c - 1]) {
				c--;
			}

			// 현재 위치에서 A와 B의 알파벳이 같다면 알파벳 추가 다르다면 pass
			if (A[r - 1] == B[c - 1]) {
				sb.insert(0, B[--c]);
			}

		}

		return sb.toString();
	}

	private static int getLcsLen() {
		// A를 행 B를 열로 사용
		for (int i = 1; i <= aLen; i++) {
			for (int j = 1; j <= bLen; j++) {
				if (A[i - 1] != B[j - 1]) {
//					둘이 다른 문자연 이전 문자의 i-1과 j-1의 길이 중 큰 값
					len[i][j] = getMathLen(len[i - 1][j], len[i][j - 1]);
				} else {
//					j번째 문자가 i번째와 같은 문자라면 (i-1, j-1의 길이 + 1)과 j-1의 길이 중 큰 값
					len[i][j] = getMathLen(len[i - 1][j - 1] + 1, len[i][j - 1]);
				}
			}
		}

		return len[aLen][bLen];
	}

	private static int getMathLen(int a, int b) {
		return Math.max(a, b);
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		A = in.readLine().toCharArray();
		B = in.readLine().toCharArray();

		aLen = A.length;
		bLen = B.length;

		len = new int[aLen + 1][bLen + 1];
	}
}