/**
* 메모리: 11516 KB, 시간: 76 ms
* 2022.01.03
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(countCow(N, M));
	}

	private static int countCow(int r, int c) {
		if(r % 2 == 0 || c % 2 == 0) {
			return 0;
		}

		// 소가 놓인 위치
		int centerR = r / 2;
		int centerC = c / 2;
		
		// 왼쪽 위만 확인해도 괜찮은게 개수가 다 똑같이 나오기 때문에 *4 하면 된다.
		return 1 + countCow(centerR, centerC) * 4;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
}