package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//SWEA D4 1223 계산기2
public class S1223_계산기 {

	static int N;
	static char now;
	static String s;
	static Stack<Integer> numbers = new Stack<>();
	static Stack<Character> opers = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());

			// 후위식으로 만들면서 계산하기
			// 우선순위 : * > +
			s = br.readLine();
			for (int i = 0; i < N; i++) {
				now = s.charAt(i);
				// 현재보다 우선순위가 높거나 같은 연산자를 만나면 opers에 담긴 연산자 계산하기
				// 1번 메모리 좀 더 먹는다.
//				if (now == '*') {
//					while (!opers.isEmpty() && opers.peek() == '*') {
//						numbers.push(calculation(opers.pop()));
//					}
//					opers.push(now);
//				} else if (now == '+') {
//					while (!opers.isEmpty()) {
//						numbers.push(calculation(opers.pop()));
//					}
//					opers.push(now);
//				}else {
//					numbers.push(now - '0');
//				}
				
				// 2번
				if (now == '*' || now == '+') {
					while (!opers.isEmpty() && opers.peek() <= now) { // 아스키코드를 보면 * < + 이므로
						numbers.push(calculation(opers.pop()));
					}
					opers.push(now);
				}else {
					numbers.push(now - '0');
				}
			}

			// 남은 연산 마저 하기
			while (!opers.isEmpty()) {
				numbers.push(calculation(opers.pop()));
			}

			sb.append(numbers.pop()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int calculation(char oper) {
		int p = numbers.pop();
		int n = numbers.pop();

		switch (oper) {
		case '*':
			return n * p;
		default:
			return n + p;
		}
	}

}

//#1 28134
//#2 195767
//#3 4293
//#4 1592
//#5 477326
//#6 45647
//#7 102951
//#8 6548
//#9 1394
//#10 4285
