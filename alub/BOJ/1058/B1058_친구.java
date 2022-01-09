/**
* 메모리: 11620 KB, 시간: 88 ms
* 2022.01.09
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] friends;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getMax2Friend());
	}

	private static int getMax2Friend() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, count2Friend(i));
		}
		return max;
	}

	private static int count2Friend(int me) {
		int cnt = 0;
		boolean[] checked = new boolean[N];
		for (int i = 0; i < N; i++) {
			// 친구 아니면 pass
			if(friends[me][i] == 'N') {
				continue;
			}
			
			// 해당 친구를 2-친구라고 세지 않았따면 count
			if(!checked[i]) {
				cnt++;
				checked[i] = true;
			}
			
			// 친구의 친구 구하기
			for (int j = 0; j < N; j++) {
				// 나거나 친구가 아니거나 이미 count한 친구면 pass
				if(j == me || friends[i][j] == 'N' || checked[j]) {
					continue;
				}

				cnt++;
				checked[j] = true;
			}
		}
		
		return cnt;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		friends = new char[N][N];
		for (int i = 0; i < N; i++) {
			friends[i] = in.readLine().toCharArray();
		}
	}
}