package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// KMP?
// 주어진 문자열에 Pn이 몇개 들어있는가
public class B5525_IOIOI {

	static int N, M;
	static String S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		S = in.readLine().trim();

		int res = 0; // 답
		// I로 시작하고 번갈아 가며 있으니 I로 시작하는지 보고 OI가 몇 번 반복되는지 cnt를 센다.
		// cnt가 N과 같거나 크면 res를 증가시킨다.
		int cnt;
		for (int i = 1; i < M - 1; i++) {
			if (S.charAt(i - 1) == 'I') {
				cnt=0;
				while (i < M-1 && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
					cnt++;
					i += 2;
					if(cnt >= N)
						res++;
				}
			}
		}
		
		System.out.println(res);
	}
}
