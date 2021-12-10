/**
* 메모리: 11932 KB, 시간: 80 ms
* 2021.12.10
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, P[];

	public static void main(String[] args) throws Exception {
		init();

		int max = 0;
		int idx = 0;
		for (int i = 0; i < N && M - i - 1 >= 0 ; i++) {
			int earning = P[M - i - 1] * (i + 1);

			if (max <= earning) {
				idx = M - i - 1;
				max = earning;
			}
		}

		System.out.println(P[idx] + " " + max);

	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		P = new int[M];
		for (int i = 0; i < M; i++) {
			P[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(P);
	}
}