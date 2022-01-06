/**
* 메모리: 23204 KB, 시간: 308 ms
* 2022.01.06
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static PriorityQueue<Integer> pQue = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        input();    
        System.out.println(getMinCompCnt());
    }
    
    private static int getMinCompCnt() {
        int comp = 0;
        // 카드 수가 작은 것 끼리 더하고 비교 수 구하기
        while(pQue.size() > 1) {
            int sum = pQue.poll() + pQue.poll();
            comp += sum;
            pQue.offer(sum);
        }

        return comp;
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        
        for(int i = 0; i < N; i++) {
            pQue.offer(Integer.parseInt(in.readLine()));
        }
    }
}