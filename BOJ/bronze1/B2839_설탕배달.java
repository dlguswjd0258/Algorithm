package bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2839_설탕배달 {

	static int N, min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());

		int res = 0; // 봉지수
		// 5로 나뉠 때 까지 3을 빼면다. 
		while (N % 5 > 0) { 
			N -= 3;
			res++;
			
//			N이 음수가 되면 불가능한 배달 
			if (N < 0) {
				res = -1;
				break;
			}
		}

		System.out.println(res + N / 5);
	}
}
