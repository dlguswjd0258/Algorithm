/**
* 메모리: 11636 KB, 시간: 80 ms
* 2021.12.06
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Num implements Comparable<Num> {
		// 해당 숫자가 나온 순서와 원소
		int idx, num;

		public Num(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Num o) {
			// 숫자 내림차순
			int nDiff = this.num - o.num;
			// 순서 내림차순
			int iDiff = this.idx - o.idx;

			return nDiff != 0 ? nDiff : iDiff;
		}

	}

	static int N;
	static PriorityQueue<Num> pQue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		init();
		
		int[] res = applyP();
		
		// res 순서대로 출력
		StringBuilder sb = new StringBuilder();
		for (int r : res) {
			sb.append(r).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int[] applyP() {
		// pQue를 빼면서 빠져나온 순서를 res의 Num.idx위치에 담기
		int[] res = new int[N];
		for (int cnt = 0; cnt < N; cnt++) {
			res[pQue.poll().idx] = cnt;
		}
		
		return res;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// pq에 나온 순서와 원소 입력 받기
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			pQue.offer(new Num(i, Integer.parseInt(st.nextToken())));
		}
	}
}
