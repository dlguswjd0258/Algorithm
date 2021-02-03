package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1873_상호의배틀필드 {

	static int T, H, W, r, c, d;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; // 상 하 좌 우
	static char[] juncha = { '^', 'v', '<', '>' };
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		char temp;
		String s;
		int end;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			// 1. 데이터 받기
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				s = br.readLine();
				for (int j = 0; j < W; j++) {
					temp = s.charAt(j);
					map[i][j] = temp;
					// 1-1. 전차 방향, 위치 저장하기
					if (temp == '^' || temp == 'v' || temp == '<' || temp == '>') {
						r = i;
						c = j;
						changeDir(temp);
					}
				}
			}

			// 2. 주어진 명령 처리하기
			end = Integer.parseInt(br.readLine());
			s = br.readLine();
			for (int i = 0; i < end; i++) {
				switch (s.charAt(i)) {
				case 'S':
					// 포탄 쐈을 때
					shoot(r + dr[d], c + dc[d]);
					break;

				default:
					// 이동할 때 방향 바꾸고 이동
					changeDir(s.charAt(i));
					move(r + dr[d], c + dc[d]);
					break;
				}
			}

			// 전차 그리기
			map[r][c] = juncha[d];

			for (char[] h : map) {
				for (char w : h) {
					sb.append(w);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void move(int nr, int nc) {
		if (isIn(nr, nc) && map[nr][nc] == '.') {
			map[r][c] = '.';
			r = nr;
			c = nc;
		}
	}

	private static void shoot(int nr, int nc) {
		// 맵 밖이거나 강철을 만나면 아무일도 일어나지 않음
		if (!isIn(nr, nc) || map[nr][nc] == '#')
			return;

		// 벽돌 벽을 만나면 평지로 되고 포탄 소멸
		if (map[nr][nc] == '*') {
			map[nr][nc] = '.';
			return;
		}

		shoot(nr + dr[d], nc + dc[d]);
	}

	private static void changeDir(char dir) {
		if (dir == 'U' || dir == '^') {
			d = 0;
		} else if (dir == 'D' || dir == 'v') {
			d = 1;
		} else if (dir == 'L' || dir == '<') {
			d = 2;
		} else if (dir == 'R' || dir == '>') {
			d = 3;
		}
	}

	private static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < H && nc >= 0 && nc < W)
			return true;
		return false;
	}

}