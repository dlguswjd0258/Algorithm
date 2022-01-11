/**
* 메모리: 11620 KB, 시간: 80 ms
* 2022.01.11
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    
    static int len, num[];
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(countDecryptionWays());
    }
    
    private static int countDecryptionWays() {
        int[][] dp = new int[len + 1][2];
        dp[0][0] = 1;
        for(int i = 1; i <= len; i++) {
            // 숫자가 0이면 1자리수로 사용 할 수 없음
            if(num[i] != 0) {
                // 1자리수로 사용한다면 이전에 나온 총 개수
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;    
            }
            
            // 2자리수 구하기
            int n = num[i-1] * 10 + num[i];
            // Z인 26까지만 2자리수로 사용 가능
            if(n >= 10 && n <= 26) {
                dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 1000000;
            }
            
            if(dp[i][0] + dp[i][1] == 0)
                return 0;
        }
        
        return (dp[len][0] + dp[len][1]) % 1000000;
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        len = s.length();
        
        num = new int[len + 1];
        for(int i = 1; i <= len; i++) {
            num[i] = s.charAt(i - 1) - '0';
        }
    }
}