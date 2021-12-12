/**
* 메모리: 17100 KB, 시간: 132 ms
* 2021.12.12
* by Alub
*/
import java.util.Scanner;

public class Main {

	static char[] A, B;

	public static void main(String[] args) {
		init();

		System.out.println(getLcsLength());
	}

	private static int getLcsLength() {
		int aLen = A.length;
		int bLen = B.length;
		int[][] lcs = new int[aLen + 1][bLen + 1];

		// A를 행 B를 열로 사용
		for (int i = 1; i <= aLen; i++) {
			for (int j = 1; j <= bLen; j++) {
				if (A[i - 1] != B[j - 1]) {
//					둘이 다른 문자연 이전 문자의 i-1과 j-1의 길이 중 큰 값
					lcs[i][j] = getMathLen(lcs[i - 1][j], lcs[i][j - 1]);
				} else {
//					j번째 문자가 i번째와 같은 문자라면 (i-1, j-1의 길이 + 1)과 j-1의 길이 중 큰 값
					lcs[i][j] = getMathLen(lcs[i - 1][j - 1] + 1, lcs[i][j - 1]);
				}
			}
		}

		return lcs[aLen][bLen];
	}

	private static int getMathLen(int a, int b) {
		return Math.max(a, b);
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine().toCharArray();
		B = sc.nextLine().toCharArray();
	}
}