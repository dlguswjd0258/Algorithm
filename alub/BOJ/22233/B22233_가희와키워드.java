/**
* 메모리: 245860 KB, 시간: 1196 ms
* 2022.01.24
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static Set<String> keyword = new HashSet<>();
    static String[] blog;
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(countRemainingWords());
    }
    
    private static String countRemainingWords() {
        StringBuilder sb = new StringBuilder();
        
        for(String letter : blog) {
            StringTokenizer st = new StringTokenizer(letter, ",");
            while(st.hasMoreTokens()) {
                String words = st.nextToken();
                // 블로그에 작성했지만 키워드가 없다면 pass
                if(!keyword.contains(words)) {
                    continue;
                }
                
                // set에 존재하면 제거
                keyword.remove(words);
            }
            
            // 남은 글자 개수 출력
            sb.append(keyword.size()).append("\n");
        }
        
        return sb.toString();
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        while(N-- > 0) {
            keyword.add(in.readLine());
        }
        
        blog = new String[M];
        for(int i = 0; i < M; i++) {
            blog[i] = in.readLine();
        }
    }
}