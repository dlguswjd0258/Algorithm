package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3234_준환이의양팔저울 {

	static int T, N, ans;
	static int[] choo;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			// 초기화
			ans = 0;
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());
			choo = new int[N];

			// 데이터 받기
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}

			// np 사용하므로 정렬
			Arrays.sort(choo);
			
			// 순열을 만들수 있다면 만들고 다 만들었다면 반복 끝
			do {
				// 현재 순열에서 가능한 경우의 수를 구한다. (첫 번째 추는 무조건 왼쪽에)
				addAns(1, 0, choo[0]);
			} while (np());

			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * 현재 순열에서 추를 순서대로 둘 때 오른쪽의 무게가 왼쪽보다 작은 경우의 수 세기
	 * @param idx 현재 순열의 idx
	 * @param right 현재 오른쪽 무게
	 * @param left 현재 왼쪽 무게
	 */
	private static void addAns(int idx, int right, int left) {
		// 추를 다 올렸다면 ans++
		if (idx == N) {
			ans++;
			return;
		}

		// 현재 추를 왼쪽에 올리기
		addAns(idx + 1, right, left + choo[idx]);

		// 추를 올린 오른쪽 무게 > 왼쪽 무게라면 가지치기
		if (right + choo[idx] > left)
			return;

		// 현재 추를 오른쪽에 올리기
		addAns(idx + 1, right + choo[idx], left);
	}

	/**
	 * NextPermutation
	 * @return 다음 순열이 있다면 true, 없다면 false;
	 */
	private static boolean np() {
		int i = N - 1;
		while (i != 0 && choo[i - 1] >= choo[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (choo[i - 1] >= choo[j])
			j--;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	/**
	 * choo의 i번째와 j번째 내용 바꾸기
	 * @param i 내용 바꿀 인덱스
	 * @param j 내용 바꿀 인덱스
	 */
	private static void swap(int i, int j) {
		int temp = choo[i];
		choo[i] = choo[j];
		choo[j] = temp;
	}
}
