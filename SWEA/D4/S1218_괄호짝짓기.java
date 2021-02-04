package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 짝짓기
public class S1218_괄호짝짓기 {

	static int N;
	static String s;
	static boolean isRight;
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			// 입력 받기
			N = Integer.parseInt(in.readLine());
			s = in.readLine();

			// 여는 괄호는 스택에 넣고 닫는 괄호를 만나면 짝이 맞는지 판단
			isRight = true;
			char now;
			for (int i = 0; i < N; i++) {
				now = s.charAt(i);
				// 여는 괄호라면
				if (now == '(' || now == '[' || now == '{' || now == '<') {
					stack.push(now);
				} else { // 닫는 괄호라면
					if (stack.isEmpty() || !match(stack.pop(), now)) {
						isRight = false;
						break;
					}

				}
			}

			if (stack.isEmpty() && isRight) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}

			// 테스트 케이스 끝날 때마다 stack 초기화
			stack.clear();

		}

		System.out.println(sb.toString());

	}

	private static boolean match(char pre, char now) {
		if ((pre == '(' && now == ')') || (pre == '[' && now == ']') || (pre == '{' && now == '}')
				|| (pre == '<' && now == '>')) {
			return true;
		}

		return false;
	}
}
