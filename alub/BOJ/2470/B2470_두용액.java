/**
* 메모리: 31744 KB, 시간: 288 ms
* 2021.12.26
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
정렬하고
앞과 뒤에서부터 더해보고
음수면 앞부분 ++
양수면 뒷부분 --
 */
public class Main {

	static int N, num[];

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getRes());
	}

	private static String getRes() {
		Arrays.sort(num);

		int front = 0, rear = N - 1, min = Integer.MAX_VALUE;
		int[] res = new int[2];
		while (front < rear) {
			int sum = num[front] + num[rear];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				res = new int[] { num[front], num[rear] };
			}

			if (sum > 0) {
				rear--;
			} else if (sum < 0) {
				front++;
			} else {
				return num[front] + " " + num[rear];
			}
		}
		return res[0] + " " + res[1];
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		num = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
}