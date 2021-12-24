/**
* 메모리: 11508 KB, 시간: 80 ms
* 2021.12.25
* by Alub
*/
import java.io.*;

public class Main {

	static int X;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(in.readLine());
		System.out.println(getFraction());
	}

	private static String getFraction() {
		StringBuilder sb = new StringBuilder();
		// 분자 분모 합이 같은 분수의 개수는 1씩 커진다.
		// 뺄 개수는 1부터 합은 2부터 시작
		// 개수를 빼면서 X번째의 분자 분모의 합을 찾는다
		int cnt = 1;
		while (X - cnt > 0) {
			X -= cnt++;
		}

		int i, j; // 분자 분모
		if ((cnt + 1) % 2 == 0) {
			// 합이 짝수일 때 분모가 1
			j = 1;
			i = cnt;
			while (X-- > 1 && i > 1) {
				i--;
				j++;
			}

			sb.append(i + "/" + j + "\n");
		} else {
			// 합이 홀수일 때 분자가 1
			i = 1;
			j = cnt;
			while (X-- > 1 && j > 1) {
				i++;
				j--;
			}

			sb.append(i + "/" + j + "\n");

		}

		return sb.toString();
	}
}