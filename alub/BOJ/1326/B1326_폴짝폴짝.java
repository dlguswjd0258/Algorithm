/**
* 메모리: 13264 KB, 시간: 116 ms
* 2021.12.10
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    static int N, a, b, bridge[];
    
    public static void main(String[] args) throws Exception {
        init();
        
        // BFS로 a에서 b로 갈 수 있는지 확인하기
        System.out.println(getMinMove());
    }
    
    private static int getMinMove() {
        // a에서 시작
        Queue<Integer> que = new LinkedList<>();
        que.offer(a);
        
        boolean[] visited = new boolean[N];
        visited[a] = true; 
        
        int pos, num, multi, size, move = 0;
        while(!que.isEmpty()){
            size = que.size();
            move++;
            
            while(size-- > 0){
                pos = que.poll();
                num = bridge[pos];
                
                // 현재 숫자의 배수를 que에 담으면서 visited 표시
                for(int i = 1; i*num < N; i++){
                    multi = num*i;
                    // num의 i배수 만큼 앞 혹은 뒤로 뛰었을 때 b라면 move 리턴
                    if(pos + multi == b || pos - multi == b)
                        return move;
                    
                    // 방문한적 없고 multi 만큼 뒤쪽으로 뛰었을 때
                    if(pos + multi < N && !visited[pos+multi]){
                        que.offer(pos+multi);
                        visited[pos+multi] = true;
                    }
                    
                    // 방문한 적 없고 multi 만큼 앞쪽으로 뛰었을 때
                    if(pos >= multi && pos - multi >=0 && !visited[pos-multi]){
                        que.offer(pos-multi);
                        visited[pos-multi] = true;
                    }                    
                }
            }
            
        }
        
        return -1;
    }
    
    private static void init() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        bridge = new int[N];
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(in.readLine());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;
    }
}