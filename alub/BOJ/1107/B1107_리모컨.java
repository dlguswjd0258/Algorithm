/**
* 메모리: 12000 KB, 시간: 152 ms
* 풀이 시간: 00:48:32
* 2021.11.30
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean broken[];

	public static void main(String[] args) throws Exception {
		// 입력 받기
		init();

		// 원하는 채널이 100일 경우 0 출력
		if (N == 100) {
			System.out.println(0);
			return;
		}

		// 누를 수 있는 버튼으로 이동 할 수 있고 N과 가장 가까운 숫자 구하기
		int nowDiff = getCnt();
		int initDiff = Math.abs(N - 100); // +, -만 눌렀을 경우

		// 구한 채널에서 +나 -만 헸을 때가 더 최소인지 100에서 +, -하는게 더 최소인지 비교 후 값 출력
		if (nowDiff > initDiff) {
			System.out.println(initDiff);
		} else {
			System.out.println(nowDiff);
		}
	}

	private static int getCnt() {
		if (canPress(N)) {
			return String.valueOf(N).length();
		}

		// N 보다 큰 값 중에서 가장 가까운 값 찾기
		int uper = 100;
		for (int i = N + 1; i <= 1000000; i++) {
			if (!canPress(i))
				continue;

			uper = i;
			break;
		}

		// N보다 작은 값중 가장 가까운 값 찾기
		int down = 100;
		for (int i = N - 1; i >= 0; i--) {
			if (!canPress(i))
				continue;

			down = i;
			break;
		}

		int uperLen = String.valueOf(uper).length();
		int uperDiff = Math.abs(uper - N);
		
		int downLen = String.valueOf(down).length();
		int downDiff = Math.abs(N - down);

		return uperDiff + uperLen <= downDiff + downLen ? uperDiff + uperLen : downDiff + downLen;

	}

	private static boolean canPress(int now) {
		if (now == 0 && broken[now])
			return false;

		while (now > 0) {
			int one = now % 10;
			if (broken[one])
				return false;
			now = now / 10;
		}

		return true;
	}

	private static void init() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		broken = new boolean[10];

		if (M == 0)
			return;

		// 고장난 버튼 입력 받기
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
	}
}