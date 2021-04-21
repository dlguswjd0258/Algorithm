package gold1;

import java.io.*;
import java.util.*;

public class B1194_달이차오른다가자 {
	static int N, M, r, c;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		String s;
		for (int i = 0; i < N; i++) {
			s = in.readLine();
			map[i] = s.toCharArray();
			// 민식이 위치 저장하기
			if (s.contains("0")) {
				r = i;
				c = s.indexOf("0");
			}
		}

		System.out.println(getMoveCnt());
	}

	private static int getMoveCnt() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { r, c, 0, 0 }); // r, c, 이동횟수, 가지고 있는 키

		// 방문 체크는 키를 가지고 있고 없고를 다른 상황으로 보고 방문체크한다.
		// 키는 a~f까지 총 6개 있다.
		boolean[][][] visited = new boolean[N][M][1 << 6];

		int r, c, nr, nc, move, key, tempK;
		while (!que.isEmpty()) {
			r = que.peek()[0];
			c = que.peek()[1];
			move = que.peek()[2];
			key = que.poll()[3];
			
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				tempK = key;
				
				if (!canGo(nr, nc, tempK) || visited[nr][nc][tempK])
					continue;

				// 출구 만났을 때
				if (map[nr][nc] == '1')
					return move + 1;

				visited[nr][nc][tempK] = true;

				// 키 획득
				if (map[nr][nc] >= 'a')
					tempK |= (1 << (map[nr][nc] - 'a'));

				que.offer(new int[] { nr, nc, move + 1, tempK });
				visited[nr][nc][tempK] = true;
			}
		}

		return -1;
	}

	private static boolean canGo(int r, int c, int key) {
		// 맵밖이거나 벽을 만났는지
		if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] == '#')
			return false;

		// 문이라면 해당 키를 가지고 있는지
		if (map[r][c] >= 'A' && map[r][c] <= 'F') {
			return (key & (1 << (map[r][c] - 'A'))) != 0;
		}

		return true;
	}
}
