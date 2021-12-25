/**
* 메모리: 11488 KB, 시간: 80 ms
* 2021.12.25
* by Alub
*/
import java.io.*;

public class Main {

	static int first;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getCycleLength());
	}

	private static int getCycleLength() {
		int len = 0;

		int num = first;
		do {
			int a = num / 10;
			int b = num % 10;
			int sum = a + b;
			num = b * 10 + (sum % 10);
			len++;
		} while (num != first);

		return len;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		first = Integer.parseInt(in.readLine());
		if (first < 10) {
			first *= 10;
		}
	}
}