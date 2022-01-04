/**
* 메모리: 11924 KB, 시간: 100 ms
* 2022.01.04
* by Alub
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		input();
		System.out.println(getRainwater());
	}

	private static int getRainwater() {
		int total = 0, k;

		// 맨 아래부터 벽과 벽사이에 고이는 빗물 세기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 벽 없으면 패스
				if(!map[i][j]) {
					continue;
				}
				
				// 벽있으면 이후에 벽있을 때까지 빗물 세기
				int amount = 0;
				for (k = j + 1; k < W; k++) {
					if(map[i][k]) {
						break;
					}
					
					amount++;
				}
				
				if(k == W) {
					break;
				}
				
				// 이후에 벽이 있었면 amount 추가
				total += amount;
				j = k - 1;
			}
		}
		
		return total;
	}

	private static void input() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new boolean[H][W];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j = 0; j < h; j++) {
				map[j][i] = true;
			}
		}
	}
}