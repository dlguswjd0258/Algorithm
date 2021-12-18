/**
* 메모리: 12008 KB, 시간: 92 ms
* 2021.12.18
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, num[], oper[], max, min;

	public static void main(String[] args) throws Exception {
		input();

		// 연산자 순서를 nextPermutation으로 구하면서 max와 min 구하기
		max = -1000000001;
		min = 1000000001;
		int res;
		do {
			res = calculateNumber();
			max = Math.max(max, res);
			min = Math.min(min, res);
		} while (NP());

		System.out.println(max + "\n" + min);
	}

	private static int calculateNumber() {
		int res = num[0];
		for (int i = 1; i < N; i++) {
			switch (oper[i - 1]) {
			case 0:
				res += num[i];
				break;
			case 1:
				res -= num[i];
				break;
			case 2:
				res *= num[i];
				break;
			case 3:
				res /= num[i];
				break;
			}
		}
		return res;
	}

	private static boolean NP() {
		int i = N - 2;
		while (i > 0 && oper[i - 1] >= oper[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = N - 2;
		while (oper[i - 1] >= oper[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = N - 2;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	private static void swap(int a, int b) {
		int temp = oper[a];
		oper[a] = oper[b];
		oper[b] = temp;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		num = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		oper = new int[N - 1];
		st = new StringTokenizer(in.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			while (cnt-- > 0) {
				oper[idx++] = i;
			}
		}
	}
}