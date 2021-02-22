package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1935_후위표기식2 {

	static int N;
	static double[] num;
	static Stack<Double> stack = new Stack<>(); // 숫자 담을 스택
	static Queue<Character> que = new LinkedList<Character>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		num = new double[N];

		// 표기식 que에 담기
		String exp = in.readLine().trim();
		for (int i = 0; i < exp.length(); i++) {
			que.offer(exp.charAt(i));
		}

		// 피연산자 숫자 받기
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(in.readLine());
		}

		// 후위 표기식 계산하기
		char c;
		while (!que.isEmpty()) {
			c = que.poll();

			// 연산자라면 계산하기
			if (c == '*' || c == '/' || c == '+' || c == '-') {
				operate(c);
				continue;
			}

			// 피연산자라면 stack에 숫자 저장
			stack.push(num[(c - 'A')]);
		}

		System.out.printf("%.2f", stack.pop());
	}

	private static void operate(char c) {
		// 스택이니까 뒤에꺼 먼저 빼기
		double next = stack.pop();
		double pre = stack.pop();

		switch (c) {
		case '*':
			stack.push(pre * next);
			break;
		case '/':
			stack.push(pre / next);
			break;
		case '+':
			stack.push(pre + next);
			break;
		case '-':
			stack.push(pre - next);
			break;
		}
	}
}
