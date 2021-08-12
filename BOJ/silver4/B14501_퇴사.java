package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_퇴사 {

	static class Consulting {
		int t, p;

		public Consulting(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}

	static int N;

	static Consulting[] schedules;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// 상담 일정표 정보 받기
		schedules = new Consulting[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			schedules[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 브루트포스
		System.out.println(getMaxPay(0, 0));
	}

	private static int getMaxPay(int idx, int sum) {
		if (idx >= N)
			return sum;

		int max = sum;
		// 해당 날짜 상담했을 때
		if (idx + schedules[idx].t <= N)
			max = Math.max(max, getMaxPay(idx + schedules[idx].t, sum + schedules[idx].p));

		// 해당 날짜 상담 안했을 때
		max = Math.max(max, getMaxPay(idx + 1, sum));

		return max;
	}

}
