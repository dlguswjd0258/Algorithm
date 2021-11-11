/*
* 메모리: 35564 KB, 시간: 464 ms
* 타이머 시간: null
* 2021.11.11
* by Alub
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, nowR, nowC, out;
	static int[] dr = { 0, 1, 0, -1 }, dc = { -1, 0, 1, 0 }; // 좌 하 우 상
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// 초기화
		init();

		// 격자의 밖으로 나간 모래의 양 찾기
		int dir = -1; // 토네이도가 이동한 방향
		do {
			// 토네이도가 이동할 위치 찾기
			dir = findNext(dir);
			visited[nowR][nowC] = true;

			// 모래 이동하면서 밖으로 나간 모래 구하기
			if (map[nowR][nowC] != 0) {
				moveSand(dir);
			}

		} while (!isDone());
		
		System.out.println(out);

	}

	private static void moveSand(int dir) {
		int remain = map[nowR][nowC];
		int sand = 0;

		// 5% 위치에 모래 옮기기
		int r = nowR + dr[dir] * 2;
		int c = nowC + dc[dir] * 2;
		sand = (int) (map[nowR][nowC] * 0.05);
		remain -= sand;
		move(r, c, sand);

		for (int i = 1; i < 4; i+=2) {
			// 7% 위치에 모래 옮기기
			r = nowR + dr[(dir + i) % 4];
			c = nowC + dc[(dir + i) % 4];
			sand = (int) (map[nowR][nowC] * 0.07);
			remain -= sand;
			move(r, c, sand);
			
			// 10% 위치에 모래 옮기기
			sand = (int) (map[nowR][nowC] * 0.1);
			remain -= sand;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			move(nr, nc, sand);
			
			// 2% 위치
			nr = r + dr[(dir + i) % 4];
			nc = c + dc[(dir + i) % 4];
			sand = (int) (map[nowR][nowC] * 0.02);
			remain -= sand;
			move(nr, nc, sand);
			
			// 1% 위치
			nr = r + dr[(dir + 2) % 4];
			nc = c + dc[(dir + 2) % 4];
			sand = (int) (map[nowR][nowC] * 0.01);
			remain -= sand;
			move(nr, nc, sand);
		}
		
		// 남은 모래 다 옮기기
		r = nowR + dr[dir];
		c = nowC + dc[dir];
		move(r, c, remain);
		
		map[nowR][nowC] = 0;
	}

	private static void move(int r, int c, int sand) {
		if (isIn(r, c)) {
			map[r][c] += sand; 
		} else {
			out += sand;
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static int findNext(int dir) {
		// 첫 시작은 왼쪽부터
		if (dir == -1) {
			nowR += dr[0];
			nowC += dc[0];
			return 0;
		}

		// 다음으로 꺾어야 하는 방향
		int next = (dir + 1) % 4;
		int nr = nowR + dr[next];
		int nc = nowC + dc[next];

		// 꺾었는데 이미 방문한 방향이면 다시 원래 방향으로 이동
		if (visited[nr][nc]) {
			next = dir;
		}

		nowR += dr[next];
		nowC += dc[next];

		return next;
	}

	private static void init() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		N = Integer.parseInt(in.readLine());

		// 지도 그리기
		map = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫 시작 위치
		nowR = N / 2;
		nowC = N / 2;

		// 토네이도 방문 초기화
		visited = new boolean[N][N];
		visited[nowR][nowC] = true;
	}

	private static boolean isDone() {
		return nowR == 0 && nowC == 0;
	}

}