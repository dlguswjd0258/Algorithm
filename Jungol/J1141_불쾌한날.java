

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Jungol 1141 불쾌한 날
public class J1141_불쾌한날 {

	static int N, h;
	static long res;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			h = Integer.parseInt(br.readLine());

			// 현재 소를 볼 수 있는 소들만 남겨 놓기
			while (!stack.isEmpty() && stack.peek() <= h) {
				stack.pop();
			}

			// 비어 있지 않다면 스택 사이즈만큼 더하고 넣기 => 스택이 비었다면 0을 더함
			res += stack.size();
			stack.push(h);
		}

		System.out.println(res);
	}
}
