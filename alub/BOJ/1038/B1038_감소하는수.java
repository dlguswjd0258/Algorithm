/**
* 메모리: 13028 KB, 시간: 112 ms
* 2021.12.09
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static Queue<String> que = new LinkedList<>();

	public static void main(String[] args) {
		init();

		if (N < 10) {
			System.out.println(N);
			return;
		}

		System.out.println(getNth());

	}

	private static String getNth() {
		// 1 ~ 9까지 큐에 담기
		int seq = 0;
		for (; seq < 9;) {
			que.offer(++seq + "");
		}

		String num;
		while (!que.isEmpty() && seq < N ) {
			num = que.poll();
			int endNum = num.charAt(num.length() - 1) - '0';

			for (int i = 0; i < endNum; i++) {
				seq++;
				
				if(seq == N) {
					return num + i;
				}
				
				que.offer(num + i);
				
			}
		}

		return "-1";
	}

	private static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	}
}