package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918_후위표기식 {

	static Stack<Character> oper = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine().trim();

		// 받은 입력값을 확인하면서 처리
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			// c가 '('연산자라면 무조건 oper에 넣기
			if (c == '(') {
				oper.push(c);
				continue;
			}

			// ')'라면 '(' 만날 때 까지 oper에 있는 연산자 res로 옮기고 '('버리기
			if (c == ')') {
				moveOperAll();
				continue;
			}
			
			// '*', '/'일 때 '+','-'인 것만 res로 옮기고 c는 oper에 넣기
			if (c == '*' || c == '/') {
				moveOperMD();
				oper.push(c);
				continue;
			}

			// '+'와 '-'는 '('만날 때 까지 oper에 있는 연산자 res로 옮기고 oper에 넣기
			if (c == '+' || c == '-') {
				moveOperPM();
				oper.push(c);
				continue;
			}
			
			// 피연산자일 때 출력에 넣기
			sb.append(c);
		}
		
		// 남은 연산자도 출력
		while(!oper.isEmpty()) {
			sb.append(oper.pop());
		}
		
		System.out.println(sb.toString());
	}

	/**
	 * '*', '/'일 때 '+','-'인 것만 res로 옮기기
	 */
	private static void moveOperMD() {
		while (!oper.isEmpty() && (oper.peek() == '*' || oper.peek() == '/')) {
			sb.append(oper.pop());
		}
	}

	/**
	 * '+', '-'일 때 '('만날 때 까지 혹은 비어 있을 때까지 oper에 있는 연산자 res로 옮기기
	 */
	private static void moveOperPM() {
		while (!oper.isEmpty() && oper.peek() != '(') {
			sb.append(oper.pop());
		}
	}

	/**
	 * ')' 연산자 일 때 '(' 만날 때 까지 oper에 있는 연산자 res로 옮기고 '('버리기
	 */
	private static void moveOperAll() {
		char c = oper.pop();
		while (c != '(') {
			sb.append(c);
			c = oper.pop(); // 마지막 '('는 어차피 버려도 되는 연산자라서 다시 넣지 않아도 된다.
		}
	}

}
