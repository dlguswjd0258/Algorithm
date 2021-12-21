/**
* 메모리: 17312 KB, 시간: 148 ms
* 2021.12.21
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] friends;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(countInvitedFriends());
	}

	private static int countInvitedFriends() {
		int cnt = 0;
        
		boolean[] invited = new boolean[N + 1];
		invited[1] = true;
        
		for (int friend : friends[1]) {
			// 상근이 친구 더하기
			if (!invited[friend]) {
				cnt++;
				invited[friend] = true;
			}
			
			// 상근이 친구의 친구 더하기
			for (int f : friends[friend]) {
				if (invited[f]) 
					continue;
				
				cnt++;
				invited[f] = true;
			}
		}

		return cnt;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		friends = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}

		int a, b;
		StringTokenizer st = null;
		while (M-- > 0) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);

		}
	}
}