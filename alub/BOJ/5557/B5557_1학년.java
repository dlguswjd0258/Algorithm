/**
* 메모리: 11584 KB, 시간: 76 ms
* 2022.01.19
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
    
    static int N, num[];
    
    public static void main(String[] agrs) throws Exception {
        input();
        System.out.println(countCorrectEquation());
    }
    
    private static long countCorrectEquation() {
        long[][] dp = new long[N - 1][21];
        
        // 첫번째 숫자는 1로 초기화
        dp[0][num[0]] = 1;
        
        // 이전 값 중 0이 아닌 값에서 해당 숫자 더하고 빼기
        for(int i = 1; i < N - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                // 이전 값이 0이면 pass
                if(dp[i-1][j] == 0) {
                    continue;
                }
                
                // 더한 값이 20이하라면 더한 값 개수 저장
                int sum = j + num[i];
                if(sum <= 20) {
                    dp[i][sum] += dp[i-1][j];   
                }
                
                // 뺀 값이 0이상이라면 뺀값 개수 저장
                sum = j - num[i];
                if(sum >= 0) {
                    dp[i][sum] += dp[i-1][j];
                }
            }
        }
        
        // 맨 마지막 계산에 마지막 숫자 값 리턴
        return dp[N-2][num[N-1]];
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        
        num = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
    
}