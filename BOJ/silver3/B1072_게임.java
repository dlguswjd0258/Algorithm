package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
게임 횟수 : X
이긴 게임 : Y (Z%)
Z : 승률, 소수점은 버림. => int
몇 판을 더 해야 Z값이 변할까 

승률이 100이면 바뀌지 않음

 */

public class B1072_게임 {

	static long X, Y, Z;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());

		// 현재 승률 계산
		Z = Y * 100 / X;

		// 현재 승률이 100이거나 99였는데 100으로 변할 수 없음
		if (Z == 100 || ++Z == 100) {
			System.out.println(-1);
			return;
		}
		
		long cnt = (Z * X) - (100 * Y);
		cnt = (long) Math.ceil(cnt / (double)(100 - Z));
		
		
//		if (cnt % (100 - Z) == 0)
//			cnt /= (100 - Z);
//		
//		else {
//			cnt /= 100 - Z;
//			cnt++;
//		}

		System.out.println(cnt);

	}
}
