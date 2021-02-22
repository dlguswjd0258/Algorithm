package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ gold5 15686 치킨 배달
public class B15686_치킨배달 {

//	좌표를 저장할 dot객체 생성
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, ans = Integer.MAX_VALUE;
	static Dot[] comb;
	static ArrayList<Dot> home = new ArrayList<>(), chicken = new ArrayList<>(); // 집, 치킨집의 좌표를 각각 저장할 ArrayList생성

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		comb = new Dot[M];

//		데이터 읽기
		int temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());

//				읽은 데이터가 1이면 집 list에, 2면 치킨 list에 저장
				if (temp == 1) { // 집
					home.add(new Dot(i, j));
				} else if (temp == 2) { // 치킨집
					chicken.add(new Dot(i, j));
				}
			}
		}

//		치킨list사이즈 중 M개를 골라 조합
		combinataion(0, 0);

		System.out.println(ans);

	}

	private static void combinataion(int idx, int cnt) {
		if (cnt == M) {
//			현재 최솟값(ans)과 계산한 치킨 거리값을 비교하여 최솟값 갱신 <= Math.min
			ans = Math.min(ans, oper());
			return;
		}

		for (int i = idx, size = chicken.size(); i < size; i++) {
			// 치킨집 좌표 저장
			comb[cnt] = chicken.get(i);
			combinataion(i + 1, cnt + 1);
		}
	}

//	해당 조합마다 도시 치킨 거리 계산
	private static int oper() {
		// res는 최종 거리, min은 각 집에서 최소 치킨 거리, dis는 집과 치킨집의 거리
		int res = 0, min, dis;
		for (int i = 0, size = home.size(); i < size; i++) {
			
			// 각 집에서 최소 치킨 거리 초기화
			min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				// |home.x-chichen.x| + |home.y-chichen.y|
				dis = Math.abs(home.get(i).x - comb[j].x) 
						+ Math.abs(home.get(i).y - comb[j].y);
				min = Math.min(min, dis);
			}

			res += min;
		}
		
		return res;
	}
}
