/**
* 메모리: 59992 KB, 시간: 184 ms
* 2021.12.17
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;

	public static void main(String[] args) throws Exception {
		init();

		int min = getMinMove();
		if (min < 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(min);
		}
	}

	private static int getMinMove() {
		// 이미 스타트링크 층이라면 0 리턴
		if (S == G) {
			return 0;
		}

		// 위치 이동 수
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { S, 0 });

		boolean[] visited = new boolean[F + 1];
		visited[S] = true;

		int now, nextU, nextD, move;
		while (!que.isEmpty()) {
			now = que.peek()[0];
			move = que.poll()[1];

			// 위로 올라가기
			nextU = now + U;
			// 아래로 내려가기
			nextD = now - D;

			// 현재 층에서 위로 가거나 아래로 갔을 때 스타트링크 층이라면 move + 1 리턴
			if (nextU == G || nextD == G) {
				return move + 1;
			}

			// 위로 갈 수 있고 가본적 없다면 que에 담기
			if (isIn(nextU) && !visited[nextU]) {
				visited[nextU] = true;
				que.offer(new int[] {nextU, move+1});
			}
			
			// 아래로로 갈 수 있고 가본적 없다면 que에 담기
			if (isIn(nextD) && !visited[nextD]) {
				visited[nextD] = true;
				que.offer(new int[] {nextD, move+1});
			}
		}

		return -1;
	}

	private static boolean isIn(int floor) {
		return floor > 0 && floor <= F;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

	}
}