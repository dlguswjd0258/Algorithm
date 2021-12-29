/**
* 메모리: 11652 KB, 시간: 80 ms
* 2021.12.29
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] room;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getWoodsCnt());
	}

	private static int getWoodsCnt() {
		int cnt = 0;

		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;

				cnt++;
				visitWood(i, j, room[i][j], visited);
			}
		}

		return cnt;

	}

	private static void visitWood(int r, int c, char shape, boolean[][] visited) {
		if (!isIn(r, c) || room[r][c] != shape) {
			return;
		}

		visited[r][c] = true;
		if (shape == '-') {
			// 모양이 -면 오른쪽으로만 확인하며 같은 방문 체크
			visitWood(r, c + 1, shape, visited);
		} else {
			// 모양이 ㅣ면 아래로맨 확인하며 같은 모양 방문 체크
			visitWood(r + 1, c, shape, visited);
		}
	}

	private static boolean isIn(int r, int c) {
		return r < N && c < M;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		room = new char[N][];
		for (int i = 0; i < N; i++) {
			room[i] = in.readLine().toCharArray();
		}
	}
}