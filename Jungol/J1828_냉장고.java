import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 냉장고
public class J1828_냉장고 {

	static class Chemical implements Comparable<Chemical> {
		int min, max;

		public Chemical(int min, int max) {
			this.min = min;
			this.max = max;
		}

		// 최고 오름차순, 같으면 최저 오름차순
		@Override
		public int compareTo(Chemical o) {
			int diff = this.max - o.max;
			return (diff != 0) ? diff : this.min - o.min;
		}

		// 최저 내림차순, 같으면 최고 내림차순
//		@Override
//		public int compareTo(Chemical o) {
//			int diff = o.min - this.min;
//			return (diff != 0) ? diff : o.max - this.max;
//		}
	}

	static int N, cnt;
	static Chemical[] C;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		C = new Chemical[N];

		// 최저, 최고 온도 입력 받기
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			C[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 정렬
		Arrays.sort(C);

		// 냉장고 개수 얻어 오기
		cnt = 1;
		getRefCnt();
		System.out.println(cnt);

	}

	// 최고 오름차순일 때
	private static void getRefCnt() {
		int preMax = C[0].max; // 현재 최고 온도 값
		for (int i = 1; i < N; i++) {
			if (preMax < C[i].min) {
				cnt++;
				preMax = C[i].max;
			}
		}
	}

	// 최저 내림차순일 때
//	private static void getRefCnt() {
//		int preMin = C[0].min; // 현재 최저 온도 값
//		for (int i = 1; i < N; i++) {
//			if (preMin > C[i].max) {
//				cnt++;
//				preMin = C[i].min;
//			}
//		}
//	}

}