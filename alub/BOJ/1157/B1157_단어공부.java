/**
* 메모리: 34596 KB, 시간: 376 ms
* 2021.12.31
* by Alub
*/
import java.util.Scanner;

public class Main {
	static String str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine().toUpperCase();

		System.out.println(getMaxAlph());
	}

	private static char getMaxAlph() {
		// 알파벳 개수 세기
		int[] cnt = countCnt();
		int max = getMaxCnt(cnt);

		// 가장 많은 알파벳 구하기
		int idx = -1;
		for (int i = 0; i < 26; i++) {
			if (max != cnt[i]) {
				continue;
			}

			// 가장 많은 알파벳이 여러개라는 의미
			if (idx >= 0) {
				return '?';
			}

			idx = i;
		}

		return (char) (idx + 'A');
	}

	private static int getMaxCnt(int[] cnt) {
		int max = 0;
		for (int num : cnt) {
			max = Math.max(max, num);
		}
		return max;
	}

	private static int[] countCnt() {
		int[] cnt = new int[26];
		for (char c : str.toCharArray()) {
			cnt[c - 'A']++;
		}
		return cnt;
	}
}