package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA D4 1233 사칙연산
public class S1233_사칙연산 {

	static int N;
	static char sec;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		int res; // 연산 가능 여부;
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine());

			// 데이터 입력 받으면서 연산 가능한지 확인하기
			res = 1;
			while (N-- > 0) {
				st = new StringTokenizer(in.readLine());

				// 이미 연산 불가능이라고 판단했다면 더 이상 판단 하지 않기
				if (res == 0)
					continue;

				st.nextToken();
				sec = st.nextToken().charAt(0);
				// 현재 노드의 알파벳이 연산자일 때
//				if (sec == '+' || sec == '-' || sec == '*' || sec == '/') {
				if (sec < '0') {
					// 자식 노드가 두 개 있으면 연산 가능
					if (st.countTokens() == 2)
						continue;
					// 자식 노드가 하나라도 없다면 연산 불가
					res = 0;
				} else { // 숫자일 때
					// 자식 노드가 없다면 연산 가능
					if (!st.hasMoreTokens())
						continue;
					// 자식 노드가 있다면 연산 불가
					res = 0;
				}
			}

			sb.append(res).append("\n");
		}

		System.out.println(sb.toString());
	}
}
