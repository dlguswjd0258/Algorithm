package gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B5052_전화번호목록 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		PriorityQueue<String> pQue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());
			pQue.clear();
			while (N-- > 0) {
				pQue.offer(in.readLine().trim());
			}

			String pre, now = pQue.poll();
			boolean isPrefix = false;
			while (!pQue.isEmpty()) {
				pre = now;
				now = pQue.poll();
				if(now.startsWith(pre)) {
					isPrefix = true;
					break;
				}
			}
			
			if(isPrefix) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
