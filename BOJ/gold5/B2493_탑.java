package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ gold5 2493 탑
public class B2493_탑 {

	static int N, height;
	static Stack<int[]> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pre = null;
		for (int i = 1; i <= N; i++) {
			height = Integer.parseInt(st.nextToken());

			// stack이 비어 있지 않고 꺼낸 건물의 높이가 지금 건물의 높이보다 작으면 계속 꺼내기
			while (!stack.isEmpty()) {
				pre = stack.pop();
				if (pre[0] >= height) {
					stack.push(pre);
					break;
				}
			}

			// 스택이 비었을 때 0으로 판단하고 stack에 집어 넣고 넘기기
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new int[] { height, i });
				continue;
			}

			// 수신한 건물의 위치 출력 후 stack에 현재 건물 넣기
			sb.append(pre[1]).append(" ");
			stack.push(new int[] { height, i });

		}
		
		System.out.println(sb.toString());
	}
}
