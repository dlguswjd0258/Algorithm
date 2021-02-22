package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	N : 물병의 수 / 무한대로 물을 부을 수 있음 / 첨엔 물 1리터씩 들어 있음.
//	K : 한번에 옮길 수 있는 물병 수 / 물 낭비 x, 이동 많이 x
//	제약
//	1. 같은 양의 물이 들어 있늠 물 병 두개 고르기 => 중요
//	2. 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓기
//	
//	N개의 물병으로 K개를 넘지 않는 비어 있지 않은 물병을 만들기, 불가능할 수도 있음.
//	새 물병 살 수 있음. 첨엔 물 1리터씩 들어 있음.

//	출력 : 상점에서 사야하는 물병의 최솟값 출력
public class B1052_물병 {

	static int N, K, cnt, k;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int k;
		while (getBottleNum(N) > K) {
			// 마지막 1의 자리의 값 더하기 => ex) 010 & 110 = 010 = 2 = k
			k = N & -N;
			cnt += k;
			N += k;
		}

		System.out.println(cnt);
	}

	// 물병이 몇개인지 구하기
	private static int getBottleNum(int n) {
		int num = 0;
		while (n > 0) {
			if ((n & 1) == 1)
				num++;
			n >>= 1;
		}

		return num;
	}

}