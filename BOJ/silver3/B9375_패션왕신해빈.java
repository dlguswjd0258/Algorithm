package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B9375_패션왕신해빈 {

	static int T, N;
	static Map<String, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		String s = null;
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				s = st.nextToken();
				map.put(s, map.getOrDefault(s, 0) + 1);
			}

			int cnt = 1;
			for (int i : map.values()) {
				// 각 종류별로 가지고 있는 개수에 +1을 해서 (종류별로 선택했을 때 선택하지 않았을 경우도 고려) 곱하기
				cnt *= (i + 1);
			}

			// 공집합은 빼고 출력
			sb.append(cnt - 1).append("\n");
			// 초기화
			map.clear();

		}
		System.out.println(sb.toString());
	}

}
