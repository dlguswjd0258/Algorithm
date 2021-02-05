package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 퍼펙트 셔플
public class S3499_퍼펙트셔플 {

	static int T, N;
	static Queue<String> left = new LinkedList<>();
	static Queue<String> right = new LinkedList<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(in.readLine()) + 1;
			st = new StringTokenizer(in.readLine());

			// 데이터 받아서 큐에 넣기
			for (int i = 0; i < N / 2; i++) {
				left.offer(st.nextToken());
			}

			while (st.hasMoreTokens()) {
				right.offer(st.nextToken());
			}
			
			while(!left.isEmpty()) {
				sb.append(left.poll()).append(" ");
				if(right.isEmpty())
					continue;
				sb.append(right.poll()).append(" ");
			}
			
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
