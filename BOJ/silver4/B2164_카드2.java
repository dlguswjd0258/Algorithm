package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2 {
	
	static int N;
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// 순서대로 숫자 넣기
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		while (que.size() > 1) {
			// 제일 위 카드 버리기
			que.poll();
			// 위에 카드 아래로 옮기기
			que.offer(que.poll());
		}

		// 제일 마지막에 남는 카드 번호 출력
		System.out.println(que.poll());
	}

}
