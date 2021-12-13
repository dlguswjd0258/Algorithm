/**
* 메모리: 11524 KB, 시간: 80 ms
* 2021.12.13
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    
    static int N, P, score, up, same;
    
    public static void main(String[] args) throws Exception {
        init();
        
        System.out.println(getRank());
    }
    
    private static int getRank(){        
        // 태수를 포함해서 태수와 같은 점수를 가진 사람들이 P보다 작거나 같다면 해당 등수 반환
        if(up + same + 1 <= P){
            return up + 1;
        }
        
        return -1;
    }
    
    
    private static void init() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        if(N == 0){
            return;
        }
        
        st = new StringTokenizer(in.readLine());
        int temp;
        for(int i = 0; i < N; i++){
            temp = Integer.parseInt(st.nextToken());
            
            // 태수 점수 보다 작은 애들은 패스
            if(temp < score){
                continue;
            }
            
            if(temp == score){
                same++;
            }else{
                up++;
            }
        }
    }
}