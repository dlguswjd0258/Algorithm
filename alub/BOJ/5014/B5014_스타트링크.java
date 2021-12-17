/**
* 메모리: 60220 KB, 시간: 172 ms
* 2021.12.17
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, UnD[] = new int[2];

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

		int now, next, move;
		while (!que.isEmpty()) {
			now = que.peek()[0];
			move = que.poll()[1] + 1;

			for (int und : UnD) {
				next = now + und;
				// 다음 층이 스타트 링크가 있는 층이라면 move return
				if(next == G) {
					return move;
				}
				
                if(!isIn(next) || visited[next]){
                    continue;
                }
                
				// 다음 층에 갈 수 있고 간적 없으면 que에 추가
                visited[next] = true;
                que.offer(new int[] { next, move });
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
		UnD[0] = Integer.parseInt(st.nextToken()); // up
		UnD[1] = -Integer.parseInt(st.nextToken()); // down
	}

}