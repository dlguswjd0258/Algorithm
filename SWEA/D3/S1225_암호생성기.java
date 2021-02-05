package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 암호생성기
public class S1225_암호생성기 {

	static int minus; 
	static Queue<Integer> que = new LinkedList<Integer>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			in.readLine();
			st = new StringTokenizer(in.readLine());

			// 데이터 받아서 큐에 넣기
			while (st.hasMoreTokens()) {
				que.offer(Integer.parseInt(st.nextToken()));
			}

			// 뺄 값이 다음 나올 값보다 크면 값 넣으면서 계산하기
			minus = 1; // 1부터 감소
			while (que.peek() > minus) {
				que.offer(que.poll() - minus);
				minus = minus % 5 + 1; // 5 % 5 + 1 = 1
			}

			// 종료하게 된 값을 빼기
			que.poll();
			while(!que.isEmpty()) {
				sb.append(que.poll()).append(" ");
			}
			// 마지막은 항상 0
			sb.append(0).append("\n");

			// 테스트 끝날 때 마다 que 초기화
			que.clear();
		}

		System.out.println(sb.toString());
	}
}
