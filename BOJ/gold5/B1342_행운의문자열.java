package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1342_행운의문자열 {

	static int N;
	static char[] alphabet;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine().trim();
		N = s.length();
		alphabet = new char[N];
		
		for (int i = 0; i < N; i++) {
			alphabet[i] = s.charAt(i);
		}

		Arrays.sort(alphabet);

		int cnt = 0;
		do {
			// 중복순열 구하고 행운의 문자열인지 확인
			if (checkString()) {
				// 행운의 문자열이면 ++
				cnt++;
			}
		} while (np());

		System.out.println(cnt);
	}

	// 행운의 문자열인지 여부
	private static boolean checkString() {
		for (int i = 0; i < N - 1; i++) {
			if (alphabet[i] == alphabet[i + 1])
				return false;
		}

		return true;
	}

	// NextPermutation으로 중복 순열 구하기
	private static boolean np() {
		// 
		int i = N - 1;
		while (i != 0 && alphabet[i] <= alphabet[i - 1])
			i--;
		
		if(i == 0)
			return false;
		
		int j = N - 1;
		while (alphabet[i - 1] >= alphabet[j])
			j--;
		
		// swap
		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	// 자리 바꾸기
	private static void swap(int i, int j) {
		char temp = alphabet[i];
		alphabet[i] = alphabet[j];
		alphabet[j] = temp;
	}

}
