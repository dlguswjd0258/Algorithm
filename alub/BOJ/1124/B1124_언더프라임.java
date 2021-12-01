/**
* 메모리: 12288 KB, 시간: 4024 ms
* 2021.12.01
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main{
    
    static int A, B, len[];
    static boolean[] prime;
    
    public static void main(String[] arg) throws Exception {
        init();
        
        // 소수 구하기
        getPrime();
        
        // 소수의 목록 길이 구하기
        getLens();
        
        // 길이가 소수인 숫자 개수 구하기
        System.out.println(getCnt());
    }
    
    private static int getCnt(){
        int cnt = 0;
        for(int i = A; i <= B; i++){
            if(prime[len[i]]){
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private static void getLens(){
        for(int i = A; i <= B; i++){
            len[i] = getPrimeLen(i);
        }
    }
    
    private static int getPrimeLen(int num){
        int temp = num, cnt = 0;
        for(int i = 2; i <= num/2; i++){
            while(prime[i] && temp % i == 0){
                temp /= i;
                cnt++;
            }
            
            if(temp == 0)
                break;
        }
        
        return cnt;
    }
    
    private static void getPrime(){
        for(int i = 2; i <= B/2; i++){
            if(!prime[i])
                continue;
            len[i] = 1; // 소수의 소인수분해 길이는 1
            // 소수의 배수에 false 체크
            for(int j = 2; i * j <= B; j++){
                prime[i*j] = false;
            }
        }
    }
    
    private static void init() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        len = new int[B+1];
        prime = new boolean[B+1];
        
        Arrays.fill(prime, true);
        // 0과 1은 소수가 아님
        prime[0] = prime[1] = false;
    }
}