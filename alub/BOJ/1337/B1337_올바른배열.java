/**
* 메모리: 11488 KB, 시간: 80 ms
* 2022.03.30
* by Alub
*/
import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int[] num;
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(getMinCnt());
    }
    
    private static int getMinCnt() {
        // 필요한 원소 최소 개수
        int min = 5;
        
        for(int i = 0; i < N; i++) {            
            // i부터 연속적인 배열을 만들기 위해 사용되는 원소 개수 찾아 빼기
            int cnt = 4; // 필요한 원소 개수
            for(int j = i + 1; j < N; j++) {
                // 5 이상 차이나면 끝내기
                if(num[j] - num[i] >= 5) 
                    break;
                
                cnt--;
            }
            
            min = Math.min(cnt, min);
        }
        
        return min;
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(in.readLine());
        }
        
        Arrays.sort(num);
    }
}