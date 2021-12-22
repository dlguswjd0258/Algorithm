/**
* 메모리: 11940 KB, 시간: 88 ms
* 2021.12.22
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][] = new int[101][101];

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(countObscuredPainting());
	}

	private static int countObscuredPainting() {
		int cnt = 0;

		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (map[r][c] <= M) {
					continue;
				}
				cnt++;
			}
		}

		return cnt;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int r1, c1, r2, c2;
		while (N-- > 0) {
			// 입력을 받으면서 map에 종이가 올라간 개수 구하기
			st = new StringTokenizer(in.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());

			// 종이 올리기
			putPaper(r1, c1, r2, c2);

		}
	}

	private static void putPaper(int r1, int c1, int r2, int c2) {
		for (int r = r1; r <= r2; r++) {
			for (int c = c1; c <= c2; c++) {
				map[r][c]++;
			}
		}
	}
}