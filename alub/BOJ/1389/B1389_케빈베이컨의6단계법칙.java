/**
* 메모리: 11884 KB, 시간: 84 ms
* 2022.01.20
* by Alub
*/
import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static List<Integer>[] linked;
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(getMinKevinBacon());
    }
    
    private static int getMinKevinBacon() {        
        // 가장 작은 케빈 베이컨의 수를 가진 사람 구하기
        int idx = 0;
        int min = 100000;
        for(int i = 1; i <= N; i++) {
            // 총 합 구하기
            int sum = getKevinBacon(i);
            
            // 총 합이 이전보다 작으면 
            if(min > sum) {
                idx = i;
                min = sum;
            }
        }
        
        return idx;
    }
    
    private static int getKevinBacon(int idx) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(idx);
        
        boolean[] visited = new boolean[N + 1];
        visited[idx] = true;
        
        int size, cnt = 0, sum = 0;
        while(!que.isEmpty()) {
            size = que.size();
            cnt++;
            while(size-- > 0) {
                int now = que.poll();
            
                // 연결된 사람 확인
                for(int next : linked[now]) {
                    if(visited[next]) {
                        continue;
                    }
                
                    sum += cnt;
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }
        
        return sum;
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        linked = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            linked[i] = new ArrayList<>();
        }
        
        while(M-- > 0) {
            st = new StringTokenizer(in.readLine());
            // 연결되어있는지 여부
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            linked[a].add(b);
            linked[b].add(a);
        }
    }
}