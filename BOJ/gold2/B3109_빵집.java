package gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ gold2 3109 빵집
public class B3109_빵집 {

	static boolean flag;
	static int R, C, cnt;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 데이터 입력 받기
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// map 그리기
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		// 첫 행부터 파이프 라인 그리기
		for (int r = 0; r < R; r++) {
			flag = false;
			setPipe(r, 0);
		}

		System.out.println(cnt);

	}

	private static void setPipe(int r, int c) {
		// 파이프 설치 완료
		if (c == C - 1) {
			cnt++;
			flag = true;
			return;
		}

		int nr, nc = c + 1;
		for (int i = -1; i <= 1; i++) {
			nr = r + i;
			// 갈 수 없는 길(벽,파이프)이면 return
			if (!canGo(nr, nc))
				continue;

			// 파이프를 설치 했다는 의미
			map[nr][nc] = '-';
			setPipe(nr, nc);

			// 최적의 파이프 설치를 끝냈다면 return;
			if (flag)
				return;

			// 다른애들도 못가는건 똑같아서 복구 안해도 됨..
//			map[nr][nc] = '.';
		}
	}

	private static boolean canGo(int r, int c) {
		return (r >= 0 && r < R) && map[r][c] == '.';
	}

}
