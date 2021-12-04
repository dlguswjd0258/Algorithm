/**
* 메모리: 11508 KB, 시간: 76 ms
* 2021.12.04
* by Alub
*/
import java.io.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		System.out.println(getCnt());
	}

	private static int getCnt() {
		int[] dp = new int[N + 1];
		
		// 2x0과 2x1을 만들 수 있는 방법 수는 1가지
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= N; i++) {
            // 2xi-1 크기의 직사각형에  2x1 올리는 방법  + 2xi-2 크기의 직사각형에 2x2 올리는 방법
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		return dp[N];
	}
}