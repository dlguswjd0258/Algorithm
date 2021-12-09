/**
* 메모리: 19628 KB, 시간: 152 ms
* 2021.12.09
* by Alub
*/
import java.util.*;

public class Main {

	static int N, K;

	public static void main(String[] args) {
		init();

		System.out.println(getFastTime());
	}

	private static int getFastTime() {
		if (N >= K) {
			return N - K;
		}

		Queue<Integer> que = new LinkedList<>();
		que.offer(N);

		int[] cnt = new int[200001];
		cnt[N] = 1;

		while (!que.isEmpty()) {
			int num = que.poll();
			if (num == K) {
				break;
			}

			if (num * 2 <= 200000 && (cnt[num * 2] == 0 || cnt[num * 2] > cnt[num])) {
				cnt[num * 2] = cnt[num];
				que.offer(num * 2);
			}

			if (num + 1 <= 200000 && (cnt[num + 1] == 0 || cnt[num + 1] > cnt[num] + 1)) {
				cnt[num + 1] = cnt[num] + 1;
				que.offer(num + 1);
			}

			if (num - 1 >= 0 && (cnt[num - 1] == 0 || cnt[num - 1] > cnt[num] + 1)) {
				cnt[num - 1] = cnt[num] + 1;
				que.offer(num - 1);
			}
		}

		return cnt[K] - 1;
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
	}
}