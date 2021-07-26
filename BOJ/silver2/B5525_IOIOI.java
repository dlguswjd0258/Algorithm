package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// KMP?
// �־��� ���ڿ��� Pn�� � ����ִ°�
public class B5525_IOIOI {

	static int N, M;
	static String S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		S = in.readLine().trim();

		int res = 0; // ��
		// I�� �����ϰ� ������ ���� ������ I�� �����ϴ��� ���� OI�� �� �� �ݺ��Ǵ��� cnt�� ����.
		// cnt�� N�� ���ų� ũ�� res�� ������Ų��.
		int cnt;
		for (int i = 1; i < M - 1; i++) {
			if (S.charAt(i - 1) == 'I') {
				cnt=0;
				while (i < M-1 && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
					cnt++;
					i += 2;
					if(cnt >= N)
						res++;
				}
			}
		}
		
		System.out.println(res);
	}
}
