package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13458_���谨�� {

	static int N, B, C;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// �� ������ ������ �� �ޱ�
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			// �Ѱ����� �ֱ�
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		long cnt = N;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			
			if (A[i] > 0)
				cnt += (A[i] / C) + (A[i] % C == 0 ? 0 : 1);
		}

		System.out.println(cnt);
	}
}
