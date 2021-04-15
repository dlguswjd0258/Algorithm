package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3289_서로소집합 {

	static int parents[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int n, m;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			// 대표자 초기화
			parents = new int[n + 1];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				switch (Integer.parseInt(st.nextToken())) {
				case 0: // 원소 합치기
					unionFind(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 1: // 같은 집합의 원소인지 확인하기
					sb.append(findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken())) ? 1
							: 0);
					break;
				}
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static boolean unionFind(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB)
			return false;

		parents[rootB] = rootA;
		return true;
	}

	private static int findSet(int a) {
		// 대표자가 0이면 대표자를 자신으로 설정.
		if (parents[a] == 0 || parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}
}
