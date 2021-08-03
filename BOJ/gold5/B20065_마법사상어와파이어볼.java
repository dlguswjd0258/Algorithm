package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
NxN
���̾ M�� �߻�

i�� ���̾ ��ġ (ri, ci), ���� mi, ���� di, �ӷ� si
�̵��ص� ������ ������ ���� �ƴϰ� �� ��, ���� ���� ���� ����

��� ��ġ
1. di ����� si �ӵ��� �̵�, �� ĭ�� ���� ���̾ ���� ����
2. ������ �� 
	2-1. ���̺��� ��� �ϳ��� ��������.
	2-2. 4���� ���̾�� ����������.
	2-3. �������� ���̾�� ������ (������ ����) /5, �ӷ´� (������ �ӷ� ��)/(������ ���̾ ����), ������ ��� Ȧ���ų� ¦���� 0,2,4,6(¦��) �ƴϸ� 1,3,5,7(Ȧ��)
3. ������ 0�� ���̾�� �Ҹ�

 */
public class B20065_������������̾ {

	static class Fireball {
		int m, s, d, num;

		public Fireball(int num) {
			this.num = num;
		}

		public Fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int N, M, K;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }, dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // ��, ���, ��, �Ͽ�, ��, ����, ��, ����
	static List<Fireball>[][] fireballs;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// ���̾ ���� �Է� �ޱ�
		fireballs = new List[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			fireballs[r][c] = new ArrayList<>();
			fireballs[r][c].add(new Fireball(m, s, d));

		}

		while (K-- > 0) {
			moveFireballs();

			conbineFireballs();
		}

		System.out.println(getRemainingMass());

	}

	private static int getRemainingMass() {
		int mass = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fireballs[i][j] == null)
					continue;

				for (Fireball fireball : fireballs[i][j]) {
					mass += fireball.m;
				}
			}
		}

		return mass;
	}

	private static void moveFireballs() {
		List<Fireball>[][] temps = new List[N][N];

		int r, c;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fireballs[i][j] == null)
					continue;

				for (Fireball fireball : fireballs[i][j]) {
					r = (N + i + (dr[fireball.d] * (fireball.s % N))) % N;
					c = (N + j + (dc[fireball.d] * (fireball.s % N))) % N;

					if (temps[r][c] == null) {
						temps[r][c] = new ArrayList<>();
					}

					temps[r][c].add(fireball);
				}

			}
		}

		fireballs = temps;
	}

	private static void conbineFireballs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fireballs[i][j] == null || fireballs[i][j].size() < 2)
					continue;

				// �ϳ��� ��ġ��
				Fireball fireball = getOneFireball(fireballs[i][j]);

				// �� ���� ��������
				boolean sameD = false;
				if (isSameDirection(fireballs[i][j])) {
					sameD = true;
				}

				// 4���� ������
				fireballs[i][j] = divideByFour(fireball, sameD);

			}
		}
	}

	private static boolean isSameDirection(List<Fireball> fireballList) {

		boolean prevEven = fireballList.get(0).d % 2 == 0 ? true : false;

		for (int i = 1; i < fireballList.size(); i++) {
			boolean now = fireballList.get(i).d % 2 == 0 ? true : false;
			if (prevEven != now)
				return false;
		}

		return true;
	}

	private static List<Fireball> divideByFour(Fireball fireball, boolean sameD) {
		if (fireball.m < 5) 
			return null;

		List<Fireball> temp = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			temp.add(new Fireball(fireball.m / 5, fireball.s / fireball.num, i * 2 + (sameD ? 0 : 1)));
		}

		System.out.println(temp.toString());
		return temp;
	}

	private static Fireball getOneFireball(List<Fireball> fireballList) {
		Fireball fireball = new Fireball(fireballList.size());

		for (Fireball fb : fireballList) {
			fireball.d += fb.d;
			fireball.m += fb.m;
			fireball.s += fb.s;
		}

		return fireball;
	}
}
