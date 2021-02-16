package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class S5215_햄버거다이어트 {

	static int T, N, L, max;
	static int[][] info;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		int calSum, scSum;
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			info = new int[N][2];

			// 데어터 받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				info[i][0] = Integer.parseInt(st.nextToken()); // score
				info[i][1] = Integer.parseInt(st.nextToken()); // cal
			}

			max = 0;
			// 비트마스크를 이용해 점수 구하기
			for (int i = 0, end = 1 << N; i < end; i++) {
				scSum = 0;
				calSum = 0;
				for (int j = 0; j < N; j++) {
					// 선택 됐을 때
					if ((i & 1 << j) != 0) {
						scSum += info[j][0];
						calSum += info[j][1];
					}

					// 더 계산할 필요 없을 때
					if (calSum >= L)
						break;
				}

				if (calSum < L) {
					max = Math.max(max, scSum);
				}
			}

			// 재귀함수를 이용해 최대 점수 구하기
//			subSet(0, 0, 0);

			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

//	private static void subSet(int idx, int scSum, int calSum) {
//		if (idx == N) {
//			if (calSum < L) {
//				max = Math.max(max, scSum);
//			}
//			return;
//		}
//
//		// 칼로리가 넘어가면 더이상 할 필요가 없다.
//		if (calSum >= L) {
//			return;
//		}
//		
//		// 선택 했을 때
//		subSet(idx+1,scSum+info[idx][0], calSum +info[idx][1]);
//
//		// 선택 안했을 때
//		subSet(idx+1,scSum, calSum);
//	}
}
