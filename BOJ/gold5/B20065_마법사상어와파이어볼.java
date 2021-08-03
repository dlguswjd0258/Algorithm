package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
NxN
파이어볼 M개 발사

i번 파이어볼 위치 (ri, ci), 질량 mi, 방향 di, 속력 si
이동해도 밖으로 나가는 것이 아니고 각 행, 열은 끝과 끝이 연결

명령 규치
1. di 방향과 si 속도로 이동, 한 칸에 여러 파이어볼 존재 가능
2. 겹쳤을 때 
	2-1. 파이볼은 모두 하나로 겹쳐진다.
	2-2. 4개의 파이어볼로 나누어진다.
	2-3. 나누어진 파이어볼의 질량은 (합쳐진 질량) /5, 속력는 (합쳐진 속력 합)/(합쳐진 파이어볼 개수), 방향은 모두 홀수거나 짝수면 0,2,4,6(짝수) 아니면 1,3,5,7(홀수)
3. 질량이 0인 파이어볼은 소멸

 */
public class B20065_마법사상어와파이어볼 {

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
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }, dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 상, 상우, 우, 하우, 하, 하좌, 좌, 상좌
	static List<Fireball>[][] fireballs;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 파이어볼 정보 입력 받기
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

				// 하나로 합치기
				Fireball fireball = getOneFireball(fireballs[i][j]);

				// 다 같은 방향인지
				boolean sameD = false;
				if (isSameDirection(fireballs[i][j])) {
					sameD = true;
				}

				// 4개로 나누기
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
