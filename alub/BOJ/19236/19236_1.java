/*
* 메모리: 11636 KB, 시간: 80 ms
* 타이머 시간: null
* 2021.11.11
* by Alub
**/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	//민지
	static int N=4, M=16;
	   static class Node{
	      int y,x;
	      int direct;
	      //boolean alive;
	      public Node(int y, int x, int direct) {
	         this.y=y;
	         this.x=x;
	         this.direct=direct;
	         //this.alive=alive;
	      }
	   }
	   static Node[]fish;
	   static Node shark;
	   static int[][]map;
	   //static boolean[][]eat;
	   static int max;
	   static int[][]dydx= {
	         {},
	         {-1,0},
	         {-1,-1},
	         {0,-1},
	         {1,-1},
	         {1,0},
	         {1,1},
	         {0,1},
	         {-1,1},
	   };
	   public static void main(String[] args) throws IOException{
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      
	      fish=new Node[M+1];
	      map=new int[N][N];
	      
	      //eat=new boolean[N][N];
	      
	      for(int y=0;y<N;y++) {
	         st=new StringTokenizer(br.readLine());
	         for(int x=0;x<N;x++) {
	            int num=Integer.parseInt(st.nextToken());
	            int direct=Integer.parseInt(st.nextToken());
	            map[y][x]=num;
	            fish[num]=new Node(y,x,direct);
	         }
	      }
	      shark=new Node(0,0, fish[map[0][0]].direct);
	      solution();
	      System.out.println(max);
	   }
	   
	   static void solution() {
	      dfs(shark.y, shark.x, shark.direct, fish, map, map[shark.y][shark.x]);
	   }
	   
	   static void copyOriginToTemp(Node[]tempFish, int[][]tempMap, Node[]fish, int[][]map) {
	      for(int i=1;i<=M;i++) {
	         tempFish[i]=new Node(fish[i].y, fish[i].x, fish[i].direct);
	      }
	      
	      for(int y=0;y<N;y++) {
	         tempMap[y]=Arrays.copyOf(map[y], N);
	      }
	   }
	   
	   static void dfs(int sharkY, int sharkX, int sharkDirect, Node[]fish, int[][]map, int eatSum) {
	      
	      Node[] tempFish=new Node[M+1];
	      int[][]tempMap=new int[N][N];
	      copyOriginToTemp(tempFish, tempMap, fish, map);
	      
	      //물고기 먹고 방향 바꿔
	      //int num=map[sharkY][sharkX];
	      tempMap[sharkY][sharkX]=0;
	      //sharkDirect=fish[num].direct;
	      //eatSum+=num;
	      
	   
	      //물고기 이동해
	      for(int i=1;i<=16;i++) {
	         Node now=tempFish[i];
	         if(tempMap[now.y][now.x]==0 || tempMap[now.y][now.x] != i)continue;
	         int d=now.direct-1;
	         for(int j=0;j<8;j++) {
	            d++;
	            if(d>8)d=1;
	            int ny=now.y+dydx[d][0];
	            int nx=now.x+dydx[d][1];
	            if(ny<0||nx<0||ny>=N||nx>=N)continue;
	            if(ny==sharkY && nx==sharkX)continue;
	            int temp=tempMap[ny][nx];
	            tempMap[ny][nx]=i;
	            tempMap[now.y][now.x]=temp;
	            
	            tempFish[i]=new Node(ny, nx, d);
	            if(temp>0) {
	               tempFish[temp].y=now.y;
	               tempFish[temp].x=now.x;
	            }else if(temp==0) {
	               
	            }
	         
	            break;
	         }
	      }
	   
	      //상어 이동하고 맵 밖으로 나가야되면 리턴
	      for(int i=1;i<=4;i++) {
	         int ny=sharkY+dydx[sharkDirect][0]*i;
	         int nx=sharkX+dydx[sharkDirect][1]*i;
	         if(ny<0||nx<0||ny>=N||nx>=N ) {
	            if(eatSum>max) {
	               max=eatSum;
	            }
	            return;
	         }
	         if(tempMap[ny][nx]==0)continue;
	         int nd=tempFish[tempMap[ny][nx]].direct;
	         int num=tempMap[ny][nx];
	         
	         
	         
	         dfs(ny,nx, nd, tempFish, tempMap, eatSum+num);
	      }
	      
	   }
	
}
