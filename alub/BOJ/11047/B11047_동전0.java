/**
* 메모리: 11536 KB, 시간: 76 ms
* 2021.12.06
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, worth[];

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(getMinCnt());
	}

	private static int getMinCnt() {
		int cnt = 0;

		// K가 0이 될때까지 제일 큰 가치부터 나누면서 개수 구하기
		while (K > 0) {
			N--;
			cnt += K / worth[N];
			K %= worth[N];
		}

		return cnt;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		worth = new int[N];
		for (int i = 0; i < N; i++) {
			worth[i] = Integer.parseInt(in.readLine());
		}

	}
}