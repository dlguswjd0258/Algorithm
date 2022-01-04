/**
* 메모리: 11916 KB, 시간: 92 ms
* 2022.01.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, num[], max;

	public static void main(String[] args) throws Exception {
		input();
        
//		재귀로 풀기
		getEnergy(0, 0, 0);
		System.out.println(max);
	}

	private static void getEnergy(int cnt, int energy, int flag) {
		if (cnt == N - 2) {
			max = Math.max(max, energy);
			return;
		}

		// 구슬 고르기, 앞뒤는 고르지 못함
		for (int i = 1; i < N - 1; i++) {
			// 이미 고른 구슬을 pass
			if ((flag & (2 << i)) != 0) {
				continue;
			}

			// 에너지 구하기
			int front = i - 1;
			while ((flag & (2 << front)) != 0) {
				front--;
			}

			int rear = i + 1;
			while ((flag & (2 << rear)) != 0) {
				rear++;
			}

			getEnergy(cnt + 1, energy + (num[front] * num[rear]), flag | 2 << i);
		}
	}
    
	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		num = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
}