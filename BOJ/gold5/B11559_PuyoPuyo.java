package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 뿌요뿌요
 * R: 빨강, G: 초록, B: 파랑, P: 보라, Y: 노랑
 * 12줄씩 6개 문자
 * 
 * 규칙
 * 1. 중력의 영향을 받아 바닥이나 다른 뿌요뿌요가 나올 때까지 아래로 떨어진다.
 * 2. 놓고 난 후, 같은 색 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. = 1연쇄
 * 3. 없어진 뿌요 위에 다른 뿌요들이 있다면 중력의 영향으로 차례대로 떨어진다.
 * 4. 다시 2번 반복
 * 5. 터질 뿌요가 여러개더라도 연쇄는 1번으로 여긴다.
 */
public class B11559_PuyoPuyo {

	static final int R = 12, C = 6;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int res;
	static char[][] map = new char[R][C];
	static boolean[][] visited = new boolean[R][C];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// map 정보 받기
		for (int i = 0; i < R; i++) {
			map[i] = (in.readLine().trim()).toCharArray();
		}

		// 연쇄가 일어났다면 맵 정리
		while (isRemovedPuyo()) {
			visited = new boolean[R][C];
			res++;
			// 뿌요 내리기
			downPuyo();
		}

		System.out.println(res);
	}

	private static void downPuyo() {
		// 아래부터 빈 공간을 찾고 그 위의 뿌요를 찾아 swap
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
		boolean flag = false; // 제거한 뿌요가 있는지

		// 1. 맵 천체를 확인하며 뿌요를 찾았다면 없앨 수 있다면 없애기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 방문 여부
				visited[i][j] = true;

				// 빈공간은 넘어가기
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
		// 주변 같은 puyo 찾아오기
		List<int[]> puyos = findAroundSamePuyo(r, c, color);

		// 4개 이상이면 제거하기
		if (puyos.size() >= 4) {
			for (int[] puyo : puyos) {
				map[puyo[0]][puyo[1]] = '.';
			}
			return true;
		}

		return false;
	}

	// 현재 찾고자 하는 뿌요와 같은 뿌요 bfs로 찾기
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

				// 맵 밖으로 나가거나
				// 이미 확인했던 위치거나
				// 색이 다르다면
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
