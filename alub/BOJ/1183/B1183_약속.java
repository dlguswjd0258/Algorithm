/**
* 메모리: 11668 KB, 시간: 76 ms
* 2021.12.06
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Long> diff = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		init();

		int difCnt = diff.size();

		// 차이의 개수가 짝수일 때
		if (difCnt % 2 == 0) {
			// 가운데 두 수자의 차 + 1
			long res = diff.get(difCnt / 2) - diff.get(difCnt / 2 - 1) + 1;
			System.out.println(res);
		} else {
			System.out.println(1);
		}

	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		// 입력 받으면서 두 시간의 차를 diff에 담기
		StringTokenizer st = null;
		while (N-- > 0) {
			st = new StringTokenizer(in.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());

			diff.add(b - a);
		}
		
		// 앞서 구한 차이 오름차순 정렬
		Collections.sort(diff);
	}
}