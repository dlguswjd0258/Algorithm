package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501_��� {

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

		// ��� ����ǥ ���� �ޱ�
		schedules = new Consulting[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			schedules[i] = new Consulting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// ���Ʈ����
		System.out.println(getMaxPay(0, 0));
	}

	private static int getMaxPay(int idx, int sum) {
		if (idx >= N)
			return sum;

		int max = sum;
		// �ش� ��¥ ������� ��
		if (idx + schedules[idx].t <= N)
			max = Math.max(max, getMaxPay(idx + schedules[idx].t, sum + schedules[idx].p));

		// �ش� ��¥ ��� ������ ��
		max = Math.max(max, getMaxPay(idx + 1, sum));

		return max;
	}

}
