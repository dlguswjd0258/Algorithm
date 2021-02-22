package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 + 4 - (3 + 4) - (2 + 5)

public class B1541_잃어버린괄호 {

	static int res;
	static boolean minus;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer num = new StringTokenizer(s, "+-");
		StringTokenizer oper = new StringTokenizer(s, "1234567890");

		// 첫번째 숫자로 초기화
		res = Integer.parseInt(num.nextToken());

		// 연산자가 없을 때까지 num과 oper를 번갈아 가며 확인한다.
		while (oper.hasMoreTokens()) {
			if (oper.nextToken().equals("-")) {
				minus = true;
				break;
			}

			// 앞에 마이너스가 나오지 않았다면 더하기
			res += Integer.parseInt(num.nextToken());
		}

		// 마이너스가 나왔다면 다 빼기
		while (num.hasMoreTokens())
			res -= Integer.parseInt(num.nextToken());

		System.out.println(res);
	}

}
