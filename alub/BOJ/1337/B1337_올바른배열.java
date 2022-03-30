/**
* 메모리: 11544 KB, 시간: 76 ms
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
        int min = 5;
        
        for(int i = 0; i < N; i++) {            
            // i 이후부터 5이상 차이나는 위치 찾기
            int cnt = 4;
            for(int j = i + 1; j < N; j++) {
                if(num[j] - num[i] >= 5) 
                    break;
                
                cnt--;
            }
            
            // 이전과 비교해서 작은 값 저장
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