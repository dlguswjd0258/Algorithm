/**
* 메모리: 293576 KB, 시간: 764 ms
* 2022.01.07
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static PriorityQueue<Integer> pQue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());

				// N개만 담고 담으면서 큰 숫자만 남긴다.
				if (pQue.size() < N) {
					pQue.offer(num);
					continue;
				}

				if (pQue.peek() >= num) {
					continue;
				}

				pQue.poll();
				pQue.offer(num);
			}
		}

		System.out.println(pQue.peek());
	}
}