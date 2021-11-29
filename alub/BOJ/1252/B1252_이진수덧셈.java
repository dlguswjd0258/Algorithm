/**
* 메모리: 11488 KB, 시간: 76 ms
* 2021.11.29
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(in.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        
        // 둘 중 짧은 길이 입력받기
        int size = a.length() < b.length()? a.length(): b.length();
        // 올림이 있는지 여부
        boolean up = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            char aChar = a.charAt(a.length() -1 - i);
            char bChar = b.charAt(b.length() -1 - i);
            
            // 둘 다 1일 때
            if(aChar == '1' && bChar == '1'){
                if(up){
                    sb.insert(0, '1');
                }else{
                    sb.insert(0, '0');
                }
                
                up = true;
            }else if(aChar == '1' || bChar == '1'){
                if(up){
                    sb.insert(0, '0');
                    up = true;
                }else{
                    sb.insert(0, '1');
                }
            }else{
                if(up){
                    sb.insert(0, '1');
                    up = false;
                }else{
                    sb.insert(0, '0');
                }
            }
        }
        
        if(a.length() == size){ // b의 길이가 더 길 경우
            for(int i = size; i < b.length(); i++){
                char bChar = b.charAt(b.length() -1 - i);
                // 올림이 남아있을 경우
                if(up){
                    if(bChar == '1'){
                        sb.insert(0, '0');
                    }else{
                        sb.insert(0, '1');
                        up = false;
                    }
                }else{
                    if(bChar == '1'){
                        sb.insert(0, '1');
                    }else{
                        sb.insert(0, '0');
                    }
                }
            }
        }else{ // a의 길이가 더 길 경우
            // 올림이 남아있을 경우
            for(int i = size; i < a.length(); i++){
                char aChar = a.charAt(a.length() -1 - i);
                // 올림이 남아있을 경우
                if(up){
                    if(aChar == '1'){
                        sb.insert(0, '0');
                    }else{
                        sb.insert(0, '1');
                        up = false;
                    }
                }else{
                    if(aChar == '1'){
                        sb.insert(0, '1');
                    }else{
                        sb.insert(0, '0');
                    }
                }
            }
        }
        
        if(up){
            sb.insert(0, '1');
        }
        
        // 앞에 0 있으면 자르기
        int start = 0;
        int len = sb.toString().length();
        for(;start < len - 1; start++){
            if(sb.toString().charAt(start) == '1'){
                break;
            }
        }
        
        System.out.println(sb.toString().substring(start, len));
        
    }
}