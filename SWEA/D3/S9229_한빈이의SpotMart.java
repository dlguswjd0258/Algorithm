package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA D3 9229 한빈이의 spot mart
// 조합 nC2
public class S9229_한빈이의SpotMart {

	static int T, N, M, max;
	static int[] weight;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			weight = new int[N];

			// 무게 입력 받기
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			// 조합으로 max값 구하기
			max = -1;
			combination(0, 0, 0);
			sb.append(max).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void combination(int idx, int cnt, int w) {
		// 기저조건 : 2개 선택했으면 무게 확인하고 return
		if (cnt == 2) {
			// 제한 무게 이하인 것들만 max 비교
			if (w <= M)
				max = Math.max(max, w);
			return;
		}

		for (int i = idx; i < N; i++) {
			combination(i + 1, cnt + 1, w + weight[i]);
		}
	}
}
