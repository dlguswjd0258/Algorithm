/**
* 메모리: 11784 KB, 시간: 76 ms
* 2022.01.10
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, min;
	static boolean relation[][];
	static List<Integer>[] scores;

	public static void main(String[] args) throws Exception {
		input();

		init();

		getEachScore();

		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(scores[min].size()).append("\n");
		for (int score : scores[min]) {
			sb.append(score).append(" ");
		}
		System.out.println(sb.toString());

	}

	private static void getEachScore() {
		for (int i = 1; i <= N; i++) {
			int score = getScore(i);
			scores[score].add(i);
			
			// 가장 작은 점수 구하기
			min = Math.min(min, score);
		}
	}

	private static int getScore(int idx) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(idx);

		// 방문체크
		boolean[] checked = new boolean[N + 1];
        checked[idx] = true;

		int size, score = -1;
		while (!que.isEmpty()) {
			size = que.size();
			score++;
			while (size-- > 0) {
				idx = que.poll();

				for (int i = 1; i <= N; i++) {
					if (!relation[idx][i] || checked[i]) {
						continue;
					}
					
					// 연결되어 있고 방문하지 않았다면 que에 담기
					checked[i] = true;
					que.offer(i);
				}
			}
		}

		return score;
	}

	private static void init() {
		min = N;
		scores = new List[N];
		for (int i = 1; i < N; i++) {
			scores[i] = new ArrayList<>();
		}
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		relation = new boolean[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while (a != -1) {
			relation[a][b] = relation[b][a] = true;
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
	}
}