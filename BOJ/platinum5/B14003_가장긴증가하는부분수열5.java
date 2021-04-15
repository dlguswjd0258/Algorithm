package platinum5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// LIS
public class B14003_가장긴증가하는부분수열5 {

	static int N, arr[], res[], cnt[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		res = new int[N];
		int len = LIS();

		System.out.println(len);
		StringBuilder sb = new StringBuilder();
		// 뒤에서 부터 해당 길이와 일치하는 숫자 뽑아내기
		for (int i = N - 1; len > 0; i--) {
			if (len == cnt[i]) {
				sb.insert(0, arr[i]+" ");
				len--;
			}
		}
		System.out.println(sb.toString());
	}

	private static int LIS() {
		int size = 0, lis[] = new int[N]; // 각 숫자들을 오름차순으로 담을 배열
		cnt = new int[N]; 
		for (int i = 0; i < N; i++) {
			// 일치하는 숫자가 없으면 (-(있어야할 위치) - 1)값이 주어진다.
			int temp = Arrays.binarySearch(lis, 0, size, arr[i]);
			if (temp < 0)
				temp = Math.abs(temp) - 1;

			lis[temp] = arr[i];
			// 해당 위치의 숫자가 포함됐을 때 증가 부분 수열의 길이 저장
			cnt[i] = temp + 1;

			if (temp == size)
				size++;
		}

		return size;
	}
}
