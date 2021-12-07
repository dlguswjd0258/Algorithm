/**
* 메모리: 22168 KB, 시간: 200 ms
* 2021.12.07
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {

	static int N, num[];

	public static void main(String[] args) throws Exception {
		init();

		System.out.println(getMaxSum());
	}

	private static int getMaxSum() {
		int maxSum = num[0];

		// 해당 인덱스의 숫자를 포함했을 때 큰 연속합
		int maxNum[] = new int[N];
		maxNum[0] = num[0];
		for (int i = 1; i < N; i++) {
			// i-1번째의 큰 숫자에 i번째를 더한 값과 i번째를 비교해서 i번째 숫자가 포함된 큰 연속합 구하기
			maxNum[i] = Math.max(maxNum[i - 1] + num[i], num[i]);

			// 그 중 가장 큰 연속합 구하기
			maxSum = Math.max(maxSum, maxNum[i]);
		}

		return maxSum;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
}