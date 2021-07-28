package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * �ѿ�ѿ�
 * R: ����, G: �ʷ�, B: �Ķ�, P: ����, Y: ���
 * 12�پ� 6�� ����
 * 
 * ��Ģ
 * 1. �߷��� ������ �޾� �ٴ��̳� �ٸ� �ѿ�ѿ䰡 ���� ������ �Ʒ��� ��������.
 * 2. ���� �� ��, ���� �� 4�� �̻� �����¿�� ����Ǿ� ������ ����� ���� �� �ѿ���� �Ѳ����� ��������. = 1����
 * 3. ������ �ѿ� ���� �ٸ� �ѿ���� �ִٸ� �߷��� �������� ���ʴ�� ��������.
 * 4. �ٽ� 2�� �ݺ�
 * 5. ���� �ѿ䰡 ���������� ����� 1������ �����.
 */
public class B11559_PuyoPuyo {

	static final int R = 12, C = 6;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int res;
	static char[][] map = new char[R][C];
	static boolean[][] visited = new boolean[R][C];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// map ���� �ޱ�
		for (int i = 0; i < R; i++) {
			map[i] = (in.readLine().trim()).toCharArray();
		}

		// ���Ⱑ �Ͼ�ٸ� �� ����
		while (isRemovedPuyo()) {
			visited = new boolean[R][C];
			res++;
			// �ѿ� ������
			downPuyo();
		}

		System.out.println(res);
	}

	private static void downPuyo() {
		// �Ʒ����� �� ������ ã�� �� ���� �ѿ並 ã�� swap
		int empty;
		for (int c = 0; c < 6; c++) {
			empty = -1;
			for (int r = 11; r >= 0; r--) {
				if (empty == -1) {
					if (map[r][c] == '.')
						empty = r;
				} else {
					if (map[r][c] != '.') {
						// swap
						char temp = map[r][c];
						map[r][c] = map[empty][c];
						map[empty][c] = temp;
						empty--;
					}
				}
			}
		}
	}

	private static boolean isRemovedPuyo() {
		boolean flag = false; // ������ �ѿ䰡 �ִ���

		// 1. �� õü�� Ȯ���ϸ� �ѿ並 ã�Ҵٸ� ���� �� �ִٸ� ���ֱ�
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// �湮 ����
				visited[i][j] = true;

				// ������� �Ѿ��
				if (map[i][j] == '.')
					continue;

				if (removePuyo(i, j, map[i][j])) {
					flag = true;
				}
			}
		}

		return flag;
	}

	private static boolean removePuyo(int r, int c, char color) {
		// �ֺ� ���� puyo ã�ƿ���
		List<int[]> puyos = findAroundSamePuyo(r, c, color);

		// 4�� �̻��̸� �����ϱ�
		if (puyos.size() >= 4) {
			for (int[] puyo : puyos) {
				map[puyo[0]][puyo[1]] = '.';
			}
			return true;
		}

		return false;
	}

	// ���� ã���� �ϴ� �ѿ�� ���� �ѿ� bfs�� ã��
	private static List<int[]> findAroundSamePuyo(int r, int c, char color) {
		List<int[]> puyos = new ArrayList<>();
		puyos.add(new int[] { r, c });

		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { r, c });

		int nr, nc;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.poll()[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];

				// �� ������ �����ų�
				// �̹� Ȯ���ߴ� ��ġ�ų�
				// ���� �ٸ��ٸ�
				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] != color) {
					continue;
				}

				visited[nr][nc] = true;
				puyos.add(new int[] { nr, nc });
				que.offer(new int[] { nr, nc });

			}
		}

		return puyos;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
