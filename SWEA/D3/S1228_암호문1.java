package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 암호문1
public class S1228_암호문1 {

	static int N, num, x, y;
	static LinkedList<Integer> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" " );
			N = Integer.parseInt(in.readLine());
			
			// 암호문 담기
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreElements()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어 처리하기
			num = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < num; i++) {
				st.nextToken(); // I 날리기
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					if(x > 10) {
						st.nextToken(); // 10 이상은 넣을 필요 없음
						continue;
					}
					
					list.add(x++,Integer.parseInt(st.nextToken()));
				}
			}
			
			// 결과 10개만 출력에 담기
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			
			// list 초기화
			list.clear();
		}
		
		System.out.println(sb.toString());
	}

}
