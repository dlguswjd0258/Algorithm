/**
* 메모리: 11592 KB, 시간: 76 ms
* 2021.12.08
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
     
    static int N;
    static boolean[] check; // 압수 당했는지
    static String[] names;
    static BufferedReader in;
    
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while(N > 0){
            init();
            
            // 압수 당했는지 돌려받았는지 체크하기
            int num;
            for(int i = 0; i < N*2 -1; i++){
                st = new StringTokenizer(in.readLine());
                num = Integer.parseInt(st.nextToken());
                check[num] = !check[num];
            }
            
            // 몇번이 못돌려 받았는지 확인하기
            for(int i = 1; i <= N; i++){
                if(!check[i])
                    continue;
                
                sb.append(t++).append(" ").append(names[i]).append("\n");
                break;
            }
            
            N = Integer.parseInt(in.readLine());
        }
        
        System.out.println(sb.toString());
    }
    
    private static void init() throws Exception {
        // 압수 당한 학생 이름 받기
        names = new String[N+1];
        for(int i = 1; i <= N; i++){
            names[i] = in.readLine().trim();
        }
        
        check = new boolean[N+1];
    }    
}