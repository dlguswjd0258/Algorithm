import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// jungol 1661 미로 탈출 로봇
public class J1661_미로탈출로봇 {

	static int N, M, r, c, nr, nc, ar, ac;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 }; // 상하좌우
	static int[][] map; // map이자 cnt
	static boolean[][] visit; // map이자 방문 체크 변수
	static Queue<Integer> que = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		st = new StringTokenizer(in.readLine());
		// 출발점과 도착점 저장
		c = Integer.parseInt(st.nextToken()) - 1;
		r = Integer.parseInt(st.nextToken()) - 1;
		ac = Integer.parseInt(st.nextToken()) - 1;
		ar = Integer.parseInt(st.nextToken()) - 1;

		
		//------------------------ 시작: cnt가 같은 위치들을 한번에 처리하고 cnt++하는 방법 -----------------
		// visit 그리기
		visit = new boolean[M][N];
		String s;
		for (int i = 0; i < M; i++) {
			s = in.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == '0')
					continue;
				
				// 벽을 방문한 곳이라고 생각하기
				visit[i][j] = true;
			}
		}

		// 출발점 방문 체크 및 큐 삽입
		visit[r][c] = true;
		que.offer(r);
		que.offer(c);

		// 큐에 아무것도 없을 때까지 미로 탐색
		int cnt = 0; // 이동 시간
		int size; // 큐 size;
		top: while (!que.isEmpty()) {
			size = que.size();
			// cnt가 같은 위치들 한번에 처리하기
			while (size > 0) {
				// 현재 위치 받기
				r = que.poll();
				c = que.poll();
				size -= 2;
				// 현재 위치가 도착 위치면 끝내기
				if (r == ar && c == ac) {
					break top;
				}
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];

					// 다음 위치가 map 벗어거나 방문했던 곳이라면 continue
					if (!isIn(nr, nc) || visit[nr][nc])
						continue;

					// 아니면 방문체크, 큐에 위치 저장
					visit[nr][nc] = true;
					que.offer(nr);
					que.offer(nc);
				}
			}
			cnt++;
		}

		System.out.println(cnt);
		//------------------------ 끝 : cnt가 같은 위치들을 한번에 처리하고 cnt++하는 방법 -----------------
		
		
		//------------------------ 시작: map을 방문체크와 시간 저장 -----------------
		// map 그리기
//		map = new int[M][N];
//		String s;
//		for (int i = 0; i < M; i++) {
//			s = in.readLine();
//			for (int j = 0; j < N; j++) {
//				map[i][j] = s.charAt(j) - '0';
//			}
//		}
//			
//
//		// 출발점 cnt 1로 초기화 및 큐 삽입
//		map[r][c] = 1;
//		que.offer(r);
//		que.offer(c);
//
//		// 큐에 아무것도 없을 때까지 미로 탐색
//		while (!que.isEmpty()) {
//			// 현재 위치 받기
//			r = que.poll();
//			c = que.poll();
//
//			// 현재 위치가 도착 위치면 끝내기
//			if (r == ar && c == ac) {
//				break;
//			}
//
//			for (int i = 0; i < 4; i++) {
//				nr = r + dr[i];
//				nc = c + dc[i];
//
//				// 다음 위치가 map 벗어거나 방문했던 곳이라면 continue
//				if (!isIn(nr, nc) || map[nr][nc] != 0)
//					continue;
//
//				// 아니면 방문체크, 큐에 위치 저장
//				map[nr][nc] = map[r][c] + 1;
//				que.offer(nr);
//				que.offer(nc);
//			}
//		}
//
//		System.out.println(map[ar][ac]-1);
		//------------------------ 끝: map을 방문체크와 시간 저장 -----------------
	}

	// map을 벗어나는지 판단
	private static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < M && nc >= 0 && nc < N)
			return true;
		return false;
	}

}
