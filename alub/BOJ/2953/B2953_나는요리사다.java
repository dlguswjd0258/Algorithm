/**
* 메모리: 11512 KB, 시간: 80 ms
* 2021.12.03
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int idx = -1, sum, max = 0;
        for(int i = 1; i <=5; i++){
            // 각 줄의 입력을 받는다.
            st = new StringTokenizer(in.readLine());
            // 해당 줄에서 나온 숫자 중 다른 번호의 사람들이 준 숫자만 더한다.
            sum = 0;
            for(int j = 1; j <= 5; j++){
                if(i == j){
                    continue;
                }
                
                sum += Integer.parseInt(st.nextToken());
            }
            
            // 더한 값이 max보다 크면 idx에 해당 참가자 번호를, max에는 더한 숫자를 저장
            if(max < sum){
                idx = i;
                max = sum;
            }
        }
        
        System.out.println(idx + " " + max);
    }
}