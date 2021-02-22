package gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1167_트리의지름 {
	static ArrayList<int[]>[] adList;
	static int N, node, max;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adList = new ArrayList[N];

		StringTokenizer st;
		int[] arr;

		// 1.데이터 입력 받기
		for (int i = 0; i < N; i++) {
			adList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			while (st.countTokens() != 1) {
				arr = new int[2];
				arr[0] = Integer.parseInt(st.nextToken()) - 1;
				arr[1] = Integer.parseInt(st.nextToken());
				adList[p].add(arr);
			}
		}

		// 2. DFS로 최대 거리의 정점 구하기
		visit = new boolean[N];
		DFS(node, 0);

		// 3. 구한 정점으로 최대 거리 구하기
		visit = new boolean[N];
		DFS(node, 0);

		System.out.println(max);

	}

	private static void DFS(int p, int sum) {
		if (max < sum) {
			max = sum;
			node = p;
		}
		for (int[] is : adList[p]) {
			if (!visit[is[0]] && is[1] != 0) {
				visit[is[0]] = true;
				DFS(is[0], sum + is[1]);
				visit[is[0]] = false;
			}
		}
	}

}
