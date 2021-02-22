package bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5566_주사위게임 {

	static int N, M;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 1. 데이터 입력 받기
		map = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		// 2. 굴린 주사위 수만큼 이동
		int pos = 1, cnt = 0;
		while (M-- > 0 && pos < N) {
			pos += Integer.parseInt(br.readLine());
			cnt++;
			if(pos < N)
				break;
			pos += map[pos];
		}
		
		System.out.println(cnt);
	}
}
