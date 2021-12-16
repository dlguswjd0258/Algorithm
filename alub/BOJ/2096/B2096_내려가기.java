/**
* 메모리: 54404 KB, 시간: 392 ms
* 2021.12.16
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] score, maxSum, minSum;

	public static void main(String[] args) throws Exception {
		init();

		calculateScore();

		int max = Math.max(maxSum[N - 1][0], Math.max(maxSum[N - 1][1], maxSum[N - 1][2]));
		int min = Math.min(minSum[N - 1][0], Math.min(minSum[N - 1][1], minSum[N - 1][2]));

		System.out.println(max + " " + min);
	}

	private static void calculateScore() {
		int max, min;
		// i번째를 선택한다면 i-1번째 중 합했을 때 작은 값 혹은 큰 값을 저장
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				max = 0;
				min = 1000000;
				// j를 선택하기 위해서 이전에 선택한 socore 위치는 j-1 ~ j+1
				for (int k = j - 1; k <= j + 1; k++) {
					if (!isIn(k)) {
						continue;
					}

					max = Math.max(max, maxSum[i - 1][k]);
					min = Math.min(min, minSum[i - 1][k]);
				}

				maxSum[i][j] = score[i][j] + max;
				minSum[i][j] = score[i][j] + min;
			}
		}
	}

	private static boolean isIn(int a) {
		return a >= 0 && a < 3;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		score = new int[N][3];
		maxSum = new int[N][3];
		minSum = new int[N][3];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxSum[0] = minSum[0] = score[0];

	}
}
