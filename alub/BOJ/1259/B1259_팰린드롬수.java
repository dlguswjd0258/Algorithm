/**
* 메모리: 11300 KB, 시간: 68 ms
* 2021.12.18
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
        
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String num = in.readLine();
        
        StringBuilder sb = new StringBuilder();
        while(!"0".equals(num)){
            sb.append(isPalindrome(num)).append("\n");
            num = in.readLine();
        }
        
        System.out.println(sb.toString());
    }
    
    private static String isPalindrome(String num){
        int len = num.length();
        for(int i = 0; i < len / 2; i++){
            if(num.charAt(i) == num.charAt(len - 1 - i)){
                continue;
            }
            
            return "no";
        }
        
        return "yes";
    }
}