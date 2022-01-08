/**
* 메모리: 41656 KB, 시간: 344 ms
* 2022.01.08
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {

	static int N, M, map[][];

	public static void main(String[] args) throws Exception {
		input();
		floydWarshall();
		printMap();
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 갈 수 없다면 0으로 출력
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void floydWarshall() {
		// 경유지
		for (int k = 1; k <= N; k++) {
			// 출발점
			for (int i = 1; i <= N; i++) {
				// 경유지를 거치지만 경로가 없을 때 pass
				if (i == k || map[i][k] == 0) {
					continue;
				}
				// 도착점
				for (int j = 1; j <= N; j++) {
					if (j == i || j == k || map[k][j] == 0) {
						continue;
					}

					if (map[i][j] == 0) {
						// 경유하는 방법밖에 없을 땐 경유 비용 저장
						map[i][j] = map[i][k] + map[k][j];
					} else {
						// 경유해서 가는게 더 빠른지 확인하고 저장
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}

				}
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		map = new int[N + 1][N + 1];
		// 같은 노선에 가격이 다를 수 있으므로 작은 비용 저장하기
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (map[a][b] != 0) {
				c = Math.min(map[a][b], c);
			}

			map[a][b] = c;
		}
	}
}