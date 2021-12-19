/**
* 메모리: 11928 KB, 시간: 84 ms
* 2021.12.19
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static int N, map[];

	public static void main(String[] args) throws Exception {
		input();

		System.out.println(getMinCnt());

	}

	private static int getMinCnt() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { 0, 0 }); // 위치, 이동수

		boolean[] visited = new boolean[N];
		visited[0] = true;

		int now, cnt, num, next;
		while (!que.isEmpty()) {
			now = que.peek()[0];
			cnt = que.poll()[1];
			
			// 맨 끝으로 갔다면 이동수 리턴
			if (now == N - 1) {
				return cnt;
			}

			// 갈 수 있는 칸으로 이둥
			for (int i = 1; i <= map[now]; i++) {
				next = now + i;
				// 범위를 벗어나면 끝내기
				if (next >= N) {
					break;
				}

				if (visited[next]) {
					continue;
				}

				visited[next] = true;
				que.offer(new int[] { next, cnt + 1 });
			}
		}

		return -1;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
	}
}