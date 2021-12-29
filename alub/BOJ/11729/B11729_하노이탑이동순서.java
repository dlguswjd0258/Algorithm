/**
* 메모리: 74820 KB, 시간: 284 ms
* 2021.12.29
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, k;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		input();
		hanoi(1, 3, 2, 0);
		System.out.println(k);
		System.out.println(sb.toString());
	}

	private static void hanoi(int from, int to, int mid, int cnt) {
		if (cnt == N) {
			return;
		}

		hanoi(from, mid, to, cnt + 1);
		k++;
		sb.append(from + " " + to + "\n");
		hanoi(mid, to, from, cnt + 1);
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	}
}