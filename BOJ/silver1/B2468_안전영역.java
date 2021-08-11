package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
���� ���� ���� �ľ�
�� ������ �� ���� ����� �ʴ� ������ ������ �ִ�� ��� ����������� ����
���� �翡 ���� ������ ���� ���ϴ� ��� ������ ���� ����
���� ������ �ִ��� ��� ���ϱ�

 */
public class B2468_�������� {

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// �� ���� �ޱ�
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		map = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// �ִ� ���� ���ϱ�
				maxH = Math.max(maxH, map[i][j]);
				minH = Math.min(minH, map[i][j]);
			}
		}

		System.out.println(getMaxArea(maxH, minH-1));
	}

	private static int getMaxArea(int maxH, int minH) {
		int max = 0;

		while (minH < maxH) {
			// rain��ŭ �� ���� �� �������� ���ϰ� ��
			max = Math.max(max, getAreaNum(minH++));
		}

		return max;
	}

	private static int getAreaNum(int rain) {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// rain���� ���� ��ġ�ų� üũ�� ��ġ�� �ѱ��
				if (map[i][j] <= rain || visited[i][j])
					continue;

				// rain���� ���� ��ġ���� ����� ���� üũ
				visited[i][j] = true;
				checkArea(i, j, rain, visited);
				cnt++;
			}
		}
		return cnt;
	}

	// dfs
	private static void checkArea(int r, int c, int rain, boolean[][] visited) {
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if (!isIn(nr, nc) || map[nr][nc] <= rain || visited[nr][nc])
				continue;
			
			visited[nr][nc] = true;
			checkArea(nr, nc, rain, visited);
		}
	}

	// bfs
//	private static void checkArea(int r, int c, int rain, boolean[][] visited) {
//		Queue<int[]> que = new LinkedList<>();
//		que.offer(new int[] { r, c });
//		visited[r][c] = true;
//		
//		int nr, nc;
//		while (!que.isEmpty()) {
//			r = que.peek()[0];
//			c = que.poll()[1];
//
//			for (int i = 0; i < 4; i++) {
//				nr = r + dr[i];
//				nc = c + dc[i];
//
//				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] <= rain)
//					continue;
//
//				visited[nr][nc] = true;
//				que.offer(new int[] { nr, nc });
//			}
//		}
//	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
