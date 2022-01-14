/**
* 메모리: 17768 KB, 시간: 176 ms
* 2022.01.14
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    
    static class Point {
        int num, cnt;
        
        public Point(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    static int N, M, a, b;
    static List<Integer>[] link;
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(getMinChange());
    }
    
    private static int getMinChange() {
        // 초기 번호 담기
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(a, 0));
        
        int[] cnt = new int[N+1];
        Arrays.fill(cnt, -1);
        cnt[a] = 0;
        
        while(!que.isEmpty()) {
            // 현재 번호와 현재 번호로 오기까지 치환 개수 받기
            Point now = que.poll();
            
            for(int next : link[now.num]) {
                // 방문한 번호가 아니거나 개수가 더 크다면 값 갱신 후 que에 담기
                if(cnt[next] == -1 || cnt[next] > now.cnt + 1) {
                    cnt[next] = now.cnt + 1;
                    que.offer(new Point(next, cnt[next]));
                }
            }
        }
        
        return cnt[b];
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        link = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            link[i] = new ArrayList<>();
        }
        
        while(M-- > 0){
            st = new StringTokenizer(in.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            link[i].add(j);
			link[j].add(i);
        }
    }
    
}