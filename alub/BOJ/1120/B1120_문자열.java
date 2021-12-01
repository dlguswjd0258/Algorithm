/**
* 메모리: 11496 KB, 시간: 76 ms
* 2021.12.01
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main{
    
    static String A, B;
    
    public static void main(String[] arg)throws Exception{
        init();
        
        System.out.println(getMinDiff());
    }
    
    private static int getMinDiff(){
        int min = Integer.MAX_VALUE;
        int diff;
        for(int i = 0; i <= B.length()-A.length(); i++){
            diff = 0;
            for(int j = 0; j < A.length(); j++){
                if(B.charAt(i+j) == A.charAt(j))
                    continue;
                diff++;
            }
            
            min = Math.min(min, diff);
        }
        
        return min;
    }
    
    private static void init() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = st.nextToken();
        B = st.nextToken();
    }
}