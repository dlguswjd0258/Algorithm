/**
* 메모리: 11672 KB, 시간: 96 ms
* 2021.12.28
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, C, W, maxLen, woods[];

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getMaxPrice());
	}

	private static long getMaxPrice() {
		long max = 0;

		// 1부터 max까지 잘랐을 때 가격 구하기
		long price;
		for (int i = 1; i <= maxLen; i++) {
			price = 0;
			for (int j = 0; j < N; j++) {
				// 나무 길이가 자르는 길이가 보다 작으면 pass
				if (woods[j] < i) {
					continue;
				}

				// 나무 잘랐을 때 얻을 수 있는 가격 더하기
                long now = getPrice(i, woods[j]);
                
                // 적자면 팔지 않는다.
				price += now > 0 ? now : 0;
			}

			max = Math.max(max, price);
		}

		return max;
	}

	private static long getPrice(int cutLen, int wood) {
		// 자르는 길이로 나눈 몫 = 나무 개수, 자른 횟수 + 1
		int cnt = wood / cutLen;
		// 벌수 있는 돈 - 나무 자를 때 쓴 돈
		return (cnt * cutLen * W) - ((wood % cutLen == 0 ? cnt - 1 : cnt) * C);
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		woods = new int[N];
		for (int i = 0; i < N; i++) {
			woods[i] = Integer.parseInt(in.readLine());
			maxLen = Math.max(maxLen, woods[i]);
		}

	}
}