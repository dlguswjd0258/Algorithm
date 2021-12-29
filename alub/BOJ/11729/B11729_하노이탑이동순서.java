/**
* 메모리: 42028 KB, 시간: 256 ms
* 2021.12.29
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		sb.append((int) Math.pow(2, N) - 1).append("\n");
		hanoi(1, 3, 2, N);
		System.out.println(sb.toString());
	}

	private static void hanoi(int from, int to, int mid, int cnt) {
		if (cnt == 0) {
			return;
		}

		hanoi(from, mid, to, cnt - 1);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(mid, to, from, cnt - 1);
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}