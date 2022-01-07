/**
* 메모리: 12196 KB, 시간: 84 ms
* 2022.01.07
* by Alub
*/
import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int R, C, K;
    static char[][] map;
    
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(countKDistance(R - 1, 0, 1, new boolean[R][C]));
    }
    
    private static int countKDistance(int r, int c, int dis, boolean[][] visited) {
        // 거리가 K보다 넘어가면 0 리턴
        if(dis > K){
            return 0;
        }
        
        // 도착했는데 거리가 K이면 1 리턴 아니며 0 리턴
        if(r == 0 && c == C - 1){
            if(dis == K){
                return 1;
            }
            
            return 0;
        }
        
        // dfs로 탐색하면서 방문체크하기
        visited[r][c] = true;
        
        int nr, nc, cnt = 0;
        for(int i = 0; i < 4; i++){
            nr = r + dr[i];
            nc = c + dc[i];
            
            if(!isIn(nr,nc) || visited[nr][nc] || map[nr][nc] == 'T'){
                continue;
            }
            
            cnt += countKDistance(nr, nc, dis+1, visited);
        }
        
        visited[r][c] = false;
        return cnt;        
    }
    
    private static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    
    private static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = in.readLine().toCharArray();
        }
    }
}