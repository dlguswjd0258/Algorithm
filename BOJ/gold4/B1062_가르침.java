package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ gold4 1062 가르침
public class B1062_가르침 {

	static int N, K, max;
	static char[] acint = { 'a', 'c', 'i', 'n', 't' };
//	static int[] word;
	static String[] word;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
//		word = new int[N];

		// a, c, i, n, t 중 하나라도 배우지 못한다면 0
		if (K < 5) {
			System.out.println(0);
			return;
		}

		// 데이터 입력 받기
		String s;
		for (int i = 0; i < N; i++) {
			s = in.readLine();
			word[i] = s.substring(4, s.length() - 4);
//			for (int j = 0; j < s.length(); j++) {
//				word[i] |= 1 << (s.charAt(j) - 'a');
//			}
		}

		// flag default 설정
		int flag = 0;
		for (char c : acint) {
			flag |= 1 << (c - 'a');
		}

		// K-5로 만들 수 있는 조합 구하기, a가 0이니까 idx는 1부터
		comb(1, 0, flag);

		System.out.println(max);
	}

	private static void comb(int idx, int cnt, int flag) {
		if (cnt == K - 5) {
			// 조합이 완성되면 입력 받은 단어와 비교해서 읽을 수 있는지 확인
			checkWord(flag);
		}

		for (int i = idx; i < 26; i++) {
			// a, c, i, n, t를 빼기 위한 조건
			if ((flag & 1 << i) != 0)
				continue;
			comb(i + 1, cnt + 1, flag | 1 << i);
		}
	}

	/**
	 * 입력 받은 단어와 flag와 비교해 단어가 포함 되어 있다면 cnt++, 아니면 넘기기
	 * 
	 * @param flag 입력 받은 단어와 비교할 조합이 담긴(?) 변수
	 */
	private static void checkWord(int flag) {
		int cnt = 0;
		top: for (String s : word) {
			for (int i = 0; i < s.length(); i++) {
				if ((flag & 1 << (s.charAt(i) - 'a')) == 0)
					continue top;
			}
			cnt++;
		}

//		for (int w : word) {
//			if ((flag & w) != w)
//				continue;
//			cnt++;
//		}

		max = Math.max(max, cnt);
	}
}
