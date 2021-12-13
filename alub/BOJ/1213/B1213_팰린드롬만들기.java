/**
* 메모리: 12804 KB, 시간: 104 ms
* 2021.12.13
* by Alub
*/
import java.util.*;

public class Main {
    
    static int[] cnt = new int[27];
    
    public static void main(String[] args) {
        init();
        
        System.out.println(getPalindrome());
    }
    
    private static String getPalindrome(){        
        // 홀수인 알파벳을 저장할 변수
        int odd = -1;
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < 27; i++){
            // 없으면 통과
            if(cnt[i] == 0)
                continue;
            
            // 홀수인 알파벳인지 확인
            if(cnt[i] % 2 != 0){
                // 홀수인데 이미 홀수인 알파벳이 있었다면 팰린드롬 못 만든다.
                if(odd >= 0){
                    return "I'm Sorry Hansoo";
                }
                
                odd = i;
            }
            
            // 갯수만큼 sb에 추가
            char temp = (char)(i + 'A');
            while(cnt[i] / 2 > 0){
                sb.insert(idx, temp);
                sb.insert(idx++, temp);
                cnt[i] -= 2;
            }
        }
        
        if(odd >= 0){
            sb.insert(idx, (char)(odd + 'A'));
        }
        
        return sb.toString();       
    }
    
    private static void init() {
        Scanner sc = new Scanner(System.in);
        
        // 영어 이름에 들어있는 알파벳 개수 구하기
        for(char c : sc.nextLine().toCharArray()){
            cnt[c - 'A']++;
        }
    }
}